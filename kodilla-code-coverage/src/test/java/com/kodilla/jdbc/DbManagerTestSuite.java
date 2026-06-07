package com.kodilla.jdbc;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.AbstractMap;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import java.sql.SQLException;

class DbManagerTestSuite {
    private static DbManager dbManager;

    @BeforeAll
    public static void setup() throws SQLException {
        dbManager = DbManager.getInstance();
    }

    @AfterEach
    public void cleanUp() throws SQLException {
        try (Statement statement = createStatement()) {
            statement.executeUpdate(
                    "DELETE FROM POSTS WHERE BODY IN "
                            + "('Post numer 1', 'Post numer 2', "
                            + "'Post A', 'Post B', 'Post C', "
                            + "'Tylko jeden post')"
            );
            statement.executeUpdate(
                    "DELETE FROM USERS WHERE FIRSTNAME IN "
                            + "('Jan', 'Anna', 'Piotr')"
            );
            statement.executeUpdate(
                    "DELETE FROM USERS WHERE FIRSTNAME IN "
                            + "('Zara', 'Otman', 'Mark', 'Uli', 'Oli')"
            );
        }
    }

    @Test
    void testConnect() {
        Assertions.assertNotNull(dbManager.getConnection());
    }

    @Test
    void testSelectUsers() throws SQLException {
        String countQuery = "SELECT COUNT(*) FROM USERS";
        int count;
        try (Statement statement = createStatement();
             ResultSet rs = statement.executeQuery(countQuery)) {
            count = getRowsCount(rs);
            insertUsers(statement);
        }

        String sqlQuery = "SELECT * FROM USERS";
        int counter;
        try (Statement statement = createStatement();
             ResultSet rs = statement.executeQuery(sqlQuery)) {
            counter = getResultsCount(rs);
        }

        int expected = count + 5;
        Assertions.assertEquals(expected, counter);
    }

    private Statement createStatement() throws SQLException {
        return dbManager.getConnection().createStatement();
    }

    private static final List<AbstractMap.SimpleEntry<String, String>> USERS = List.of(
            new AbstractMap.SimpleEntry<>("Zara", "Ali"),
            new AbstractMap.SimpleEntry<>("Otman", "Use"),
            new AbstractMap.SimpleEntry<>("Mark", "Boq"),
            new AbstractMap.SimpleEntry<>("Uli", "Wimer"),
            new AbstractMap.SimpleEntry<>("Oli", "Kosiw")
    );

    private void insertUsers(Statement statement) throws SQLException {
        for (AbstractMap.SimpleEntry<String, String> user : USERS) {
            String query = String.format(
                    "INSERT INTO USERS(FIRSTNAME, LASTNAME) VALUES ('%s', '%s')",
                    user.getKey(),
                    user.getValue()
            );
            statement.executeUpdate(query);
        }
    }

    private static int getResultsCount(ResultSet rs) throws SQLException {
        int counter = 0;
        while (rs.next()) {
            System.out.printf("%d, %s, %s%n",
                    rs.getInt("ID"),
                    rs.getString("FIRSTNAME"),
                    rs.getString("LASTNAME"));
            counter++;
        }
        return counter;
    }

    private static int getRowsCount(ResultSet rs) throws SQLException {
        int count = 0;
        while (rs.next()) {
            count = rs.getInt("COUNT(*)");
        }
        return count;
    }

    @Test
    void testSelectUsersAndPosts() throws SQLException {
        String countQuery = "SELECT COUNT(*) FROM ("
                + "SELECT U.ID FROM USERS U "
                + "JOIN POSTS P ON U.ID = P.USER_ID "
                + "GROUP BY U.ID HAVING COUNT(*) >= 2) "
                + "AS USERS_WITH_MIN_TWO_POSTS";

        int initialCount = 0;
        try (Statement statement = createStatement();
             ResultSet rs = statement.executeQuery(countQuery)) {
            if (rs.next()) {
                initialCount = rs.getInt(1);
            }
        }

        int userId1;
        int userId2;
        int userId3;

        try (Statement statement = createStatement()) {
            String insUser1 = "INSERT INTO USERS(FIRSTNAME, LASTNAME) "
                    + "VALUES ('Jan', 'Kowalski')";
            statement.executeUpdate(insUser1, Statement.RETURN_GENERATED_KEYS);
            try (ResultSet idRs1 = statement.getGeneratedKeys()) {
                idRs1.next();
                userId1 = idRs1.getInt(1);
            }

            String insPost1 = "INSERT INTO POSTS(USER_ID, BODY) "
                    + "VALUES (" + userId1 + ", 'Post numer 1')";
            String insPost2 = "INSERT INTO POSTS(USER_ID, BODY) "
                    + "VALUES (" + userId1 + ", 'Post numer 2')";
            statement.executeUpdate(insPost1);
            statement.executeUpdate(insPost2);

            String insUser2 = "INSERT INTO USERS(FIRSTNAME, LASTNAME) "
                    + "VALUES ('Anna', 'Nowak')";
            statement.executeUpdate(insUser2, Statement.RETURN_GENERATED_KEYS);
            try (ResultSet idRs2 = statement.getGeneratedKeys()) {
                idRs2.next();
                userId2 = idRs2.getInt(1);
            }

            String insPostA = "INSERT INTO POSTS(USER_ID, BODY) "
                    + "VALUES (" + userId2 + ", 'Post A')";
            String insPostB = "INSERT INTO POSTS(USER_ID, BODY) "
                    + "VALUES (" + userId2 + ", 'Post B')";
            String insPostC = "INSERT INTO POSTS(USER_ID, BODY) "
                    + "VALUES (" + userId2 + ", 'Post C')";
            statement.executeUpdate(insPostA);
            statement.executeUpdate(insPostB);
            statement.executeUpdate(insPostC);

            String insUser3 = "INSERT INTO USERS(FIRSTNAME, LASTNAME) "
                    + "VALUES ('Piotr', 'Zielinski')";
            statement.executeUpdate(insUser3, Statement.RETURN_GENERATED_KEYS);
            try (ResultSet idRs3 = statement.getGeneratedKeys()) {
                idRs3.next();
                userId3 = idRs3.getInt(1);
            }

            String insPostX = "INSERT INTO POSTS(USER_ID, BODY) "
                    + "VALUES (" + userId3 + ", 'Tylko jeden post')";
            statement.executeUpdate(insPostX);
        }

        String sqlQuery = "SELECT U.FIRSTNAME, U.LASTNAME "
                + "FROM USERS U "
                + "JOIN POSTS P ON U.ID = P.USER_ID "
                + "GROUP BY U.ID, U.FIRSTNAME, U.LASTNAME "
                + "HAVING COUNT(*) >= 2";

        int counter = 0;
        System.out.println("Użytkownicy z co najmniej dwoma postami:");

        try (Statement statement = createStatement();
             ResultSet rs = statement.executeQuery(sqlQuery)) {
            while (rs.next()) {
                System.out.printf("%s %s%n",
                        rs.getString("FIRSTNAME"),
                        rs.getString("LASTNAME"));
                counter++;
            }
        }

        int expectedCount = initialCount + 2;
        Assertions.assertEquals(expectedCount, counter);
    }
}
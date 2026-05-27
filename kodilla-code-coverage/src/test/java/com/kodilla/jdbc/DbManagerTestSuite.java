package com.kodilla.jdbc;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.AbstractMap;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import java.sql.SQLException;

class DbManagerTestSuite {
    private static DbManager dbManager;

    @BeforeAll
    public static void setup() throws SQLException {
        dbManager = DbManager.getInstance();
    }

    @Test
    void testConnect() {
        //Given
        //When
        //Then
        Assertions.assertNotNull(dbManager.getConnection());
    }
    @Test
    void testSelectUsers() throws SQLException {
        //Given
        String countQuery = "SELECT COUNT(*) FROM USERS";
        Statement statement = createStatement();
        ResultSet rs = statement.executeQuery(countQuery);
        int count = getRowsCount(rs);
        insertUsers(statement);

        //When
        String sqlQuery = "SELECT * FROM USERS";
        statement = createStatement();
        rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = getResultsCount(rs);
        int expected = count + 5;
        Assertions.assertEquals(expected, counter);

        rs.close();
        statement.close();
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
            statement.executeUpdate(
                    String.format("INSERT INTO USERS(FIRSTNAME, LASTNAME) VALUES ('%s', '%s')",
                            user.getKey(),
                            user.getValue()
                    )
            );
        }
    }

    private static int getResultsCount(ResultSet rs) throws SQLException {
        int counter = 0;
        while(rs.next()) {
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
        // Given
        String countQuery = "SELECT COUNT(*) FROM (" +
                "SELECT U.ID FROM USERS U JOIN POSTS P ON U.ID = P.USER_ID " +
                "GROUP BY U.ID HAVING COUNT(*) >= 2) AS USERS_WITH_MIN_TWO_POSTS";

        Statement statement = createStatement();
        ResultSet rs = statement.executeQuery(countQuery);
        int initialCount = 0;
        if (rs.next()) {
            initialCount = rs.getInt(1);
        }



        statement.executeUpdate("INSERT INTO USERS(FIRSTNAME, LASTNAME) VALUES ('Jan', 'Kowalski')", Statement.RETURN_GENERATED_KEYS);
        ResultSet idRs1 = statement.getGeneratedKeys();
        idRs1.next();
        int userId1 = idRs1.getInt(1);
        statement.executeUpdate("INSERT INTO POSTS(USER_ID, BODY) VALUES (" + userId1 + ", 'Post numer 1')");
        statement.executeUpdate("INSERT INTO POSTS(USER_ID, BODY) VALUES (" + userId1 + ", 'Post numer 2')");

        statement.executeUpdate("INSERT INTO USERS(FIRSTNAME, LASTNAME) VALUES ('Anna', 'Nowak')", Statement.RETURN_GENERATED_KEYS);
        ResultSet idRs2 = statement.getGeneratedKeys();
        idRs2.next();
        int userId2 = idRs2.getInt(1);
        statement.executeUpdate("INSERT INTO POSTS(USER_ID, BODY) VALUES (" + userId2 + ", 'Post A')");
        statement.executeUpdate("INSERT INTO POSTS(USER_ID, BODY) VALUES (" + userId2 + ", 'Post B')");
        statement.executeUpdate("INSERT INTO POSTS(USER_ID, BODY) VALUES (" + userId2 + ", 'Post C')");

        statement.executeUpdate("INSERT INTO USERS(FIRSTNAME, LASTNAME) VALUES ('Piotr', 'Zielinski')", Statement.RETURN_GENERATED_KEYS);
        ResultSet idRs3 = statement.getGeneratedKeys();
        idRs3.next();
        int userId3 = idRs3.getInt(1);
        statement.executeUpdate("INSERT INTO POSTS(USER_ID, BODY) VALUES (" + userId3 + ", 'Tylko jeden post')");

        // When
        String sqlQuery = "SELECT U.FIRSTNAME, U.LASTNAME " +
                "FROM USERS U " +
                "JOIN POSTS P ON U.ID = P.USER_ID " +
                "GROUP BY U.ID, U.FIRSTNAME, U.LASTNAME " +
                "HAVING COUNT(*) >= 2";

        rs = statement.executeQuery(sqlQuery);

        // Then
        int counter = 0;
        System.out.println("Użytkownicy z co najmniej dwoma postami:");
        while (rs.next()) {
            System.out.printf("%s %s%n",
                    rs.getString("FIRSTNAME"),
                    rs.getString("LASTNAME"));
            counter++;
        }

        rs.close();
        statement.close();

        int expectedCount = initialCount + 2;
        Assertions.assertEquals(expectedCount, counter);
    }
}
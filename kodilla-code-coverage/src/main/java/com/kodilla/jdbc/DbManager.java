package com.kodilla.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;

public final class DbManager {
    private final Connection conn;
    private static DbManager dbManagerInstance;

    private DbManager() throws SQLException {
        Properties connectionProps = new Properties();
        connectionProps.put("user", "kodilla");
        connectionProps.put("password", "kodilla");

        String url = "jdbc:mysql://localhost:3306/kodilla_tester"
                + "?serverTimezone=Europe/Warsaw&useSSL=False";

        conn = DriverManager.getConnection(url, connectionProps);
    }

    public static synchronized DbManager getInstance() throws SQLException {
        if (dbManagerInstance == null) {
            dbManagerInstance = new DbManager();
        }
        return dbManagerInstance;
    }

    public Connection getConnection() {
        return Optional.ofNullable(conn).orElse(null);
    }
}
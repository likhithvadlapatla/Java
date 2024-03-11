package com.ge.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {

    static{
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/JDBC", "likhith", "Likhith@31");
    }

    public static void closeConnection(Connection connection, Statement statement) throws SQLException {
        statement.close();
        connection.close();
    }
}

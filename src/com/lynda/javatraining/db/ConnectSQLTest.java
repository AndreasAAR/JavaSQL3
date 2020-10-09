package com.lynda.javatraining.db;

import java.sql.*;
//Database

public class ConnectSQLTest {

    private static final String USERNAME = "dbuser"; //Tyical for SQL api in general
    private static final String PASSWORD = "dbpassword"; //Tyical for SQL api in general
    private static final String CONN_String =
            "jdbc:mysql://localhost/explorecalifornia"; //Required format by driver
    //Remote host would use IP or hostname.

    public static void testSQL() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(CONN_String, USERNAME, PASSWORD);
            System.out.println("Connected!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println(throwables);
        }
        //SQL exception happens if we fail our connection.
        finally {
            if (conn != null) {
                conn.close(); //So we dont write weird stuff to our database
            }
        }

        Statement stmt;
        ResultSet rs;
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rs = stmt.executeQuery("SELECT * FROM states");
        rs.last();
        System.out.println(rs.getRow());
    }
}
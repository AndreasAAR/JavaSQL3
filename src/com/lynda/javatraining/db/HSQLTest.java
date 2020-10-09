package com.lynda.javatraining.db;
import java.sql.*;

public class HSQLTest {
    private static final String USERNAME = "dbuser";
    private static final String PASSWORD = "dbpassword";
    private static final String ACCESS_STRING = "jdbc:hsqldb:data/explorecalifornia" ;

    public static void testHSQL() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(ACCESS_STRING,USERNAME,PASSWORD);
            System.out.println("Connected!");

            Statement stmt;
            ResultSet rs;
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM states");
            rs.last();
            System.out.println("number of rows:" + rs.getRow());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println(throwables);
        }
        //SQL exception happens if we fail our connection.
        finally {
            if(conn != null){
                conn.close(); //So we dont write weird stuff to our database
            }
        }

    }

}

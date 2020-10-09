package com.lynda.javatraining.db;

import java.sql.*;
//Database

public enum DBType{
   HSQDLB, MYSQL
}

public class DataBaseHandler {

    private static final String USERNAME = "dbuser"; //Tyical for SQL api in general
    private static final String PASSWORD ="dbpassword"; //Tyical for SQL api in general
    private static final String M_CONN_STRING =
            "jdbc:mysql://localhost/explorecalifornia"; //Required format by driver
    //Remote host would use IP or hostname.
    private static final String H_CONN_STRING = "jdbc:hsqldb:data/explorecalifornia" ;


    public static Connection createConnection(DBType dbType) throws SQLException {

        switch (dbType){
            case MYSQL:
                return DriverManager.getConnection(M_CONN_STRING,USERNAME,PASSWORD);
            case HSQDLB:
                return  DriverManager.getConnection(H_CONN_STRING,USERNAME,PASSWORD);
            default:
                break;
        }

        return null;
    }


    public static void processException(SQLException e){
        System.err.println("error message"
         + e.getMessage());
        System.err.println("Error code: " + e.getErrorCode());
        System.err.println("Error state: " + e.getSQLState());
    }



}

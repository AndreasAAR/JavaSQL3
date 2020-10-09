package com.lynda.javatraining.db;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        // write your code here
        try {
          //  ConnectSQLTest.testSQL();
              MainClass.testHSQL();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}


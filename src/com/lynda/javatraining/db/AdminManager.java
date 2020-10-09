package com.lynda.javatraining.db;

import javafx.animation.ScaleTransition;
import org.hsqldb.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminManager {

    public static void displayAllRows() throws SQLException{
    String sql = "SELECT adminID, userName, password FROM admin";
    try(
            Connection conn = DataBaseHandler.createConnection((DBType.HSQDLB);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ) {

        System.out.println("Admin table:");
        while(rs.next()){
            StringBuffer bf = new StringBuffer();
            bf.append(rs.getObject("adminID",Integer.class) + " :");
            bf.append(rs.getObject("userName",String.class) + " :");
            bf.append(rs.getObject("password",String.class));
            System.out.println(bf.toString());
        }

    }
    }
}

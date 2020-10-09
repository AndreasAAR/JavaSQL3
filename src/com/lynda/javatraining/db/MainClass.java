package com.lynda.javatraining.db;
import java.sql.*;
import java.sql.PreparedStatement;

public class MainClass {

        private static final String SQL_STMT = "SELECT tourId, tourName, price FROM tours WHERE price <= ? ";

        public static void testHSQL() throws SQLException {
            double maxPrice;
            try{
                maxPrice = InputHelper.getDoubleInput("Enter max price");
            }catch (NumberFormatException ne){
                System.err.println("Invalid number");
                return; //Number was a failure, cant ask database.
            }
            ResultSet rs = null;
            try (
                 Connection   conn = DataBaseHandler.createConnection(DBType.HSQDLB);
                 PreparedStatement  stmt = conn.prepareStatement
                         (SQL_STMT,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    ){
                stmt.setDouble(1,maxPrice);
                rs = stmt.executeQuery(); //Put requests directly in via SQL,
                SQLUtils.displayCharCollumn(rs,"tourname");
                //Best for bandwith!
               // SQLUtils.displayCharCollumn(rs);
            } catch (SQLException throwables) {
                DataBaseHandler.processException(throwables);
            }

        }




}


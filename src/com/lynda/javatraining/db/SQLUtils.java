package com.lynda.javatraining.db;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLUtils {

    public static void displayData(ResultSet resultSet){

          try{
             while(resultSet.next()){
                 StringBuffer my_rows = new StringBuffer();
                 my_rows.append("Row: " + resultSet.getNString("STATEID") + ":");
                 System.out.println(my_rows.toString());
             }
          }catch (SQLException se){
             se.printStackTrace();
          }
    }



}

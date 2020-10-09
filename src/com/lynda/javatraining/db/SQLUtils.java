package com.lynda.javatraining.db;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLUtils {

    public static void displayCharCollumn(ResultSet resultSet){

          try{
             while(resultSet.next()){
                 StringBuffer my_rows = new StringBuffer();
                 my_rows.append("Row: " + resultSet.getNString("STATEID") + ":");
                 System.out.println(my_rows.toString());
             }
              resultSet.last();
              System.out.println("num rows" + resultSet.getRow()    );

          }catch (SQLException se){
             se.printStackTrace();
          }
    }



}

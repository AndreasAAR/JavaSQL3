package com.lynda.javatraining.db;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLUtils {

    public static void displayData(ResultSet resultSet, String colname){
          try{
             while(resultSet.next()){
                // int tourID =  resultSet.getInt(colname) ;
               //  String tourName = resultSet.getString("tourName");
               //  double price = resultSet.getDouble("price");

                 int tourID = resultSet.getObject(colname,Integer.class) ;
                 String tourName = resultSet.getObject("tourName",String.class);
                 BigDecimal price = resultSet.getObject("price",BigDecimal.class);

                 StringBuffer row_output = new StringBuffer();
                 row_output.append("Tour Id: " + tourID + ":");
                 row_output.append(tourName);
                 row_output.append("Price; " + price);
                 System.out.println(row_output.toString());
             }
              resultSet.last();
            //  System.out.println("num rows" + resultSet.getRow()    );
            //  resultSet.first(); (earlier test of dB)
           //   System.out.println("The first entry state NAME is: " +resultSet.getString("stateName"));

          }catch (SQLException se){
             se.printStackTrace();
          }
    }



}

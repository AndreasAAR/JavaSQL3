package com.lynda.javatraining.db;

import com.lynda.javatraining.db.beans.Admin;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        // write your code here
        try {
          //  ConnectSQLTest.testSQL();
            //  MainClass.testHSQL();

           // Admin bean = new Admin();
           // bean.setUserName(InputHelper.getInput("Username:"));
          //  bean.setPassword(InputHelper.getInput("Password:"));
        //    int adminId = InputHelper.getIntegerInput("Select a row:");
        //    boolean result = AdminManager.insert(bean);
       //     if(result){
       //         System.out.println("New admin added with name " + bean.getUserName());
        //    }

            Admin gotBean = AdminManager.getRow(InputHelper.getIntegerInput("Get row"));
            if(gotBean != null){
                System.out.println("Bean: " + gotBean.getUserName());
            }else{
                System.out.println("COuldnt find row!");
            }

            /*
            if(AdminManager.delete(InputHelper.getIntegerInput("Delete an admin"))){

                System.out.println("row found");
            }
            else{
                System.out.println("Couldnt delete");
            }
            */

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


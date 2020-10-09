package com.lynda.javatraining.db.beans;

import com.lynda.javatraining.db.DBType;
import com.lynda.javatraining.db.DataBaseHandler;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin implements Serializable { //Can be instanced in a DB
    // For updating and deleting
    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Represents a row of data
        private int adminID;
        private String userName;
        private String password;

     public static Admin getRow(int adminID) throws SQLException{
         String sql = "SELECT * FROM admin WHERE adminID = ?";
         ResultSet rs = null;
         try{
             Connection conn = DataBaseHandler.createConnection(DBType.HSQDLB);
             PreparedStatement stmt = conn.prepareStatement(sql);
             stmt.setInt(1, adminID);
             rs = stmt.executeQuery();

             if(rs.next()){
                 Admin bean = new Admin();
                 bean.setAdminID(adminID);
                 bean.setUserName(rs.getString("userName"));
                 bean.setPassword(rs.getString("password"));
             }else{
                 System.err.println("No rows were found");
                 return null;
             }


         }catch (SQLException e){
             System.err.println(e);
             return null;
         }finally {
             if(rs != null){
                 rs.close();
             }
         }

     }

}

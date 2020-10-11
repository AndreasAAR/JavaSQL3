package com.lynda.javatraining.db;

import com.lynda.javatraining.db.beans.Admin;

import java.sql.*;

public class AdminManager {

    public static Admin getRow(int adminId) throws SQLException{
        ResultSet rs = null;
        String sql = "SELECT * FROM admin WHERE adminId = ?";
        try(
                Connection conn = DataBaseHandler.createConnection((DBType.HSQDLB));
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setInt(1,adminId);
            rs = stmt.executeQuery();
           if(rs.next()){
                Admin bean = new Admin();
                bean.setAdminID(adminId);
                bean.setUserName(rs.getString("userName"));
               bean.setPassword(rs.getString("password"));
               return  bean;
            }
        }catch (SQLException se){
            System.err.println(se);
        } finally {
            if(rs != null){
                rs.close();
            }
        }
        return null;
    }

    public static boolean delete(int adminID) throws Exception{
        String sql = "DELETE FROM admin WHERE " + "adminID = ?";
        try(
                Connection conn = DataBaseHandler.createConnection(DBType.HSQDLB);
                PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setInt(1,adminID);
            int affectedRows = ps.executeUpdate();
            if(affectedRows == 1){
                return true;
            }
        }catch (SQLException se){
            System.out.println( se);
            return false;
        }finally {
            return true;
        }
    }

    public static boolean update(Admin bean) throws Exception{
        String sql = "UPDATE admin SET " + "userName = ?, password = ?" +
                       "WHERE adminID = ?";
        try(
                Connection conn = DataBaseHandler.createConnection(DBType.HSQDLB);
                PreparedStatement ps = conn.prepareStatement(sql);
                ){
            ps.setString(1,bean.getUserName());
            ps.setString(2,bean.getPassword());
            ps.setInt(3,bean.getAdminID());
           int affectedRows = ps.executeUpdate();
           if(affectedRows == 1){
               return true;
           }
        }catch (SQLException se){
            System.out.println( se);
            return false;
        }finally {
            return true;
        }
    }

    public static boolean insert(Admin bean) throws Exception{
        String sql =  "INSERT into admin (userName, password)" + "(VALUES(?,?))";
        ResultSet keys = null;
        try(
                Connection conn = DataBaseHandler.createConnection(DBType.HSQDLB);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ){
            stmt.setString(1, bean.getUserName());
            stmt.setString(2, bean.getPassword());
            int affectedRows =  stmt.executeUpdate();
            if(affectedRows == 1){
                keys = stmt.getGeneratedKeys();
                keys.next();
                int newKey = keys.getInt(1); //Gets the key from collumn one
                bean.setAdminID(newKey);
                return true;
            }else{
                System.err.println("No rows affected ");
                return false;
            }
        }catch (SQLException se){
            System.err.println(se);
            return false;
        }finally{

        }
    }

    public static void displayAllRows() throws SQLException{
    String sql = "SELECT adminID, userName, password FROM admin";
    try(
            Connection conn = DataBaseHandler.createConnection((DBType.HSQDLB));
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

package com.lynda.javatraining.db;
import java.sql.*;

public class MainClass {


        public static void testHSQL() throws SQLException {
            try (
                 Connection   conn = DataBaseHandler.createConnection(DBType.HSQDLB);
                 Statement  stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                 ResultSet rs = stmt.executeQuery("SELECT stateId, statename FROM states");
                    ) {

                System.out.println("Connected!");

                rs.last();
                System.out.println("number of rows:" + rs.getRow());

            } catch (SQLException throwables) {
                DataBaseHandler.processException(throwables);
            }
            
        }

    }

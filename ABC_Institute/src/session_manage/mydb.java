/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session_manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * 
 */
public class mydb {
    
    private static Connection c;
    private static void createNewConnection()throws Exception {
      
       
    	   if (c == null) {
               Class.forName("com.mysql.cj.jdbc.Driver");
               c = DriverManager.getConnection("jdbc:mysql://151.106.114.2:3306/u271442347_itpm_db_ST", "u271442347_5sEWH", "ItJyON9?6");
           }
          
    }

 public static void iud(String sql) throws Exception {
        if (c == null) {
            createNewConnection();
        }
        c.createStatement().executeUpdate(sql);
    }

public static ResultSet search(String sql) throws Exception {
        if (c == null) {
            createNewConnection();
        }
        return c.createStatement().executeQuery(sql);
    }
 public static Connection getDBCon() throws Exception {
        if (c == null) {
            createNewConnection();
        }
        return c;
    }
public Connection DbPrCon() throws Exception{
     if (c == null) {
            createNewConnection();
        }
        return c;
}

}

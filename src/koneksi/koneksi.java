/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author asus
 */
public class koneksi {
 public static Connection connect; 
 public Statement stm=null;
 public ResultSet rs = null;
 private static String driverName = "oracle.jdbc.driver.OracleDriver";  
 private static String jdbc = "jdbc:oracle:thin:";  
 private static String host = "@localhost:";  
 private static String port = "49701:";  
 private static String SID = "xe";   
 private static String database = "kos";   
 private static String url = jdbc + host + port + SID;  
 private static String username = "kos";   
 private static String password = "asus2020";  
 public static Connection getConnection() throws SQLException {  
   if (connect == null) {  
    try {  
      Class.forName(driverName);  
      System.out.println("Class Driver Ditemukan");  
      try {  
       connect = DriverManager.getConnection(url, username, password);  
       System.out.println("Koneksi Database Sukses");  
      } catch (SQLException se) {  
       System.out.println("Koneksi Database Gagal : " + se);  
       System.exit(0);  
      }  
    } catch (Exception e) {  
      JOptionPane.showMessageDialog(null, "Error  :"+e.getMessage());
        System.exit(0);  
    }  
   }  
   return connect;  
 }
 
 public ResultSet getTampil(String hasil){
   try{
       rs = stm.executeQuery(hasil);
   }catch(Exception e){
       JOptionPane.showMessageDialog(null, e);
   }
     return rs;  
 }
}





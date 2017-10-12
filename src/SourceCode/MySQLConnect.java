/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SourceCode;

/**
 *
 * @author ankur
 */
import java.sql.*;
import javax.swing.*;

public class MySQLConnect {
    
    Connection conn=null;
    public static Connection ConnectDB() 
            //throws Exception
    {
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/spotify?autoReconnect=true&useSSL=false","root","mysql");
      //  JOptionPane.showMessageDialog(null,"Connected to database");    
            return conn;
        }

        catch(Exception e)
        {
          JOptionPane.showMessageDialog(null,e);  
            return null;
            
        }
        
        
        
    }
}

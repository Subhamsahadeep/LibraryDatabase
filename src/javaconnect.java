
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SUBHAM
 */
public class javaconnect {
    Connection conn=null;
    public static Connection ConnecrDb(){
        try
        {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\SUBHAM\\Documents\\NetBeansProjects\\LibraryDatabase\\LibraryDatabase.sqlite");
               //JOptionPane.showMessageDialog(null,"Connection Established");
            return conn;
        }catch(ClassNotFoundException | SQLException e)
                {
                    JOptionPane.showMessageDialog(null,e);
                    return null;
                }
    }
    
}

package Services;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author drhal
 */
public class DBConnector {
 
    
    public static Connection BaglantiGetir(){
         Connection baglanti=null;
         
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
             baglanti=(Connection)
             DriverManager.getConnection("jdbc:mysql://localhost:3306/ogrencitakip", "root", "");             
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }               
     
       return baglanti;
    }
    
    public void Kapat(Connection baglanti){
        try{
            if(baglanti!=null){
                baglanti.close();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }    
}

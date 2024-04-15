/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import DAL.KitapTur;
import java.util.Vector;
import javax.swing.JOptionPane;
/**
 *
 * @author drhal
 */
public class KitapTurService {
    
    public void Ekleme(String adi){
    
        String query = "insert into kitaptur(Ad) values(?) ";
        
        try{
            Connection con=new DBConnector().BaglantiGetir();
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt=con.prepareStatement(query);
            preparedStmt.setString(1, adi);
            
            preparedStmt.execute();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    
    public void Guncelleme(int ID, String adi){
    String query = "update kitaptur set Ad=? WHERE ID=?";
    
    try{
         Connection con=new DBConnector().BaglantiGetir();
        Statement stm = (Statement) con.createStatement();
        PreparedStatement preparedStmt=con.prepareStatement(query);
        preparedStmt.setString(1, adi);
        preparedStmt.setInt(2,ID);
        
        preparedStmt.execute();
        
        }catch(Exception ex){
            ex.printStackTrace();
        }    
    }
    
    public void Silme(int ID){
    
        String query = "delete from kitaptur WHERE ID=?";
        
        try{
            
             Connection con=new DBConnector().BaglantiGetir();
             Statement stm = (Statement) con.createStatement();
             PreparedStatement preparedStmt=con.prepareStatement(query);
             preparedStmt.setInt(1,ID);
            
             preparedStmt.execute();
             
        }catch(Exception ex){
            ex.printStackTrace();
        }  
        
    }
    
     public DefaultTableModel Getir(DefaultTableModel model){
         model.getDataVector().removeAllElements();
         Statement stmt=null;   
         String sorgu="select ID, Ad from kitaptur ";
         
         try{
             
              Connection con=new DBConnector().BaglantiGetir();
              stmt=con.createStatement();
              ResultSet rs=stmt.executeQuery(sorgu);
              
              while(rs.next()){
                  
                  int ID=rs.getInt(1);
                  String adi=rs.getString(2);
                  
                  model.addRow(new Object[]{ID,adi});
                  
              }             
         }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
               if(stmt!=null){
                  stmt.close();
               }
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        } 
         
         return model;
     }
     
     public DefaultTableModel AzalanSekildeGetir(DefaultTableModel model){
         model.getDataVector().removeAllElements();
         Statement stmt=null;   
         String sorgu="select ID, Ad from kitaptur Order BY ID DESC";
         
         try{
             
              Connection con=new DBConnector().BaglantiGetir();
              stmt=con.createStatement();
              ResultSet rs=stmt.executeQuery(sorgu);
              
              while(rs.next()){
                  
                  int ID=rs.getInt(1);
                  String adi=rs.getString(2);
                  
                  model.addRow(new Object[]{ID,adi});
                  
              }             
         }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
               if(stmt!=null){
                  stmt.close();
               }
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        } 
         
         return model;
     }
     
     public ArrayList<KitapTur> Yukle(DefaultComboBoxModel model){
         model.removeAllElements();
         model.addElement(new Mesajlar().SeciminiziYapiniz());
         Statement stmt=null;
         String sorgu="select ID, Ad from kitaptur";
         ArrayList<KitapTur> kitapTurListesi=new ArrayList<>();
          try{
              Connection con=new DBConnector().BaglantiGetir();
              stmt=con.createStatement();
              ResultSet rs=stmt.executeQuery(sorgu);              
              KitapTur kitapTur;
              
              int sayac=0;
               while(rs.next()){
                  
                  int ID=rs.getInt(1);
                  String adi=rs.getString(2);
                  
                  kitapTur=new KitapTur(ID,adi);
                  kitapTurListesi.add(kitapTur); 
                  
                  model.addElement(adi);                 
              }         
          
          }catch(Exception ex){
              ex.printStackTrace();
          }
          
          return kitapTurListesi;          
     }
     
     public int GetID(ArrayList<KitapTur> kitapTurListesi,int index){
        KitapTur kitapTur= kitapTurListesi.get(index);        
        return kitapTur.getID();
     }    
     
     
     public String GetKitapTurByID(int kitapTurID, Connection con, Statement stmt){
         //transaction 
         //innodb 
         
         String sorgu="select Ad from kitaptur WHERE ID=?";
         
         String ad="";
         
         try{
            PreparedStatement preparedStmt=con.prepareStatement(sorgu);
            preparedStmt.setInt(1, kitapTurID);
            ResultSet rs=preparedStmt.executeQuery();
            
            
             if(rs.next()){
                 String adi=rs.getString(1);                 
                 ad=adi;                
             }
            
         }catch(Exception ex){
             JOptionPane.showMessageDialog(null, "Veritabanı Getirme Hatası");
         }
         
         return ad;
         
     }
}

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
import DAL.Kitap;
import java.util.Vector;
import javax.swing.JOptionPane;
/**
 *
 * @author drhal
 */
public class KitapService {
    
    public void Ekleme(String ISBNo, String ad,int sayfaSayisi, int kitapYazarID, int kitapTurID){
    
        String query = "insert into kitap(ISBNo, Ad,SayfaSayisi,KitapYazarID,KitapTurID) values(?,?,?,?,?) ";
        
        try{
            Connection con=new DBConnector().BaglantiGetir();
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt=con.prepareStatement(query);
            preparedStmt.setString(1, ISBNo);
            preparedStmt.setString(2, ad);
            preparedStmt.setInt(3, sayfaSayisi);
            preparedStmt.setInt(4, kitapYazarID);
            preparedStmt.setInt(5, kitapTurID);
            
            preparedStmt.execute();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    
    public void Guncelleme(int ID, String ISBNo, String ad, int sayfaSayisi, int kitapYazarID, int kitapTurID){
    String query = "update kitap set ISBNo=?, Ad=?, SayfaSayisi=?, KitapYazarID=?,KitapTurID=?  WHERE ID=?";
    
    try{
         Connection con=new DBConnector().BaglantiGetir();
        Statement stm = (Statement) con.createStatement();
        PreparedStatement preparedStmt=con.prepareStatement(query);
        preparedStmt.setString(1, ISBNo);
        preparedStmt.setString(2, ad);
        preparedStmt.setInt(3,sayfaSayisi);
        preparedStmt.setInt(4,kitapYazarID);
        preparedStmt.setInt(5, kitapTurID);
        preparedStmt.setInt(6, ID);
        
        preparedStmt.execute();
        
        }catch(Exception ex){
            ex.printStackTrace();
        }    
    }
    
    public void Silme(int ID){
    
        String query = "delete from kitap WHERE ID=?";
        
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
         String sorgu="select ID,ISBNo, Ad,SayfaSayisi,KitapYazarID,KitapTurID from kitap ";
         
         try{
             
              Connection con=new DBConnector().BaglantiGetir();
              stmt=con.createStatement();
              ResultSet rs=stmt.executeQuery(sorgu);
              
              while(rs.next()){
                  
                  int ID=rs.getInt(1);
                  String ISBNo=rs.getString(2);
                  String ad=rs.getString(3);
                  int sayfaSayisi=rs.getInt(4);
                  int kitapYazarID=rs.getInt(5);
                  int kitapTurID=rs.getInt(6);
                  
                  
                  
                  String kitapYazarAdSoyad=new KitapYazarService().GetKitapYazarByID(kitapYazarID, con, stmt);                  
                  String kitapTurAdi=new KitapTurService().GetKitapTurByID(kitapTurID, con, stmt);
                  
                  model.addRow(new Object[]{ID,ISBNo,ad,sayfaSayisi,kitapYazarAdSoyad,kitapTurAdi});
                  
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
     
     public ArrayList<Kitap> Yukle(DefaultComboBoxModel model){
         model.removeAllElements();
         model.addElement(new Mesajlar().SeciminiziYapiniz());
         Statement stmt=null;
         String sorgu="select ID,ISBNo, Ad,SayfaSayisi,KitapYazarID,KitapTurID from kitap ";
         ArrayList<Kitap> kitapListesi=new ArrayList<>();
          try{
              Connection con=new DBConnector().BaglantiGetir();
              stmt=con.createStatement();
              ResultSet rs=stmt.executeQuery(sorgu);              
              Kitap kitap;
              
              int sayac=0;
               while(rs.next()){
                  
                  int ID=rs.getInt(1);
                  String ISBNo=rs.getString(2);
                  String ad=rs.getString(3);
                  int sayfaSayisi=rs.getInt(4);
                  int kitapYazarID=rs.getInt(5);
                  int kitapTurID=rs.getInt(6);
                  
                  kitap=new Kitap(ID,ISBNo,ad,sayfaSayisi,kitapYazarID,kitapTurID);
                  kitapListesi.add(kitap);  
                  
                  model.addElement(ad);                 
              }         
          
          }catch(Exception ex){
              ex.printStackTrace();
          }
          
          return kitapListesi;          
     }
     
     public int GetID(ArrayList<Kitap> kitapListesi,int index){
        Kitap kitap= kitapListesi.get(index);        
        return kitap.getID();
     }
     
     
     public int[] GetKitapYazarTurByID(int ID){
         int[] kitapYazarTur=new int[2];
         Statement stmt=null;
         String sorgu="select KitapYazarID,KitapTurID from kitap WHERE ID=? ";
         ArrayList<Kitap> kitapListesi=new ArrayList<>();
         
         try{
              Connection con=new DBConnector().BaglantiGetir();
              stmt=con.createStatement();
              
              PreparedStatement preparedStmt=con.prepareStatement(sorgu);
              preparedStmt.setInt(1,ID);
             
              ResultSet rs=preparedStmt.executeQuery();
              Kitap kitap;
              
              if(rs.next()){
                  int kitapYazarID=rs.getInt(1);
                  int kitapTurID=rs.getInt(2);
                  
                  

                  kitapYazarTur[0]=kitapYazarID;
                  kitapYazarTur[1]=kitapTurID;
              }
              
              
          }catch(Exception ex){
              JOptionPane.showMessageDialog(null, ex.toString());
          }
          
          return kitapYazarTur;
     }
     
}

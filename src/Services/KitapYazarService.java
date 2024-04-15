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
import DAL.KitapYazar;
import java.awt.JobAttributes;
import java.util.Vector;
import javax.swing.JOptionPane;
/**
 *
 * @author drhal
 */
public class KitapYazarService {    
    public boolean Ekleme(String adi, String soyadi,String TCKimlikNo){    
        String query = "insert into kitapyazar(Ad, Soyad,TCKimlikNo) values(?,?,?) ";
        boolean result=false;
        try{
            Connection con=new DBConnector().BaglantiGetir();
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt=con.prepareStatement(query);
            preparedStmt.setString(1, adi);
            preparedStmt.setString(2, soyadi);
            preparedStmt.setString(3, TCKimlikNo);
            
            result=preparedStmt.execute();
        }catch(Exception ex){
            ex.printStackTrace();
        }        
        return result;        
    }
    
    public boolean Guncelleme(int ID, String adi, String soyadi,String TCKimlikNo){
    String query = "update kitapyazar set Ad=?, Soyad=?, TCKimlikNo=? WHERE ID=?";
    
    boolean result=false;
    try{
        Connection con=new DBConnector().BaglantiGetir();
        Statement stm = (Statement) con.createStatement();
        PreparedStatement preparedStmt=con.prepareStatement(query);
        preparedStmt.setString(1, adi);
        preparedStmt.setString(2, soyadi);
        preparedStmt.setString(3,TCKimlikNo);
        preparedStmt.setInt(4,ID);
        
        result=preparedStmt.execute();
        
        }catch(Exception ex){
            ex.printStackTrace();
        }    
    
     return result;
    }
    
    public boolean Silme(int ID){
    
        String query = "delete from kitapyazar WHERE ID=?";
        
        boolean result=false;
        try{
            
             Connection con=new DBConnector().BaglantiGetir();
             Statement stm = (Statement) con.createStatement();
             PreparedStatement preparedStmt=con.prepareStatement(query);
             preparedStmt.setInt(1,ID);
            
             result=preparedStmt.execute();
             
        }catch(Exception ex){
            ex.printStackTrace();
        }  
        
        return result;
    }
    
    public DefaultTableModel Getir(DefaultTableModel model){
         model.getDataVector().removeAllElements();
         Statement stmt=null;   
         String sorgu="select ID, Ad, Soyad,TCKimlikNo from kitapyazar ";
         
         try{
             
              Connection con=new DBConnector().BaglantiGetir();
              stmt=con.createStatement();
              ResultSet rs=stmt.executeQuery(sorgu);
              
              while(rs.next()){
                  
                  int ID=rs.getInt(1);
                  String adi=rs.getString(2);
                  String soyadi=rs.getString(3);
                  String TCKimlikNo=rs.getString(4);
                  
                  model.addRow(new Object[]{ID,adi,soyadi,TCKimlikNo});
                  
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
     
    
    public ArrayList<KitapYazar> Yukle(DefaultComboBoxModel model){
         model.removeAllElements();
         model.addElement(new Mesajlar().SeciminiziYapiniz());
         Statement stmt=null;
         String sorgu="select ID, Ad, Soyad,TCKimlikNo from kitapyazar ";
         ArrayList<KitapYazar> kitapYazarListesi=new ArrayList<>();
          try{
              Connection con=new DBConnector().BaglantiGetir();
              stmt=con.createStatement();
              ResultSet rs=stmt.executeQuery(sorgu);              
              KitapYazar kitapYazar;
              
              int sayac=0;
               while(rs.next()){
                  
                  int ID=rs.getInt(1);
                  String adi=rs.getString(2);
                  String soyadi=rs.getString(3);
                  String TCKimlikNo=rs.getString(4);
                  
                  kitapYazar=new KitapYazar(ID,adi,soyadi,TCKimlikNo);
                  kitapYazarListesi.add(kitapYazar); //Asım dinçer ID=0, Muhammet Furkan Tuna ID=1, Özgür Keklik ID=2, Özgür Keklik ID=3  
                  
                  model.addElement(adi+" "+soyadi);                 
              }         
          
          }catch(Exception ex){
              ex.printStackTrace();
          }
          
          return kitapYazarListesi;          
     }
     
    public int GetID(ArrayList<KitapYazar> kitapYazarListesi,int index){
        KitapYazar kitapYazar= kitapYazarListesi.get(index);        
        return kitapYazar.getID();
     }    
     
     
    public String GetKitapYazarByID(int kitapYazarID, Connection con, Statement stmt){
         //transaction 
         //innodb 
         
         String sorgu="select Ad, Soyad from kitapyazar WHERE ID=?";
         
         String adSoyad="";
         
         try{
            PreparedStatement preparedStmt=con.prepareStatement(sorgu);
            preparedStmt.setInt(1, kitapYazarID);
            ResultSet rs=preparedStmt.executeQuery();
            
            
             while(rs.next()){
                 String adi=rs.getString(1);
                 String soyadi=rs.getString(2);
                 
                 adSoyad=adi+" "+soyadi;
                 
             }
            
         }catch(Exception ex){
             JOptionPane.showMessageDialog(null, "Veritabanı Getirme Hatası"+ex.toString());
         }
         
         return adSoyad;
         
     }
     
      
}

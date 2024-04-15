/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/**
 *
 * @author drhal
 */
public class Mesajlar {
    
   public String SatirSeciniz(){
       return "Lütfen Satır Seçiniz.";
   }
   public String SeciminiziYapiniz(){
       return "Lütfen Seçiminizi Yapınız.";
   }
   
   public String KitapTurSeciminiziYapiniz(){
       return "Lütfen Kitap Tür Seçiminizi Yapınız.";
   }
   
   public String KitapYazarSeciminiziYapiniz(){
       return "Lütfen Kitap Yazar Seçiminizi Yapınız.";
   }
   
   public String IslemBasarisiz(){
       return "İşlem Başarısız";
   }
   
   public String SayfaSayisiGiriniz(){
       return "Lütfen Kitabın Sayfa Sayısını Giriniz";
   }
   
   public boolean sayisalMi(String s) {  
    return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
   } 
   
   public String GecerliSayfaSayisiGiriniz(){   
       return "Lütfen Geçerli Bir Sayfa Sayısı Giriniz";
   }
}

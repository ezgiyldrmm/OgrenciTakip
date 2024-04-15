/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

/**
 *
 * @author drhal
 */
public class KitapYazar {
    
    public int ID;
    public String Ad;
    public String Soyad;
    public String TCKimlikNo;
 
    public KitapYazar() {
    }

    public KitapYazar(int ID, String Ad, String Soyad, String TCKimlikNo) {
        this.ID = ID;
        this.Ad = Ad;
        this.Soyad = Soyad;
        this.TCKimlikNo = TCKimlikNo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAd() {
        return Ad;
    }

    public void setAd(String Ad) {
        this.Ad = Ad;
    }

    public String getSoyad() {
        return Soyad;
    }

    public void setSoyad(String Soyad) {
        this.Soyad = Soyad;
    }

    public String getTCKimlikNo() {
        return TCKimlikNo;
    }

    public void setTCKimlikNo(String TCKimlikNo) {
        this.TCKimlikNo = TCKimlikNo;
    } 
    
}

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
public class Kitap {
    
    public int ID;
    public String ISBNo;
    public String Ad;
    public int SayfaSayisi;
    public int KitapYazarID;
    public int KitapTurID;

    public Kitap() {
    }

    public Kitap(int ID, String ISBNo, String Ad, int SayfaSayisi, int KitapYazarID, int KitapTurID) {
        this.ID = ID;
        this.ISBNo = ISBNo;
        this.Ad = Ad;
        this.SayfaSayisi = SayfaSayisi;
        this.KitapYazarID = KitapYazarID;
        this.KitapTurID = KitapTurID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getISBNo() {
        return ISBNo;
    }

    public void setISBNo(String ISBNo) {
        this.ISBNo = ISBNo;
    }

    public String getAd() {
        return Ad;
    }

    public void setAd(String Ad) {
        this.Ad = Ad;
    }

    public int getSayfaSayisi() {
        return SayfaSayisi;
    }

    public void setSayfaSayisi(int SayfaSayisi) {
        this.SayfaSayisi = SayfaSayisi;
    }

    public int getKitapYazarID() {
        return KitapYazarID;
    }

    public void setKitapYazarID(int KitapYazarID) {
        this.KitapYazarID = KitapYazarID;
    }

    public int getKitapTurID() {
        return KitapTurID;
    }

    public void setKitapTurID(int KitapTurID) {
        this.KitapTurID = KitapTurID;
    }
    
    
    
}

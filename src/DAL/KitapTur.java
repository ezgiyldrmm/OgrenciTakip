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
public class KitapTur {
    
    public int ID;
    public String Ad;

    public KitapTur() {
    }

    public KitapTur(int ID, String Ad) {
        this.ID = ID;
        this.Ad = Ad;
    }

    public int getID() {
        return ID;
    }

    public String getAd() {
        return Ad;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setAd(String Ad) {
        this.Ad = Ad;
    } 
    
}

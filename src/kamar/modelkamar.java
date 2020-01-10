/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kamar;

/**
 *
 * @author asus
 */
public class modelkamar {
    private String id_kamar;
    private String no_kamar;
    private String fasilitas;
    private String harga;
    
    public modelkamar(){
        
    }


    public modelkamar(String id_kamar, String no_kamar, String harga, String fasilitas){
        this.id_kamar = id_kamar;
        this.no_kamar = no_kamar;
        this.harga = harga;
        this.fasilitas = fasilitas;
    }
    
    public void setID(String id_kamar){
        this.id_kamar = id_kamar;
    }
    
    public void setNokamar(String no_kamar){
        this.no_kamar=no_kamar;
    }
    
    public void setFasilita(String fasilitas){
        this.fasilitas=fasilitas;
    }
    
    public void setHarga(String harga){
        this.harga=harga;
    }
    
    public String getID(){
        return id_kamar;
    }
    
    public String getNokamar(){
        return no_kamar;
    }
    
    public String getFasilita(){
        return fasilitas;
    }
    
    public String getHarga(){
        return harga;
    }
}

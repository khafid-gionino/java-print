/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendaftaran;

/**
 *
 * @author asus
 */
public class modelpendaftaran {
    private String idpendaftaran;
    public pelanggan.modelpelanggan plg;
    private String nama;
    private String no_kamar;
    private String fasilitas;
    private String harga;
    private String tglpendaftaran;
    
    public modelpendaftaran(){
        
    }
    
    
    public modelpendaftaran(String idpendaftaran, String nama, String no_kamar, String fasilitas, String harga, String tglpendaftaran){
        this.idpendaftaran = idpendaftaran;
        this.nama = nama;
        this.no_kamar = no_kamar;
        this.fasilitas = fasilitas;
        this.harga = harga;
        this.tglpendaftaran = tglpendaftaran;
        
    }
    
    public void setID(String idpendaftaran){
        this.idpendaftaran=idpendaftaran;
    }
    
    
    private void setIDKamar(String idkamar){
        this.no_kamar = no_kamar;
    }
    
    private void setNama(String nama){
        this.nama = nama;
    }
    
    private void setfasilitas(String fasilitas){
        this.fasilitas = fasilitas;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setTgldaftar(String tglpendaftaran){
        this.tglpendaftaran=tglpendaftaran;
    }
    
    public String getID(){
        return idpendaftaran;
    }
    
//    public String getIDPelanggan(){
//        return idpelanggan;
//    }
    
    public String getNoKamar(){
        return no_kamar;
    }
    
    public String getTgldaftar(){
        return tglpendaftaran;
    }
    
    public String getFasilitas(){
        return fasilitas;
    }
    
    public String getHarga(){
        return harga;
    }
    
}

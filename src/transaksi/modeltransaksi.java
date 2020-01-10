/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaksi;

/**
 *
 * @author asus
 */
public class modeltransaksi {
    private String id_transaksi;
    public pendaftaran.modelpendaftaran pdf;
    private String id_pendaftaran;
    private String tgl_transaksi;
    private String status;
    private String bayar;
    
    public modeltransaksi(){
        
    }
    
    public modeltransaksi(String id_transaksi,String id_pendaftaran,  String bayar, String status, String tgl_transaksi){
        this.id_transaksi = id_transaksi;
        this.id_pendaftaran =id_pendaftaran;
        this.tgl_transaksi = tgl_transaksi;
        this.status = status;
        this.bayar = bayar;
    }
    
    public void setId_transaksi(String id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public void setBayar(String bayar) {
        this.bayar = bayar;
    }

    public String getBayar() {
        return bayar;
    }

    public String getId_pendaftaran() {
        return id_pendaftaran;
    }
    
    
    
//    public void setId_pendaftaran(String id_pendaftaran) {
//        this.id_pendaftaran = id_pendaftaran;
//    }

  

    public void setTgl_transaksi(String tgl_transaksi) {
        this.tgl_transaksi = tgl_transaksi;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId_transaksi() {
        return id_transaksi;
    }

    public String getStatus() {
        return status;
    }

    public String getTgl_transaksi() {
        return tgl_transaksi;
    }
    
}

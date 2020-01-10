/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelanggan;

/**
 *
 * @author asus
 */
public class modelpelanggan {
    private Integer id_pelanggan;
    private String nama;
    private String alamat;
    private String email;
    private String no_tlp;
    private String kodepos;
    private String password;
    
       public modelpelanggan(){
        
    }
    
    public modelpelanggan(Integer id_pelanggan, String nama, String alamat, String email, String no_tlp, String kode_pos, String password){
        this.id_pelanggan =id_pelanggan;
        this.nama = nama;
        this.alamat = alamat;
        this.email = email;
        this.no_tlp = no_tlp;
        this.kodepos = kode_pos;
        this.password = password;
    }
    
 
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public int getID(){
        return id_pelanggan;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getEmail() {
        return email;
    }

    public String getKodepos() {
        return kodepos;
    }

    public String getNoHp() {
        return no_tlp;
    }

    public String getPassword() {
        return password;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setKodepos(String kodepos) {
        this.kodepos = kodepos;
    }

    public void setNoHp(String noHp) {
        this.no_tlp = noHp;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}

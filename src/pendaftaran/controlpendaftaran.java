/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendaftaran;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import koneksi.koneksi;
import object.object;
import pendaftaran.controlpendaftaran;

/**
 *
 * @author asus
 */
public class controlpendaftaran extends AbstractTableModel{
    ArrayList<modelpendaftaran> listpendaftaran = new ArrayList<modelpendaftaran>();
        
    public controlpendaftaran(){
        try{
            String sql = "select pendaftaran.id_pendaftaran, pelanggan.nama, kamar.nomor_kamar,"
                            + " kamar.fasilitas, kamar.harga, pendaftaran.tgl_pendaftaran from pendaftaran\n" +
                            "  join pelanggan on pendaftaran.id_pelanggan = pelanggan.id_pelanggan\n" +
                            "  join kamar on pendaftaran.id_kamar = kamar.id_kamar\n" +
                            "  ";
            PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);

                ResultSet rs = statement.executeQuery();

                while (rs.next()) {
                    modelpendaftaran mp = new modelpendaftaran(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6));
                    listpendaftaran.add(mp);
                }
                
        }catch(Exception e){
            
        }
    }
        
        
    public modelpendaftaran getModelPendaftaran(int index){
        return listpendaftaran.get(index);
    }
    
    public void insertObj(String idpendaftaran,  String nama, String no_kamar, String fasilitas, String harga, String tglpendaftaran){
        listpendaftaran.add(new modelpendaftaran(idpendaftaran,  nama, no_kamar, fasilitas, harga, tglpendaftaran));
        fireTableRowsInserted(getRowCount()-1,getRowCount()-1);
    }
    
    public void update(modelpendaftaran mp, int index){
         listpendaftaran.add(index, mp);
         fireTableRowsUpdated(index, index);
     }
     
     public void delete(int index){
         listpendaftaran.remove(index);
         fireTableRowsDeleted(index, index);
     }
     
     public boolean insertDB(String id_pendaftaran, String id_pelanggan, String no_kamar, String tgl_daftar){
         String sql = "insert into pendaftaran values("
                    +id_pendaftaran+","
                    +id_pelanggan+","
                    +no_kamar+","
                    +"to_date('"+tgl_daftar+"','dd/mm/yyyy'))";
        try {
            PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);

            int row = statement.executeUpdate();

            if (row > 0) {
                return true;
            }
            statement.close();
        } catch (Exception ex) {
            Logger.getLogger(modelpendaftaran.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false; 
     }
     
     public boolean deleteDB(modelpendaftaran mp) {
        String sql = "DELETE from pendaftaran where id_pendaftaran ="+mp.getID()+"";
        try {
            PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
            
            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
            
            statement.close();
        } catch (Exception ex) {
            Logger.getLogger(modelpendaftaran.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public int getRowCount() {
        return listpendaftaran.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
        case 0:
            return listpendaftaran.get(rowIndex).getID();
        case 1:
            return listpendaftaran.get(rowIndex).getNama();
        case 2:
            return listpendaftaran.get(rowIndex).getNoKamar();
        case 3:
            return listpendaftaran.get(rowIndex).getFasilitas();
        case 4:
            return listpendaftaran.get(rowIndex).getHarga();
        case 5:
            return listpendaftaran.get(rowIndex).getTgldaftar();
        default:
            return null;
    }
    
    }
    
    @Override
     public String getColumnName(int column){
        switch(column){
        case 0:
        return ("ID PENDAFTARAN");
        case 1:
        return("NAMA");
        case 2:
        return("NO. KAMAR");
        case 3:
        return("FASILITAS");
        case 4:
        return("HARGA");
        case 5:
        return("TGL DAFTAR");
        default:
        return null;
}
}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kamar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import koneksi.koneksi;
import object.object;
import kamar.modelkamar;

/**
 *
 * @author asus
 */
public class controlkamar extends AbstractTableModel{
    ArrayList<modelkamar> listkamar = new ArrayList<modelkamar>();
    
    
    public controlkamar(){
        try{
            String sql = "SELECT * FROM kamar";
            PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);

                ResultSet rs = statement.executeQuery();

                while (rs.next()) {
                    modelkamar mk = new modelkamar(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4));
                    
                    listkamar.add(mk);
                }
        }catch(Exception e){
            Logger.getLogger(controlkamar.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public modelkamar getModelkamar(int index){
         return listkamar.get(index);
         
     }
     
     public void insertObj(String id_kamar, String no_kamar, String harga, String fasilitas){
         listkamar.add(new modelkamar(id_kamar, no_kamar, harga, fasilitas));
         fireTableRowsInserted(getRowCount()-1,getRowCount()-1);
     }
     
     public void update(modelkamar mk, int index){
         listkamar.add(index, mk);
         fireTableRowsUpdated(index, index);
     }
     
     public void delete(int index){
         listkamar.remove(index);
         fireTableRowsDeleted(index, index);
     }
     
     public boolean insertDB(String id_kamar, String no_kamar, String fasilitas, String harga){
         String sql = "INSERT INTO kamar values ("+id_kamar+", '" + no_kamar + "', '" + harga + "', '" + fasilitas + "')";
        try {
            PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);

            int row = statement.executeUpdate();

            if (row > 0) {
                return true;
            }
            statement.close();
        } catch (Exception ex) {
            Logger.getLogger(modelkamar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false; 
     }
     
     public boolean updateDB(modelkamar mk) {
        String sql = "UPDATE kamar SET nomor_kamar='"+mk.getNokamar()+"' , harga='"+mk.getHarga()+"', fasilitas='"+mk.getFasilita()+"' where id_kamar="+mk.getID()+"";
        try {
            PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
            
            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
            
            statement.close();
        } catch (Exception ex) {
            Logger.getLogger(modelkamar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     
     public boolean deleteDB(modelkamar mk) {
        String sql = "DELETE from kamar where id_kamar="+mk.getID()+"";
        try {
            PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
            
            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
            
            statement.close();
        } catch (Exception ex) {
            Logger.getLogger(modelkamar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public int getRowCount() {
        return listkamar.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    switch(columnIndex){
        case 0:
            return listkamar.get(rowIndex).getID();
        case 1:
            return listkamar.get(rowIndex).getNokamar();
        case 2:
            return listkamar.get(rowIndex).getFasilita();
        case 3:
            return listkamar.get(rowIndex).getHarga();
        default:
            return null;
    }
    
}
    
     @Override
     public String getColumnName(int column){
        switch(column){
        case 0:
        return ("id");
        case 1:
        return("nomor kamar");
        case 2:
        return("fasilitas");
        case 3:
        return("harga");
        default:
        return null;
}
}
}
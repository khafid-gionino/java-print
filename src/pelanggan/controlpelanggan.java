/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelanggan;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.naming.spi.DirStateFactory;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.table.AbstractTableModel;
import koneksi.koneksi;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import object.object;

/**
 *
 * @author asus
 */
public class controlpelanggan extends AbstractTableModel{
     
    ArrayList<modelpelanggan> listpelanggan = new ArrayList<modelpelanggan>();
    int inc;
    
    public controlpelanggan(){
        this.inc = loadInc();

        try {
                String sql = "SELECT * FROM pelanggan";
                PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
                ResultSet rs = statement.executeQuery();

                while (rs.next()) {
                    modelpelanggan mp = new modelpelanggan(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7));
                    
                    listpelanggan.add(mp);
                }

                statement.close();
        } catch (Exception ex) {
            Logger.getLogger(controlpelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<modelpelanggan> view(){
       return listpelanggan;
    }
    
    public modelpelanggan getModelpelanggan(int index){
         return listpelanggan.get(index);
     }
     
     public void insertObj(Integer inc, String nama, String alamat, String email, String no_tlp, String kode_pos, String password){
         listpelanggan.add(new modelpelanggan(inc, nama, alamat, email, no_tlp, kode_pos, password));
         fireTableRowsInserted(getRowCount()-1,getRowCount()-1);
     }
     
     public void insertObj2(String nama, String alamat, String email, String no_tlp, String kode_pos, String password){
         System.out.print("" + this.inc);
         this.inc = this.inc + 1;
         System.out.print("" + this.inc);
         listpelanggan.add(new modelpelanggan(inc, nama, alamat, email, no_tlp, kode_pos, password));
         fireTableRowsInserted(getRowCount()-1,getRowCount()-1);
     }
     
     public boolean insertDB(String nama, String alamat, String email, String no_tlp, String kode_pos, String password){
         String sql = "INSERT INTO pelanggan values (id_pelanggan.nextval, '" + nama + "', '" + alamat + "', '" + email + "', '" + no_tlp + "', '" + kode_pos + "', '" + password + "')";
        try {
            PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);

            int row = statement.executeUpdate();

            if (row > 0) {
                return true;
            }
            statement.close();
        } catch (Exception ex) {
            Logger.getLogger(modelpelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false; 
     }
     
     public boolean updateDB(modelpelanggan mp) {
        String sql = "UPDATE pelanggan SET nama='"+mp.getNama()+"' , alamat='"+mp.getAlamat()+"', email='"+mp.getEmail()+"', no_tlp='"+mp.getNoHp()+"', kode_pos='"+mp.getKodepos()+"', password='"+mp.getPassword()+"' where id_pelanggan="+mp.getID()+"";
        try {
            PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
            
            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
            
            statement.close();
        } catch (Exception ex) {
            Logger.getLogger(modelpelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     
     public boolean deleteDB(modelpelanggan mp) {
        String sql = "DELETE from pelanggan where id_pelanggan="+mp.getID()+"";
        try {
            PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
            
            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
            
            statement.close();
        } catch (Exception ex) {
            Logger.getLogger(modelpelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     
    public void update(modelpelanggan mp, int index){
         listpelanggan.add(index, mp);
         fireTableRowsUpdated(index, index);
     }
          
     public void delete(int index){
         listpelanggan.remove(index);
         fireTableRowsDeleted(index, index);
     }

    @Override
    public int getRowCount() {
        return listpelanggan.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    switch(columnIndex){
        case 0:
            return listpelanggan.get(rowIndex).getNama();
        case 1:
            return listpelanggan.get(rowIndex).getAlamat();
        case 2:
            return listpelanggan.get(rowIndex).getEmail();
        case 3:
            return listpelanggan.get(rowIndex).getNoHp();
        case 4:
            return listpelanggan.get(rowIndex).getKodepos();
        case 5:
            return listpelanggan.get(rowIndex).getPassword();
        default:
            return null;
    }
    }
    
     @Override
     public String getColumnName(int column){
        switch(column){
        case 0:
        return ("nama");
        case 1:
        return("alamat");
        case 2:
        return("email");
        case 3:
        return("no hp");
        case 4:
        return("kode pos");
        case 5:
        return("password");
        default:
        return null;
}
    
}
     
     public int loadInc(){
         String sql = "SELECT * FROM pelanggan";
         int inc2 = 0;
         
         try{
             PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
             ResultSet rs = statement.executeQuery();
             
             while(rs.next()){
                 inc2 = rs.getInt(1);
                 System.out.print("" + inc2);
             }
             statement.close();
             
         }catch (Exception ex){
             Logger.getLogger(controlpelanggan.class.getName()).log(Level.SEVERE, null, ex);
         }
         return inc2;
     }
     
     
     public modelpelanggan cariObject(String kode)
    {
        modelpelanggan plg=null;
        for (int i=0;i<listpelanggan.size();i++)
        {
            if (kode.equals(listpelanggan.get(i).getID()))
            {
                plg=new modelpelanggan(listpelanggan.get(i).getID(), listpelanggan.get(i).getNama(), listpelanggan.get(i).getAlamat(), listpelanggan.get(i).getEmail(), listpelanggan.get(i).getNoHp(), listpelanggan.get(i).getKodepos(), listpelanggan.get(i).getPassword());
            }
        }
        
        return plg;
    }
    

}



     
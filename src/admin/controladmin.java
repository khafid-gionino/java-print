/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import koneksi.koneksi;
import object.object;
import admin.modeladmin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import admin.controladmin;

/**
 *
 * @author asus
 */
public class controladmin extends AbstractTableModel {

    ArrayList<modeladmin> listadmin = new ArrayList<modeladmin>();
    
    
    public controladmin(){
        try{
            String sql = "SELECT * FROM admin";
            PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);

                ResultSet rs = statement.executeQuery();

                while (rs.next()) {
                    modeladmin ma = new modeladmin(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3));
                    
                    listadmin.add(ma);
                }
        }catch(Exception e){
            Logger.getLogger(controladmin.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public modeladmin getModeladmin(int index){
        return listadmin.get(index);
    }
    
    public void insertOBJ(String id, String username, String password){
        listadmin.add(new modeladmin(id, username, password));
        fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
    }
    
    public void update(modeladmin ma, int index){
        listadmin.add(index, ma);
        fireTableRowsUpdated(index, index);
    }
    
    public void delete(int index){
        listadmin.remove(index);
        fireTableRowsDeleted(index, index);
    }
    
    public boolean insertDB(String id, String username, String password){
         String sql = "INSERT INTO admin values ("+id+", '" + username + "', '" + password + "')";
        try {
            PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);

            int row = statement.executeUpdate();

            if (row > 0) {
                return true;
            }
            statement.close();
        } catch (Exception ex) {
            Logger.getLogger(modeladmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false; 
     }
     
     public boolean updateDB(modeladmin ma) {
        String sql = "UPDATE admin SET username='"+ma.getUsername()+"' , passwords='"+ma.getPassword()+"' where id_admin="+ma.getID()+"";
        try {
            PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
            
            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
            
            statement.close();
        } catch (Exception ex) {
            Logger.getLogger(modeladmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     
     public boolean deleteDB(modeladmin ma) {
        String sql = "DELETE from admin where id_admin="+ma.getID()+"";
        try {
            PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
            
            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
            
            statement.close();
        } catch (Exception ex) {
            Logger.getLogger(modeladmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    
    @Override
    public int getRowCount() {
        return listadmin.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    switch(columnIndex){
        case 0:
            return listadmin.get(rowIndex).getID();
        case 1:
            return listadmin.get(rowIndex).getUsername();
        case 2:
            return listadmin.get(rowIndex).getPassword();
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
        return("username");
        case 2:
        return("passwords");
        default:
        return null;
}
}
}

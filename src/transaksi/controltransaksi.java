/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaksi;

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
import pendaftaran.modelpendaftaran;

/**
 *
 * @author asus
 */
public class controltransaksi extends AbstractTableModel {

    ArrayList<modeltransaksi> listtransaksi = new ArrayList<modeltransaksi>();

    public controltransaksi() {
        try {
            String sql = "select * from transaksi";
            PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                modeltransaksi mt = new modeltransaksi(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(5),
                        rs.getString(3),
                        rs.getString(4));

                listtransaksi.add(mt);
            }
        } catch (Exception e) {

        }
    }

    public modeltransaksi getModelTransaksi(int index) {
        return listtransaksi.get(index);
    }

    public void insertObj(String id_transaksi, String id_pendaftaran, String nama, String no_kamar, String failitas, String harga, String bayar, String tgl_transaksi, String status) {
        listtransaksi.add(new modeltransaksi(id_transaksi, id_pendaftaran, bayar, status, tgl_transaksi));
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    public void update(modeltransaksi mt, int index) {
        listtransaksi.add(index, mt);
        fireTableRowsUpdated(index, index);
    }

    public void delete(int index) {
        listtransaksi.remove(index);
        fireTableRowsDeleted(index, index);
    }

    public boolean insertDB(String id_transaksi, String id_pelanggan, String no_kamar, String status, String tgl_transaksi) {
        String sql = "insert into transaksi values("
                + id_transaksi + ","
                + id_pelanggan + ","
                + no_kamar + ","
                + status + ","
                + "to_date('" + tgl_transaksi + "','dd/mm/yyyy'))";
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

    public boolean deleteDB(modeltransaksi mt) {
        String sql = "DELETE from transaksi where id_transaksi =" + mt.getId_transaksi() + "";
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
        return listtransaksi.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listtransaksi.get(rowIndex).getId_transaksi();
            case 1:
                return listtransaksi.get(rowIndex).getId_pendaftaran();
            case 2:
                return listtransaksi.get(rowIndex).getTgl_transaksi();
            case 3:
                return listtransaksi.get(rowIndex).getBayar();
            case 4:
                return listtransaksi.get(rowIndex).getStatus();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return ("ID TRANSAKSI");
            case 1:
                return ("ID PENDAFTARAN");
            case 2:
                return ("BAYAR");
            case 3:
                return ("STATUS");
            case 4:
                return ("TGL TRANSAKSI");
            default:
                return null;
        }
    }

    
    Object getNama() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    public modeltransaksi Search(String search) {
//        modeltransaksi usr = new modeltransaksi();
//        for (modeltransaksi u : listtransaksi) {
//            if (u.getNama().equals(search)) {
//                usr = u;
//            }
//        }
//        return usr;
//    }

}

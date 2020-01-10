/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;
import pelanggan.controlpelanggan;
import kamar.controlkamar;
import pendaftaran.controlpendaftaran;
import admin.controladmin;
import admin.modeladmin;
import kamar.modelkamar;
import pelanggan.modelpelanggan;
import pendaftaran.modelpendaftaran;
import transaksi.controltransaksi;
import transaksi.modeltransaksi;

/**
 *
 * @author asus
 */
public class object {
    public static controladmin cadmin = new controladmin();
    public static controlpelanggan cpelanggan = new controlpelanggan();
    public static controlkamar ckamar = new controlkamar();
    public static controlpendaftaran cpendaftaran = new controlpendaftaran();
    public static controltransaksi ctransaksi = new controltransaksi();
    
    public static modelpelanggan mdlpelanggan = new modelpelanggan();
    public static modeladmin mdladmin = new modeladmin();
    public static modelkamar mdlkamar = new modelkamar();
    public static modelpendaftaran mdlpendaftaran = new modelpendaftaran();
    public static modeltransaksi mdltransaksi = new modeltransaksi();
    

}

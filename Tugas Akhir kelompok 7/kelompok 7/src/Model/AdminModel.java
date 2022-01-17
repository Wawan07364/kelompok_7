/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Helper.KoneksiDb;
import java.sql.*;
import Entity.AdminPenduduk;
import java.util.ArrayList;
import Controller.AllObjectModel;

public class AdminModel extends ModelAbstract{
    public ArrayList <AdminPenduduk> adminmodel = new ArrayList<>();
    Connection conn=null;
    private String sql;
    private int Nik;
    public void insertData(AdminPenduduk adminmodel ){
        try{
            sql = "INSERT INTO admin (nama,  password, noTelp,nik)Values(?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, adminmodel.getNama());
            stat.setString(2, adminmodel.getPassword());
            stat.setString(3, adminmodel.getNoTelp());
            stat.setString(4, adminmodel.getNik());
            stat.executeUpdate();
        }catch (SQLException e){
            System.out.println("GAGAL INPUT !!!");
            System.out.println(e);
        }
    }
    public void UpdatePassword(String password, int Nik){
        try{
            sql = "update admin SET password =? WHERE Nik =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, password);
            stat.setInt(2, Nik);
            stat.executeUpdate();
        }catch (SQLException e){
            System.out.println("GAGAL INPUT !!!");
            System.out.println(e);
        }
    }


    public int cekLogin(String nama, String password) {
        int cek = 0;
        try {
            sql = "SELECT * FROM admin where nama = ? and password = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, nama);
            stat.setString(2, password);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                cek = rs.getInt("Nik");
            }else{
                cek = 0;
            }
        }catch(Exception e){
            e.printStackTrace();
        }return cek;
    }
  
    
    public void deleteData(int Nik){
        try{
            sql = "DELETE FROM penduduk WHERE Nik = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, Nik);
            stat.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void insertData(String nama, String alamat, String password, String notelp) {
        
    }
}

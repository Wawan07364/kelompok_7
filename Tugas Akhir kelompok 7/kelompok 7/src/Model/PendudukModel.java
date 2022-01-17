 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.*;
import java.util.ArrayList;
import Entity .Penduduk ;
import Model.ModelAbstract;
public class PendudukModel  extends ModelAbstract {
     Connection conn=null;
    private String sql;  
    public ArrayList<Penduduk > getPenduduk(){
        ArrayList<Penduduk > arrListpenduduk  = new ArrayList<>();
        try{
            Statement stat = conn.createStatement();
            sql = "SELECT *FROM penduduk";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                Penduduk  penduduk = new Penduduk ();
              
                penduduk .setNama(rs.getString("nama"));
                penduduk .setAlamat(rs.getString("alamat"));
                penduduk .setPassword(rs.getString("password"));
                penduduk .setNoTelp(rs.getString("notelp"));
                penduduk .setStatus(rs.getInt("status"));
                penduduk .setGambar(rs.getString("gambar"));
                arrListpenduduk .add(penduduk );
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return arrListpenduduk ;
    }
    
    public ArrayList<Penduduk > getPenduduk(int Nik){
        ArrayList<Penduduk > arrpenduduk  = new ArrayList<>();
        
        try{
            sql = "SELECT * FROM penduduk where nik = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, Nik);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                Penduduk  penduduk = new Penduduk ();
                penduduk .setNik(rs.getString("nik"));
                penduduk .setNama(rs.getString("nama"));
                penduduk .setAlamat(rs.getString("alamat"));
                penduduk .setPassword(rs.getString("password"));
                penduduk .setNoTelp(rs.getString("notelp"));
                penduduk .setStatus(rs.getInt("status"));
                penduduk .setGambar(rs.getString("gambar"));
                arrpenduduk .add(penduduk );
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return arrpenduduk ;
    }
    
    public void insertData(Penduduk penduduk){
        try{
            sql = "INSERT INTO penduduk (nik, nama, alamat, password, noTelp) Values(?,?,?,?,?)";
            PreparedStatement stat = conn .prepareStatement(sql);
            stat.setString(1, penduduk.getNik());
            stat.setString(2, penduduk.getNama());
            stat.setString(3, penduduk.getAlamat());
            stat.setString(4, penduduk.getPassword());
            stat.setString(5, penduduk.getNoTelp());
            ResultSet rs = stat.executeQuery();
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) update!");
        }catch (SQLException e){
            System.out.println("GAGAL INPUT DATA");
        }
    }
    
    public void updateNama(String nama, int nik){
        try{
            sql = "update penduduk SET nama =? WHERE nik=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, nama);
            stat.setInt(2, nik);
            stat.executeUpdate();
        }catch (SQLException e){
            System.out.println("GAGAL UBAH NAMA !!!");
            e.printStackTrace();
        }
    }
    
//    public void updateNik( int Nik){
//        try{
//            sql = "update penduduk SET nik =? WHERE nik =?";
//            PreparedStatement stat = conn.prepareStatement(sql);
//            stat.setString(1, Nik);
//           
//            int rows = stat.executeUpdate();
//            System.out.println(rows + "row(s) update!");
//        }catch (SQLException e){
//            System.out.println("GAGAL UBAH NAMA !!!");
//            e.printStackTrace();
//        }
//    }

    public void updateGambar(String gambar, int Nik){
        try{
            sql = "update penduduk SET gambar =? WHERE nik =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, Nik);
            stat.setString(2, gambar);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) update!");
        }catch (SQLException e){
            System.out.println("GAGAL UBAH NAMA !!!");
            e.printStackTrace();
        }
    }

    public void UpdatePassword(String password, int Nik){
        try{
            sql = "update penduduk SET password =? WHERE nik =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, password);
            stat.setInt(2, Nik);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) update!");
        }catch (SQLException e){
            System.out.println("GAGAL UBAH NAMA !!!");
            e.printStackTrace();
        }
    }

    public void updateNoTelp(String noTelp, int Nik){
        try{
            sql = "update penduduk SET noTelp =? WHERE nik =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, noTelp);
            stat.setInt(2, Nik);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) update!");
        }catch (SQLException e){
            System.out.println("GAGAL UBAH NAMA !!!");
            e.printStackTrace();
        }
    }

    public int cekLogin(String Nik, String password){
        int cek = 0;
        try{
            sql ="SELECT * FROM penduduk WHERE nik = ? and password = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, Nik);
            stat.setString(2, password);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                cek = rs.getInt("nik");
                String nama = rs.getString("nama");
                System.out.println("Selmaat Datang" + nama);
            }else {
                cek = 0;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return cek;
    }

    public int cekVerif(int Nik){
        int cek = 0;
        try{
            sql ="SELECT * FROM penduduk WHERE nik = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, Nik);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                cek = rs.getInt("nik");
                String nama = rs.getString("nama");
                System.out.println("Selmaat Datang" + nama);
            }else {
                cek = 0;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return cek;
    }    

    public void UpdateAlamat(String alamat) {
         int cek = 0;
        try{
            sql ="SELECT * FROM penduduk WHERE nik = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, alamat);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                cek = rs.getInt("nik");
                String nama = rs.getString("nama");
                System.out.println("Selmaat Datang" + nama);
            }else {
                cek = 0;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
     
    }

    
    
}

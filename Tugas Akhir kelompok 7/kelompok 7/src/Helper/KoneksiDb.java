/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;
import java.sql.Connection;
import java.sql.DriverManager;
public class KoneksiDb {
    public static Connection getconection(){
        Connection conn=null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/db_penduduk";
        String user = "root";
        String pass = "";
        try{
            Class.forName(driver);
            conn=DriverManager.getConnection(url, user, pass);
            System.out.println("Berhasil Tersambung");
        }
        catch(Exception e){
             System.out.println("Tidak Tersambung");
             e.printStackTrace();
            
        }
return conn;
        
    }

}

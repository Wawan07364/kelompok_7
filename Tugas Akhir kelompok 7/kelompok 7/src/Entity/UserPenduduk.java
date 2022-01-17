/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;
public abstract class UserPenduduk {
    protected String nik;
    protected String nama, password;
    protected String noTelp; 
    public UserPenduduk(){    
    }
    public UserPenduduk (String nama, String password, String noTelp,String nik){
        this.nik = nik;
        this.nama=nama;
        this.password=password;
        this.noTelp=noTelp;
        
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

  
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

   
}
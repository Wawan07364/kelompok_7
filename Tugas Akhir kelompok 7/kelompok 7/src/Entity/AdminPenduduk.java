/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

public class AdminPenduduk extends UserPenduduk{
    
    
    public AdminPenduduk(String nama, String password, String noTelp, String nik){
        
        super(nama,password,noTelp,nik);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   

   
}

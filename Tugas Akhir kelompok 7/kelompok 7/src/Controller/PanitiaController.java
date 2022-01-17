/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Entity.AdminPenduduk;
public class PanitiaController implements ControllerInterface{ 

    
    @Override
    public void insertData(String nama, String alamat, String password, String notelp) {
        AllObjectModel.adminModel.insertData(nama, alamat, password, notelp);
    }
    public void deleteData(int Nik){
        AllObjectModel.adminModel.deleteData(Nik);
    }
    public void UpdatePassword(String password, int Nik){
        AllObjectModel.adminModel.UpdatePassword(password, Nik);
    }
    
    @Override
    public int login(String Nik, String password) {
        int log = AllObjectModel.adminModel.cekLogin(Nik, password);
        return log;
    }

}

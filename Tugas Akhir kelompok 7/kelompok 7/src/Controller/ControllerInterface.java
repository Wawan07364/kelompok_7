/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Acer
 */
public interface ControllerInterface {
    int login(String Nik, String password);
    void insertData(String nama, String alamat, String password, String no_telp);
}

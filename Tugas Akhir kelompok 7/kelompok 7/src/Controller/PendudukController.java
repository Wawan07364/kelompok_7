/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Entity.Penduduk;
public class PendudukController implements ControllerInterface {

    private String nik;
    @Override
    public void insertData(String nama, String alamat, String password, String no_telp){    
        Penduduk penduduk = new Penduduk();
         penduduk.setNama(nama);
         penduduk.setAlamat(alamat);
         penduduk.setPassword(password);
         penduduk.setNoTelp(no_telp);
        AllObjectModel.pendudukModel.insertData(penduduk);
    }
    public void updateData(int urut, String data, int Nik ){
        switch(urut){
            case 1:
                AllObjectModel.pendudukModel.updateNama(data, Nik);
                break;
            case 2:AllObjectModel.pendudukModel.UpdatePassword(data, Nik);
                break;
                
            case 3:
                AllObjectModel.pendudukModel.updateGambar(data, Nik);
                break;
            case 4:
                AllObjectModel.pendudukModel.updateNoTelp(data, Nik);
                break;
            
        }
    }
    
    public ArrayList<Penduduk> getDatapenduduk(){
        return AllObjectModel.pendudukModel.getPenduduk();
    }
    
    public int login(String Nik, String password){
        int cek = AllObjectModel.pendudukModel.cekLogin(Nik, password);
        return cek;
    }
    
    public ArrayList<Penduduk> getById(int cekLogin){
        return AllObjectModel.pendudukModel.getPenduduk(cekLogin);
    }
    
    public int verif(int Nik){
        int cek = AllObjectModel.pendudukModel.cekVerif(Nik);
        return cek;
    }



public DefaultTableModel daftarPenduduk(){

    DefaultTableModel dataDaftarPenduduk = new DefaultTableModel();
    Object[] kolom = {"Nik","ALAMAT","NAMA","NOTELP","STATUS"};

    dataDaftarPenduduk.setColumnIdentifiers(kolom);
    int size=getDatapenduduk().size();
    for(int i = 0; i< size ;i++){
        Object []data=new Object[5];

    data[0]=AllObjectModel.pendudukModel.getPenduduk().get(i).getPassword();
    data[1]=AllObjectModel.pendudukModel.getPenduduk().get(i).getNama();    
    data[2]=AllObjectModel.pendudukModel.getPenduduk().get(i).getAlamat();
    data[3]=AllObjectModel.pendudukModel.getPenduduk().get(i).getNoTelp();
    data[4]=AllObjectModel.pendudukModel.getPenduduk().get(i).getStatus();

    dataDaftarPenduduk.addRow(data);

    }
    return dataDaftarPenduduk;

}
}
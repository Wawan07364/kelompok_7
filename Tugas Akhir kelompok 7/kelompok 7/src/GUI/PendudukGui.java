/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import Entity.Penduduk;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;



import java.nio.file.Files; 
import java.nio.file.StandardCopyOption; 
import java.util.logging.Level; 
import java.util.logging.Logger;
public class PendudukGui extends ComponentGui {

int status;
String nama, password, notelp, gambar, namagambar, path;
String filemove = "./src/image/";
File file;
    private String nik;
    private String alamat;

public PendudukGui(int cek){
    initComponent(cek);
}

void initComponent(final int cek) {
for (Penduduk PendudukEntities : AllObjectController.penduduk.getById(cek)) {

this.nama = PendudukEntities.getNama();
this.alamat = PendudukEntities.getAlamat();
this.password = PendudukEntities.getPassword();
this.notelp = PendudukEntities.getNoTelp();
this.status = PendudukEntities.getStatus();
this.gambar = PendudukEntities.getGambar();
}

setTitle("PROGRAM VERIF MAHASISWA");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setSize(380,480); 
setLocationRelativeTo(null); 
getContentPane().setBackground(Color.white);
 setLayout(null); setVisible(true);

 btnback.setBounds(25,20,80,25);
btnback.setBackground (Color.white);
btnback.setFocusPainted(false);

btnback.setBorder(null);
add(btnback);

labelnama.setBounds (25,50,40,25);
add(labelnama);

fieldnama.setBounds (120,50,100,25);
fieldnama.setText(nama);
fieldnama.setEditable(false);
add(fieldnama);

labelnama.setBounds(25,90,40,25);
add(labelnama);
fieldNik.setBounds(120,90,100,25);
fieldNik.setText(nama);

fieldNik.setEditable(false);
add(fieldNik);

labelpassword.setBounds(25,135,80,25);
add(labelpassword);

fieldpassword.setBounds (120,135,100,25);
fieldpassword.setText(password);
fieldpassword.setEditable(false);
add(fieldpassword);

labelnotelp.setBounds (25,180,80,25);
add(labelnotelp);

fieldnotelp.setBounds(120, 180, 100,25);
fieldnotelp.setText(notelp);
fieldnotelp.setEditable(false);
add(fieldnotelp);

bingkaigambar.setBounds(50,225,150,200);
add(bingkaigambar);

    btnubahnama.setBounds(245, 50, 80, 25);
    btnubahalamat.setBounds(245,90,80,25);
    btnubahpassword.setBounds(245,135,80,25);
    btnubahnotelp.setBounds(245,180,80,25);
    btnubahgambar.setBounds(245,325,80,25);

    add(btnubahnama);

    add(btnubahalamat);
    add(btnubahpassword);
    add(btnubahnotelp);
    add(btnubahgambar);
    String pict = filemove+gambar;
    System.out.println(pict);
    if(this.gambar !=null){
    try {
    bufferedimage = ImageIO.read(new File(pict));

    } catch (IOException ex) {
    Logger.getLogger(PendudukGui.class.getName()).log(Level.SEVERE, null, ex);
    }
    gambarresize = bufferedimage.getScaledInstance(150,200,Image.SCALE_SMOOTH);
    bingkaigambar.setIcon(new ImageIcon(gambarresize));
    }
    btnback.addMouseListener(new MouseAdapter(){

    @Override
    public void mouseEntered(MouseEvent e) {
    btnback.setForeground(Color.yellow);
    }
    @Override
    public void mouseExited(MouseEvent e) {
    btnback. setForeground(Color.black);
    }
    });
    btnback.addActionListener(new ActionListener(){


        
        @Override
        
        public void actionPerformed(ActionEvent e) {
        LoginGui loginGui = new LoginGui();
        loginGui.setVisible(true);
        dispose();
        }
    });

        btnubahnama.addActionListener(new ActionListener() {

        @Override
        
        public void
        actionPerformed(ActionEvent e) {
        try{
        String inputnama = JOptionPane.showInputDialog("Masukkan Nama Baru");
        if(inputnama.length() >0){
        AllObjectController.penduduk.updateData(1, inputnama,cek);
     
        fieldnama.setText(inputnama);
        }else {
       
        JOptionPane.showMessageDialog(null,"Data Kosong");
        }
        }catch (Exception ex){
     
        JOptionPane.showMessageDialog(null, "Cancelled");
        }
         }
        });


        btnubahalamat.addActionListener(new ActionListener() {

        @Override

public void actionPerformed (ActionEvent e) {
try {
String inputpass = JOptionPane.showInputDialog("Masukkan Password Baru");
if (inputpass.length() > 0)
{ AllObjectController.penduduk.updateData(3, inputpass, cek);

fieldpassword.setText(inputpass); 
} else { JOptionPane.showMessageDialog(null, "Data Kosong");
}

} catch (Exception ex){
JOptionPane.showMessageDialog(null, "Cancelled");
}
}
});

btnubahnotelp.addActionListener(new ActionListener() {

@Override
public void actionPerformed(ActionEvent e){
try{ String inputNoTelp = JOptionPane. showInputDialog("Masukkan Nomor Telp Baru");

if(inputNoTelp.length()>0){
AllObjectController.penduduk.updateData(5,inputNoTelp, cek);

fieldnotelp.setText(inputNoTelp);
}else{
JOptionPane.showMessageDialog(null,"Data Kosong");
}
}catch (Exception ex){
JOptionPane.showMessageDialog(null, "Cancelled");
}
}
});

btnubahgambar.addActionListener(new ActionListener() {

@Override
public void actionPerformed(ActionEvent e) {

JFileChooser chooser = new JFileChooser();
chooser.setCurrentDirectory(new File(System.getProperty("user.home" )));
FileNameExtensionFilter filterekstensi = new FileNameExtensionFilter("Gambar","jpg","png", "gif");

chooser.addChoosableFileFilter(filterekstensi);
int status = chooser.showOpenDialog(null);
if(status==JFileChooser.APPROVE_OPTION){
file = chooser.getSelectedFile();

File destinasi = new File(filemove.concat(nama+".jpg"));
try {
Files.move(file.toPath(), destinasi.toPath(), StandardCopyOption.REPLACE_EXISTING);
namagambar = destinasi.getName();

path = destinasi.getAbsolutePath();

try {
bufferedimage = ImageIO.read(new File(path));

} catch (IOException ex) {
Logger.getLogger(PendudukGui.class.getName()).log(Level.SEVERE, null, ex);
}

} catch (IOException ioException) {
ioException.printStackTrace();
}
gambarresize = bufferedimage.getScaledInstance(159, 200, Image.SCALE_SMOOTH);
bingkaigambar.setIcon(new ImageIcon(gambarresize));
AllObjectController.penduduk.updateData (4,namagambar,cek);
}

else if(status == JFileChooser.CANCEL_OPTION) {
JOptionPane.showMessageDialog(null, "Tidak Memilih Gambar");

         }
                 }
        });
     }

}


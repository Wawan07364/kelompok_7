/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import Controller.AllObjectModel;
import javax.swing.*;
import java.awt.*; 
import java.awt.event. ActionEvent; 
import java.awt.event.ActionListener; 
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent; 
import java.io.File; 
import java.io.IOException; 
import java.util.logging. Level;
 import java.util.logging. Logger;
import javax.imageio.ImageIO;

public class LoginAdminGui extends ComponentGui{
JButton btnloginpenduduk = new JButton("LOGIN AS PENDUDUK ?");
String pathicon;
public LoginAdminGui(){
initComponent();
}
void initComponent() {
setTitle("Login Admin");

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setSize(320,480); 
    setLocationRelativeTo(null); 
    getContentPane().setBackground(Color.white);
    setLayout(null); 
    setVisible(true);

    labelNik.setBounds (35,250,40,25); 
    add(labelNik); 

    fieldNik.setBounds(130,250,130,25);
    add(fieldNik);

    labelpassword.setBounds (35, 290,80, 25);
     add(labelpassword); 

    fieldpassword.setBounds (130, 290, 130,25); 
    add(fieldpassword);
    btnlogin.setBounds (110,350,100,25);
    btnlogin.setBackground (Color.black);
     btnlogin. setForeground (Color.white);
     btnlogin.setBorder(null); 
    add(btnlogin);

    btnloginpenduduk .setBounds(70,400,180,25);
    btnloginpenduduk.setBorder(null);

    btnloginpenduduk.setBackground (Color.white);
    add(btnloginpenduduk);
    bingkaigambar.setBounds (80,70,150, 150);
    add(bingkaigambar);
    pathicon = "./src/image/admin.png";
    try {
        
    bufferedimage = ImageIO.read(new File(pathicon));
    } catch (IOException ex) {



    Logger.getLogger(LoginGui.class.getName()).log(Level.SEVERE, null, ex);
}
    gambarresize = bufferedimage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);


    bingkaigambar.setIcon(new ImageIcon(gambarresize));
    btnloginpenduduk.addMouseListener(new MouseAdapter() {

    @Override
    public void mouseEntered(MouseEvent e) {
    btnloginpenduduk. setForeground (Color.blue);
    }

    @Override
    public void mouseExited(MouseEvent e) {
    btnloginpenduduk.setForeground (Color.black);
    }
    });

    btnloginpenduduk.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e){


    dispose(); 
    new LoginGui().setVisible(true);
    }
});

    btnlogin.addMouseListener(new MouseAdapter(){
    @Override
    public void mouseEntered(MouseEvent e) {
    btnlogin.setForeground (Color.black);
    btnlogin.setBackground(Color.green);
    }
    @Override
    public void mouseExited(MouseEvent e) {
    btnlogin.setForeground(Color.white); 
    btnlogin.setBackground(Color.black);
    }
    });


    btnlogin.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed (ActionEvent e) {
    String nik= fieldNik.getText();
    String password = fieldpassword.getText();
   
    int log = AllObjectModel.adminModel.cekLogin(nik, password);
    if (log>0){
    dispose();
    PanitiaGui adminGui = new PanitiaGui(log); 
    adminGui.setVisible(true);
    }else {
JOptionPane.showMessageDialog(null, "GAGAL LOGIN");
kosong();
    }
}
    });
}
}

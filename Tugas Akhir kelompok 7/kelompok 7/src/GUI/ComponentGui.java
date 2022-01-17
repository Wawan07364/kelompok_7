/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ComponentGui extends JFrame {

protected JButton btnregister = new JButton ("REGISTRASI");
protected JButton btnnotreg = new JButton ("BELUM REGISTRASI ?");
protected JButton btnlogin = new JButton("LOG IN");
protected JButton btnback = new JButton("<<LOG OUT");
protected JButton btndelete = new JButton("DELETE");
protected JButton btnverif = new JButton("VERIF");

protected JLabel labelregister = new JLabel("REGISTER");
protected JLabel labellogin = new JLabel("LOGIN");
protected JLabel labelNik = new JLabel("NIK");
protected JLabel labelnama = new JLabel("NAMA");
protected JLabel labelAlamat = new JLabel("ALAMAT");
protected JLabel labelpassword = new JLabel("PASSWORD");
protected JLabel labelnotelp = new JLabel("NO TELP");

protected JLabel bingkaigambar = new JLabel();

protected JTextField fieldnama  = new JTextField();
protected JTextField fieldNik  = new JTextField();

protected JPasswordField fieldpassword  = new JPasswordField();

protected JTextField fieldnotelp  = new JTextField();

protected JButton btnubahnama = new JButton("ubah");
protected JButton btnubahalamat = new JButton("ubah");
protected JButton btnubahpassword = new JButton("ubah");
protected JButton btnubahnotelp = new JButton("ubah");
protected JButton btnubahgambar = new JButton("upload");


BufferedImage bufferedimage = null;
java.awt.Image gambarresize;

void kosong(){
    fieldnama.setText(null);
    fieldNik.setText(null);
    fieldpassword.setText(null);
    fieldnotelp.setText(null);
}

}

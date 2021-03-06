/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class RegisterAdminGui extends ComponentGui{
    public RegisterAdminGui() {
        initComponent();
    }
    void initComponent() {
        setTitle("Register Admin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

        labelregister.setText("REGISTER ADMIN");
        labelregister.setBounds(100, 50, 110, 25);
        add(labelregister);
        labelNik.setBounds(35, 95, 40, 25);
        add(labelNik);
        fieldNik.setBounds(130, 95, 130, 25);
        add(fieldNik);

        labelnama.setBounds(35, 140, 80, 25);
        add(labelnama);
        fieldnama.setBounds(130, 140, 130, 25);
        add(fieldnama);

        labelpassword.setBounds(35, 185, 80, 25);
        add(labelpassword);
        fieldpassword.setBounds(130, 185, 130, 25);
        add(fieldpassword);

        labelnotelp.setBounds(35, 230, 80, 25);
        add(labelnotelp);
        fieldnotelp.setBounds(130, 230, 130, 25);
        add(fieldnotelp);

        btnregister.setBounds(80, 350, 140, 25);
        btnregister.setBorder(null);
        btnregister.setBackground(Color.black);
        btnregister.setForeground(Color.white);
        btnregister.setFocusPainted(false);
        add(btnregister);

        btnregister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnregister.setForeground(Color.black);
                btnregister.setBackground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnregister.setForeground(Color.white);
                btnregister.setBackground(Color.black);
            }
        });
        btnregister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = fieldnama.getText();
                String alamat= fieldNik.getText();
                String password = fieldpassword.getText();
                String notelp = fieldnotelp.getText();
                if (nama.length() != 0 && alamat.length() != 0 && password.length() != 0 && notelp.length() != 0) {

                    AllObjectController.admin.insertData(nama, alamat, password, notelp);
                    JOptionPane.showMessageDialog(null, nama + " Adalah Admin");
                    dispose();
                    new LoginAdminGui().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
                    kosong();
                }
            }
        });
    }
}

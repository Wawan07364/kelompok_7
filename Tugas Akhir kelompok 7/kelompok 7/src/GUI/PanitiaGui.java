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

public class PanitiaGui extends ComponentGui{
    JTable tabelpenduduk = new JTable();
    JScrollPane sppenduduk = new JScrollPane(tabelpenduduk);
    JTextField textpilih = new JTextField();
    int kode;
    
    public PanitiaGui(int cek){
        initComponent(cek);
    }
    
    void initComponent(final int cek){
        setTitle("PROGRAM VERIF PENDUDUK");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        setVisible(true);
        
        sppenduduk.setBounds(20, 50, 500, 350);
        tabelpenduduk.setModel(AllObjectController.penduduk.daftarPenduduk());
        add(sppenduduk);
        // verif
        btnverif.setBounds(540, 50, 110, 25);
        btnverif.setFocusPainted(false);
        btnverif.setBorder(null);
        btnverif.setBackground(Color.black);
        btnverif.setForeground(Color.white);
        add(btnverif);
        //delete
        btndelete.setBounds(540, 95, 110, 25);
        btndelete.setFocusPainted(false);
        btndelete.setBorder(null);
        btndelete.setBackground(Color.black);
        btndelete.setForeground(Color.white);
        add(btndelete);
        //ubah password
        btnubahpassword.setText("UBAH PASSWORD");
        btnubahpassword.setBounds(540, 140, 110, 25);
        btnubahpassword.setFocusPainted(false);
        btnubahpassword.setBorder(null);
        btnubahpassword.setBackground(Color.black);
        btnubahpassword.setForeground(Color.white);
        add(btnubahpassword);
        
        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);
        
        btnregister.setText("REGIST PANITIA ");
        btnregister.setBounds(540, 185, 110, 25);
        btnregister.setFocusPainted(false);
        btnregister.setBorder(null);
        btnregister.setBackground(Color.black);
        btnregister.setForeground(Color.white);
        add(btnregister);
        
        tabelpenduduk.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i =  tabelpenduduk.getSelectedRow();
                textpilih.setText(AllObjectController.penduduk.daftarPenduduk().getValueAt(i, 0).toString());
            }
        });
  
        
        btnback.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnback.setForeground(Color.yellow);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnback.setForeground(Color.black);
            }
        });
        
        btnback.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                LoginAdminGui loginAdminGui = new LoginAdminGui();
                loginAdminGui.setVisible(true);
                dispose();
            }
        });
        
        btnubahpassword.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputpass = JOptionPane.showInputDialog("Masukkan Password Baru");
                    if(inputpass.length() > 0){
                        AllObjectController.admin.UpdatePassword(inputpass, cek);
                        JOptionPane.showMessageDialog(null, "Berhasil Ubah Password");
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
        btnregister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterAdminGui registerAdminGui = new RegisterAdminGui();
                registerAdminGui.setVisible(true);
                dispose();
            }
        });
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import Controller.PendudukController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RubahGambar extends JFrame {
    PendudukController mhs = new PendudukController();
    JButton btnbrowse = new JButton("cari");
    JButton btnsave = new JButton("save");
    JTextArea fieldlokasi = new JTextArea();
    JLabel bingkai = new JLabel();
    File file;
    String path;
    BufferedImage bufferI = null;
    
    public RubahGambar(int id){
        initComponent(id);
    }
    public void initComponent(final int id){
        setTitle("Ubah Gambar");
        setSize(245, 320);
        setLocationRelativeTo(null);
        setLayout(null);
        
        btnbrowse.setBounds(50, 60, 75, 25);
        btnbrowse.setBackground(new Color(0x2980b9));
        btnbrowse.setFocusPainted(false);
        add(btnbrowse);
        
        btnsave.setBounds(145, 60, 75, 25);
        btnsave.setFocusPainted(false);
        add(btnsave);
        
        fieldlokasi.setBounds(10, 10, 210, 40);
        fieldlokasi.setLineWrap(true);
        fieldlokasi.setWrapStyleWord(true);
        fieldlokasi.setEditable(false);
        add(fieldlokasi);
        
        bingkai.setBounds(10, 120, 210, 150);
        add(bingkai);
        
        btnbrowse.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("images", "jpg", "gif");
                
                chooser.addChoosableFileFilter(filter);
                int status = chooser.showOpenDialog(null);
                if(status == JFileChooser.APPROVE_OPTION){
                    file = chooser.getSelectedFile();
                    path = file.getAbsolutePath();
                    fieldlokasi.setText(path);
                    
                    try{
                        bufferI = ImageIO.read(new File(path));
                    }catch(IOException ex){
                        Logger.getLogger(RubahGambar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Image Gsize = bufferI.getScaledInstance(230, 150, Image.SCALE_SMOOTH);
                    bingkai.setIcon(new ImageIcon(Gsize));
                }else if(status == JFileChooser.CANCEL_OPTION){
                    fieldlokasi.setText("FILE KOSONG");
                }
            }
        }
        );
        btnsave.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    mhs.updateData(4, path, id);
                    JOptionPane.showMessageDialog(null, "SUKSES UBAH GAMBAR");
                    dispose();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "GAGAL UBAH GAMBAR");
                    ex.printStackTrace();
                }
            }
        });
    }
}
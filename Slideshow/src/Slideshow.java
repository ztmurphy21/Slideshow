/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Zachary Murphy
 */

public class Slideshow extends JApplet implements ActionListener {
   
    JLabel display = new JLabel();
    JButton open = new JButton("Open");
    JButton start = new JButton ("Start");
    JButton stop = new JButton ("Stop");
    
    int currentImage = -1;
    String images[];
    

  
    public void init() {
        JPanel buttons = new JPanel (new FlowLayout());
        buttons.add(open);
        buttons.add(start);
        buttons.add(stop);
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add("Center", display);
        getContentPane().add("South", buttons);
        
        
    }
    public void showCurrent(){
        
    }
    public void showNext(){
        
    }
    
   

   
    public void actionPerformed(ActionEvent e) {
        int x =0;
        if (e.getSource() == open){
            JFileChooser fc = new JFileChooser();
            int result = fc.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION){
                x=x+1;
                Files[x] images = fc.getSelectedFile();
            }
        }
    }



}

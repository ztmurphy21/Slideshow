/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import static java.nio.channels.AsynchronousFileChannel.open;
import java.nio.file.Files;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import static sun.awt.image.ImagingLib.filter;

/**
 *
 * @author Zachary Murphy
 */

public class Slideshow extends JApplet  {
   
    private JLabel display;
    private JButton open ;
   private  JButton start ;
    private JButton stop ;
    private JPanel picturePanel;
    private JPanel navigationPanel;
    private JPanel mainPanel;
    
    int currentImage = -1;
    String images[];
    private Object image;
    

  
    public void init() {
        this.setSize(500,500);
        buildNavPanel();
        mainPanel();
        
        
    }
    
    private void buildPicturePanel(){
        picturePanel = new JPanel();
        
    }
    private void buildNavPanel(){
        navigationPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        navigationPanel.setLayout(new GridLayout(0,3));
        open = new JButton("Open Images (Up to 10)");
        start = new JButton ("Start Slide Show");
        stop = new JButton ("Stop Slide Show");
        open.addActionListener(new OpenListener());
        navigationPanel.add(open);
        navigationPanel.add(start);
        navigationPanel.add(stop);
        
        
        
    }
    
    private void mainPanel(){
        buildNavPanel();
        add(navigationPanel,BorderLayout.SOUTH);
    }
    public void showCurrent(){
        display.setIcon(new ImageIcon(images[currentImage]));
        
    }
    public void showNext(){
        currentImage = currentImage +1;
        if (currentImage >= images.length){
            currentImage = 0;
        }
        showCurrent();
    
        
        
    }


    
   

   private class OpenListener implements ActionListener{
       
   
    public void actionPerformed(ActionEvent e) {
        JFileChooser fc= new JFileChooser();
     FileFilter filter = new FileNameExtensionFilter ("JPEG file", "jpg", "jpeg");
    fc.setFileFilter(filter);
    fc.setMultiSelectionEnabled(true);
     int response = fc.showOpenDialog(null);
     if (response == JFileChooser.APPROVE_OPTION){
        File selectedFile = fc.getSelectedFile();
        String fileName = selectedFile.getPath();
  
    }

    }

}
}

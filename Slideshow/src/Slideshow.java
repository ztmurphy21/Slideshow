import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import static sun.awt.image.ImagingLib.filter;

/**
 *
 * @author Zachary Murphy
 */

public class Slideshow extends JApplet  {
   //setting all JItmes along with items for the image and timer
    private JLabel display;
    private JButton open ;
   private  JButton start ;
    private JButton stop ;
    private JPanel picturePanel;
    private JPanel navigationPanel;
    private JPanel mainPanel;
    private BufferedImage pics;
    private int counter = 0;
    private ImageIcon[] pictures ;
    private JLabel label;
    
    int currentImage = -1;
    String images[];
    private Object image;
    File selectedFile;
    String fileName;
    

  //basically the main method for a JApplet
    public void init() {
        this.setSize(1000,1500);
        buildNavPanel();
       // buildPicturePanel();
        mainPanel();
        
        
    }
    //creates the panel that will hold the slide show
    private void buildPicturePanel(){
      try{
          pics = ImageIO.read(new File(fileName));
      }catch(IOException ex){
          System.out.println("Please open another selection of pictures.");
      }
        
    }
    
    //navigation panel where user can hit add, start, stop
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
   
    //main panel holds all panels with location
    private void mainPanel(){
        buildNavPanel();
        //buildPicturePanel();
        add(navigationPanel,BorderLayout.SOUTH);
        //add(picturePanel, BorderLayout.CENTER);
    }
    
    //shows current picture
    public void showCurrent(){
        display.setIcon(new ImageIcon(images[currentImage]));
        
    }
    
    //shows next picture
    public void showNext(){
        currentImage = currentImage +1;
        if (currentImage >= images.length){
            currentImage = 0;
        }
        showCurrent();
    
        
        
    }


    
   
//this will make the openlistener work
   private class OpenListener implements ActionListener{
       
   //actionevent for openlistener
    public void actionPerformed(ActionEvent e) {
        JFileChooser fc= new JFileChooser();
     FileFilter filter = new FileNameExtensionFilter ("JPEG file", "jpg", "jpeg");
    fc.setFileFilter(filter);
    fc.setMultiSelectionEnabled(true);
     int response = fc.showOpenDialog(null);
     if (response == JFileChooser.APPROVE_OPTION){
         selectedFile = fc.getSelectedFile();
         fileName = selectedFile.getPath();
  
    }

    }

}
}

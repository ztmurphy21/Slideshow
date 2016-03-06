import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;



/**
 *
 * @author Zachary Murphy
 */

public class Slideshow extends JFrame  {
    private final int MAX_IMAGES = 10;
    private JPanel imagePanel;
    private JPanel buttonPanel; 
    private JLabel imageLabel;
    private JButton imageButton;
    private JButton delayButton;
    private JButton startButton;
    private JButton stopButton;
    private  JFileChooser fileSelector;
    private Timer timer;
    private int timeDelay = 1000;
    private ImageIcon[] images;
    private int numImages = 0;
    private int currentImage = 0;
    
public Slideshow(){
    setTitle("Slide show");
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    setLayout(new BorderLayout());
    
     buildImagePanel();
    buildButtonPanel();
    
    add(imagePanel, BorderLayout.CENTER);
    add(buttonPanel, BorderLayout.SOUTH);
    
    fileSelector = new JFileChooser(".");
    
    timer = new Timer(timeDelay, new TimerListener());
    images = new ImageIcon[MAX_IMAGES];
    pack();
    setVisible(true);
    
}
private void buildImagePanel(){
    imagePanel = new JPanel();
    
}
    private void buildButtonPanel(){
        buttonPanel = new JPanel();
        
        delayButton = new JButton("Set Time Delay");
        delayButton.setMnemonic(KeyEvent.VK_T);
        delayButton.setToolTipText("Click here to set the time delay.");
        
        startButton = new JButton("Start");
        startButton.setMnemonic(KeyEvent.VK_S);
        startButton.setToolTipText("Click here to start the slide show.");
        
        stopButton = new JButton ("Stop");
        stopButton.setMnemonic(KeyEvent.VK_P);
        stopButton.setToolTipText("Click here to stop the slide show.");
        
        imageButton.addActionListener(new ImageButtonListener());
        delayButton.addActionListener(new DelayButtonListener());
        startButton.addActionListener(new StartButtonListener());
        stopButton.addActionListener(new StopButtonListener());
        
        buttonPanel.add(imageButton);
        buttonPanel.add(delayButton);
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        
        
        
    
    }
    
    private class ImageButtonListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent ae) {
               File selectedFile;
               ImageIcon thisImage;
               String filename;
               int fileChooserStatus;
               
              if (numImages >=MAX_IMAGES){
                  JOptionPane.showMessageDialog(null, "The maximum number of images" + " have been selected. ");
              }else{
                  fileChooserStatus = fileSelector.showOpenDialog(Slideshow.this);
                  
              if (fileChooserStatus == JFileChooser.APPROVE_OPTION){
                  selectedFile = fileSelector.getSelectedFile();
                  filename= selectedFile.getPath();
                  thisImage = new ImageIcon(filename);
                  images[numImages] = thisImage;
                  numImages++;
                  
              }
              }
            
        }
        
    }
    
    private class DelayButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            String input = JOptionPane.showInputDialog("Enter the time delay (in seconds).");
            timeDelay = Integer.parseInt(input) * 1000;
            timer.setDelay(timeDelay);
            
        }
    }
        
        private class StartButtonListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent ae) {
                timer.start();
                
            }
            
        }
        
        private class StopButtonListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent ae) {
                timer.stop();
                }
            
        }
       private class TimerListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent ae) {
                setTitle("Image " + String.valueOf(currentImage +1));
                imageLabel.setIcon(images[currentImage]);
                pack();
                
                if(currentImage < (numImages -1)){
                    currentImage++;
                }else{
                    currentImage =0;
                }
            }
           
       }
        
    
    public static void main (String[] args){
        Slideshow ss = new Slideshow();
    }
}
    
    
   



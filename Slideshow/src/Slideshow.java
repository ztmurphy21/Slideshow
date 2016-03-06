import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;



/**
 *
 * @author Zachary Murphy
 */

public class Slideshow extends JFrame  {
    //declaration of all variables 
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
    
    //constructor for slide show
public Slideshow(){
    setTitle("Slide show");//title 
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close setting
    
    
    //border layout 
    setLayout(new BorderLayout());
    
    
    //this will bring panels in
     buildImagePanel();
    buildButtonPanel();
    
    
    //locations set in border layout for each panel
    add(imagePanel, BorderLayout.CENTER);
    add(buttonPanel, BorderLayout.SOUTH);
    
    
    //inst of fileSelector id
    fileSelector = new JFileChooser(".");
    
    //inst of timer/iamges id
    timer = new Timer(timeDelay, new TimerListener());
    images = new ImageIcon[MAX_IMAGES];
    pack();
    
    //will make everything displayed
    setVisible(true);
    
}

/**
 * This method is for the ImageJPanel
 */
private void buildImagePanel(){
    
    //adding panel and label
    imagePanel = new JPanel();
    imageLabel = new JLabel();
    
    
    //making visible in panel
    imagePanel.add(imageLabel);
    
}

/**
 * This method is for the button  JPanel
 */
    private void buildButtonPanel(){
        buttonPanel = new JPanel();
        
        //add image button
        imageButton = new JButton ("Add Image");
        imageButton.setMnemonic(KeyEvent.VK_A);
        imageButton.setToolTipText("Click here to add an image.");
        
        
        //delay button
        delayButton = new JButton("Set Time Delay");
        delayButton.setMnemonic(KeyEvent.VK_T);
        delayButton.setToolTipText("Click here to set the time delay.");
        
        //start button
        startButton = new JButton("Start");
        startButton.setMnemonic(KeyEvent.VK_S);
        startButton.setToolTipText("Click here to start the slide show.");
        
        //stop button
        stopButton = new JButton ("Stop");
        stopButton.setMnemonic(KeyEvent.VK_P);
        stopButton.setToolTipText("Click here to stop the slide show.");
        
        
        //actions listeners for all butotns
        imageButton.addActionListener(new ImageButtonListener());
        delayButton.addActionListener(new DelayButtonListener());
        startButton.addActionListener(new StartButtonListener());
        stopButton.addActionListener(new StopButtonListener());
        
        
        //adding all buttons to be visble
        buttonPanel.add(imageButton);
        buttonPanel.add(delayButton);
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        
        
        
    
    }
    
    /**
     * This method implements  action Listener for the add image button
     */
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
    /**
     * This method implements action listener for if delay button is selected
     */
    private class DelayButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            String input = JOptionPane.showInputDialog("Enter the time delay (in seconds).");
            timeDelay = Integer.parseInt(input) * 1000;
            timer.setDelay(timeDelay);
            
        }
    }
    
    /**
     * This method is for when start button is selected
     */
        
        private class StartButtonListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent ae) {
                timer.start();
                
            }
            
        }
        
        /**
         * This method is for when the stop button is selected
         */
        private class StopButtonListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent ae) {
                timer.stop();
                }
            
        }
        
        /**
         * This method is for when the timer button is slected
         */
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
        
       
       /** m
        * main method of program
        * @param args 
        */
    
    public static void main (String[] args){
        Slideshow ss = new Slideshow();
    }
}
    
    
   



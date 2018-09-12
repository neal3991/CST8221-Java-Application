

/* imports */
import java.awt.BorderLayout;
import java.awt.Color;

import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CalculatorSplashScreen {
    
    //duration that will display the splash screen in seconds
    private int duration;
    
    /**
     * default constructor
     * @param duration 
     */
    public CalculatorSplashScreen(int duration){this.duration = duration;}
    

    public void showSplashWindow()
    {
        //create frame object
        JFrame frame = new JFrame();
        //remove border, buttons and title bar
        frame.setUndecorated(true);
        //set size
        frame.setSize(450, 270);
        //centering it in middle of screen
        frame.setLocationRelativeTo(null);
        
        //create panel object
        JPanel panel = new JPanel(new BorderLayout());
        //add border and set border color
        panel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
        //set bg color
        panel.setBackground(Color.darkGray);
        
        //create image icon label object
        JLabel imageLabel = new JLabel(new ImageIcon("wave.gif"));
        //add to panel
        panel.add(imageLabel, BorderLayout.CENTER);
        
        //create label text to display author info and set color
        JLabel bottomLabel = new JLabel("student name", JLabel.CENTER);
        bottomLabel.setForeground(Color.cyan);
        //add to panel
        panel.add(bottomLabel, BorderLayout.SOUTH);
        
        //add panel to frame
        frame.add(panel);
        //make visible
        frame.setVisible(true);
        
        //run splashscreen according to given duration
        try { TimeUnit.SECONDS.sleep(duration); }
        catch (Exception e) { e.printStackTrace(); }
        finally 
        {
            //make it disappear and destroy window by releasing resources
            frame.setVisible(false);
            frame.dispose();
        }
    } //end of method showSplashWindow()
    
} //end of class CalculatorSplashScreen

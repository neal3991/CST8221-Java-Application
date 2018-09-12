

/* imports */
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;


public class Calculator {
    
    
    /**
     * Main method which launches the calculator application
     * @param args 
     */
    public static void main(String[] args)
    {
        //display splash screen for 5 seconds
        new CalculatorSplashScreen(5).showSplashWindow();
        
        //handles events in queue and runs them
        EventQueue.invokeLater(new Runnable()
        {            
            @Override
            public void run()
            {
                //create frame title
                JFrame frame = new JFrame("Calculator");
                //set minimum size
                frame.setMinimumSize(new Dimension(330, 400));
                //display it in middle of screen on start up
                frame.setLocationRelativeTo(null);
                //user will be able to resize
                frame.setResizable(true);
                //add it to the frame
                frame.add(new CalculatorView());
                //exit if click on close button
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //to be able to see it
                frame.setVisible(true);
            } //end of run()
            
        }); // end of methods EventQueue.invokeLater() and Runnable()
        
    } // end of method main()
    
} // end of class Calculator

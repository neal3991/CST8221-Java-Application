/************************************************************************************************************************************
* Filename:                     Calculator.java                                                                                 *
* Version:                      2.0                                                                                                 *
* Author:                       Niladri Sengupta                                                                                    *
* Student No:                   040777969                                                                                           *
* Course Name/Number:           CST 8221 (Java Applications)                                                                        *
* Lab Sect:                     310                                                                                                 *
* Assignment #:                 01-Part_02                                                                                          *
* Assignment name:              Calculator                                                                                          *
* Due Date:                     March 11, 2017                                                                                   *
* Submission Date:              March 11, 2017                                                                                   *
* Professor:                    Svillen Ranev                                                                                       *
* Purpose:                      Set up an environment that displays the interface of a calculator (to be further used)              *
* Note:                         This program was made in NetBeans_IDE_8.2. For optimal performance run in in NetBeans_IDE_8.2       *
*************************************************************************************************************************************/
/* Uncomment if package is required */
package calculator_a1_1;

/* Imports */
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;

/*********************************************************************************************
* @Purpose:             To display/run the splash screen and then the calculator afterwards  *
* @Author:              Niladri Sengupta                                                     *
* @Version:             1.0                                                                  *
* @See:                 calculator_a1_1                                                      *
* @Since:               8.2                                                                  *
*********************************************************************************************/
public class Calculator {
    
    /* Main */
    public static void main(String[] args)
    {
        /* Display splash_screen for 5 seconds */
        new CalculatorSplashScreen(5).showSplashWindow();
        
        /* Handling the event in Queue */
        EventQueue.invokeLater(new Runnable()
        {   
            /*********************************************************************************************
            * @Purpose:            To create a calculator frame and (add and run)  it to CalculatorView  *
            * @Param:              N/A                                                                   *
            * @Return:             N/A                                                                   *
            *********************************************************************************************/
            @Override
            public void run()
            {
                /* Frame title */
                JFrame frame = new JFrame("Calculator");
                /* Frame minimum size */
                frame.setMinimumSize(new Dimension(276, 460));
                /* Display in the cetner at startup */
                frame.setLocationRelativeTo(null);
                /* Can be resized */
                frame.setResizable(true);
                /* Adding the fram to CalculatorView */
                frame.add(new CalculatorView());
                /* Exit operation - Click close to exit */
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                /* Visibility */
                frame.setVisible(true);
            }
            
        });
        
    } 
    
}


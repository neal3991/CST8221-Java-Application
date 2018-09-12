/************************************************************************************************************************************
* Filename:                     CalculatorSplashScreen.java                                                                                 *
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
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.concurrent.TimeUnit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

/***********************************************************************************
* @Purpose:             To create a splash screen before the calculator is called  *
* @Author:              Niladri Sengupta                                           * 
* @Version:             1.0                                                        *
* @See:                 calculator_a1_1                                            *
* @Since:               8.2                                                        *
***********************************************************************************/
public class CalculatorSplashScreen {
    
    /* Duration of the splash_screen */
    private int duration;
    
   /************************************************************************
    * @Purpose:            To get the duration of the splash screen        *
    * @Param:              int duration                                    *
    * @Return:             int duration (outside the scope of this method  *
    ***********************************************************************/
    public CalculatorSplashScreen(int duration) {
        this.duration = duration;
    }
    
    /************************************************************************
    * @Purpose:            To create and setup a splash screen window       *
    * @Param:              N/A                                              *
    * @Return:             N/A                                              *
    ************************************************************************/
    public void showSplashWindow()
    {
        /* Create frame */
        JFrame frame = new JFrame();
        /* Empty frame */
        frame.setUndecorated(true);
        /* Frame size */
        frame.setSize(696, 480);
        /* Positioning center at startup*/
        frame.setLocationRelativeTo(null);
        /* Panel to display it */
        JPanel panel = new JPanel(new BorderLayout());
        /* Add border and custom color */
        Color customColor = new Color(44, 197, 211);
        panel.setBorder(BorderFactory.createLineBorder(customColor, 10));
        /* Background color as Gray */
        panel.setBackground(Color.GRAY);
        /* Image/Gif to be displayed */
        JLabel imageLabel = new JLabel(new ImageIcon("itachi.jpeg"));
        panel.add(imageLabel, BorderLayout.CENTER);
        /* Student name and Student number */
        JLabel bottomLabel = new JLabel("Name: Niladri Sengupta. ID#: 040777969", JLabel.CENTER);
        bottomLabel.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 14));       
        panel.add(bottomLabel, BorderLayout.SOUTH);
        /* Adding panel to frame*/
        frame.add(panel);
        /* Set to visible */
        frame.setVisible(true);
        /* Run splash_screen based on given duration */
        try {
            TimeUnit.SECONDS.sleep(duration);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            /* Delete frame after use and release resources */
            frame.setVisible(false);
            frame.dispose();
        }
    }
    
}

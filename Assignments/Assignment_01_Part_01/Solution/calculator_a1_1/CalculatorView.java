/**********************************************************************************************************************************
* Filename:                     CalculatorView.java                                            *
* Version:    1.0              *
* Author:   Niladri Sengupta                                                      *
* Student No:     040777969             *
* Course Name/Number:           CST 8221 (Java Applications)           *
* Lab Sect:    310              *
* Assignment #:   01-Part_01             *
* Assignment name:  Calculator             *
* Due Date:   February 27, 2017            *
* Submission Date:  February 27, 2017            *
* Professor:   Svillen Ranev             *
* Purpose:   Set up an environment that displays the interface of a calculator (to be further used)            *
* Note:    This program was made in NetBeans_IDE_8.2. For optimal performance run in in NetBeans_IDE_8.2     *
***********************************************************************************************************************************/
/* Uncomment if package is required */
//package calculator_a1_1;

/* All the imports - For outer and inner class */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


/********************************************************************
* @Purpose:             To create the interface of a calculator     *
* @Author:              Niladri Sengupta                            *
* @Version:             1.0                                         *
* @See:                 calculator_a1_1                             *
* @Since:               8.2                                         *
********************************************************************/

/* Main Class - Outer */
public class CalculatorView extends JPanel {
    
    /* String array - Numeric values with unicode characters:-
        7   8   9   /
        4   5   6   *
        1   2   3   -
        -/+ 0   .   +
    
    */
    private static final String[] NUM_PAD_LABELS = new String[] {
        "7","8","9","\u2215",
        "4","5","6","\u2217",
        "1","2","3","\u2212",
        "\u2213","0","\u22C5","+"
    };
    
    /* The calculator display field reference */
    private JTextField display;
    /* The error display label reference */
    private JLabel error;
    /* The decimal point (dot) button reference */
    private JButton dotButton;
    
    /********************************************************************
    * @Purpose:            Default constructor for this class           *
    * @Param:              N/A                                          *
    * @Return:             N/A                                          *
    ********************************************************************/
    /* Constructor(Default) */
    public CalculatorView()
    { 
        /* Initializing elements and setting up borders and layout */
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black));
        
        /* Creating and setting top panel to white */
        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel show = new JPanel();
        show.setBackground(Color.white);
        
        /* Mode/Error Display Label */
        error = new JLabel("F");
        error.setPreferredSize(new Dimension(25, 25));
        error.setBackground(Color.yellow);
        error.setOpaque(true);
        error.setHorizontalAlignment(JLabel.CENTER);
        show.add(error);
        
        /* Creating text-field as per requierments */
        display = new JTextField("0.0", 16);
        display.setBackground(Color.white);
        display.setPreferredSize(new Dimension(0, 30));
        display.setHorizontalAlignment(JTextField.RIGHT);
        /* No input from Keyboard */
        display.setEditable(false);        
        show.add(display);
        
        /* Setting upt backscpace button with its respetive label*/
        String bp_Label = "\u21D0";
        JButton bp_Button = new JButton(bp_Label);        
        /* Transparent, Red border, tool-tip, etc. */
        bp_Button.setContentAreaFilled(false);
        bp_Button.setBorder(BorderFactory.createLineBorder(Color.red, 1));
        bp_Button.setForeground(Color.red);
        bp_Button.setPreferredSize(new Dimension(25, 25));
        bp_Button.setMnemonic(KeyEvent.VK_B);
        bp_Button.setToolTipText("Backspace(Alt-B)");
        bp_Button.setActionCommand(bp_Label);
        bp_Button.addActionListener(new Controller());
        show.add(bp_Button);
        topPanel.add(show, BorderLayout.NORTH);
        
        
        /* Button Panel:- */        
        /* Checkbox and radio_panels */
        JPanel topPanel_2 = new JPanel();
        topPanel_2.setLayout(new FlowLayout());
        topPanel_2.setBackground(Color.black);
        
        /* New panel for radio buttons */
        JPanel radioPanel = new JPanel();
        radioPanel.setBackground(Color.black);
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.LINE_AXIS));
        ButtonGroup radioButtons = new ButtonGroup();
        /* Creating check_box */
        JPanel checkBoxI = new JPanel();
        checkBoxI.setBackground(Color.black);
        /* Align radio buttons and check box */
        topPanel_2.add(checkBoxI, BorderLayout.WEST);
        topPanel_2.add(radioPanel, BorderLayout.EAST);
        /* Add the whole thing to the topPanel */
        topPanel.add(topPanel_2, BorderLayout.SOUTH);
        this.add(topPanel, BorderLayout.NORTH);
        
        /* Check box settings */
        String ILabel = "Int";
        JCheckBox ICheckBox = new JCheckBox(ILabel);
        ICheckBox.setBackground(Color.green);
        ICheckBox.setActionCommand(ILabel);
        ICheckBox.addActionListener(new Controller());
        checkBoxI.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        checkBoxI.add(ICheckBox);
        
        /* One Decimal Radio Button*/
        String OneZD = ".0";
        JRadioButton OneZDB = new JRadioButton(OneZD);
        OneZDB.setBackground(Color.yellow);
        OneZDB.setActionCommand(OneZD);
        OneZDB.addActionListener(new Controller());
        radioPanel.add(OneZDB);
        radioButtons.add(OneZDB);
        
        /* Two Decimal Radio Button*/
        String TwoZD = ".00";
        JRadioButton TwoZDB = new JRadioButton(TwoZD);
        TwoZDB.setBackground(Color.yellow);
        TwoZDB.setActionCommand(TwoZD);
        TwoZDB.addActionListener(new Controller());
        /* Setting it as a the default button at start */
        TwoZDB.setSelected(true);
        radioPanel.add(TwoZDB);
        radioButtons.add(TwoZDB);
        
        /* Sci radio button */
        String sciFunctionLabel = "Sci";
        JRadioButton sciRadioButton = new JRadioButton(sciFunctionLabel);
        sciRadioButton.setActionCommand(sciFunctionLabel);
        sciRadioButton.setBackground(Color.yellow);
        sciRadioButton.addActionListener(new Controller());
        radioPanel.add(sciRadioButton);
        radioButtons.add(sciRadioButton);

        /* Number_pads and up-down panel */
        JPanel numPUD = new JPanel(new BorderLayout());
        /* Sub panel for number_pads */
        JPanel numPP = new JPanel(new GridLayout(4, 4, 5, 5));
        numPP.setBorder(BorderFactory.createEmptyBorder(5, 2, 1, 2));
        
        /* Coloring. Yellow for arithmetic symbols and rest is black*/
        Pattern regex = Pattern.compile("[\u2215.\u2217.\u2212.+]");    
        /* Loop for creating buttons for each pad and the add to panel. */
        for (String label: NUM_PAD_LABELS)
        {
            /* If match is found then yellow : otherwise black */
            Color foregroundColor = regex.matcher(label).matches() ? Color.yellow : Color.black;
            /* Other parameters as per requirements */
            JButton button = createButton(label, label, foregroundColor, Color.blue, new Controller());
            /* If dot - then new button */
            if (label.equals("."))
                dotButton = button;   
            numPP.add(button);
        }
        
        /* Add numberpad - up&down to main panel */
        numPUD.add(numPP, BorderLayout.CENTER);
        /* Creating panel and labels for Clear (C) and Equal (=) */
        JPanel topPanel_CE = new JPanel(new GridLayout(1, 2, 5, 5));
        JPanel bottomPanel_CE = new JPanel(new GridLayout(1, 2, 5, 5));
        String CLabel = "C";
        String ELabel = "=";   
        /* Top panel for Clear and Equal */
        JButton cButton = createButton(CLabel, CLabel, null, Color.red, new Controller());
        cButton.setForeground(Color.black);
        JButton eButton = createButton(ELabel, ELabel, null, Color.yellow, new Controller());
        eButton.setForeground(Color.black);
        topPanel_CE.add(cButton);
        topPanel_CE.add(eButton);
        /* Positioning pad */
        numPUD.add(topPanel_CE, BorderLayout.NORTH);
        this.add(numPUD, BorderLayout.CENTER);
        /* Bottom panel for Clear and Equal */
        JButton eButton_2 = createButton(ELabel, ELabel, null, Color.yellow, new Controller());
        eButton_2.setForeground(Color.black);
        JButton cButton_2 = createButton(CLabel, CLabel, null, Color.red, new Controller());
        cButton_2.setForeground(Color.black);
        bottomPanel_CE.add(eButton_2);
        bottomPanel_CE.add(cButton_2);
        /* Positioning pad */
        numPUD.add(bottomPanel_CE, BorderLayout.SOUTH);
        this.add(numPUD, BorderLayout.CENTER);
    }

    /****************************************************************************************
    * @Purpose:            To create each button for the interface                          *
    * @Param:              String text,String ac,Color fg,Color bg,ActionListener handler   *
    * @Return:             JButton                                                          *
    ****************************************************************************************/    
    private JButton createButton(String text, String ac, Color fg, Color bg, ActionListener handler)
    {
        /* Create object with the text given */
        JButton button = new JButton(text);        
        /* If ac is NULL set to button */
        if (ac != null) {
            button.setActionCommand(ac);
        }
        /* Set font to size 20 as per requirement */
        button.setFont(new Font(button.getFont().getName(), button.getFont().getStyle(), 20));
        /* Foreground and background color */
        button.setForeground(fg);
        button.setBackground(bg);
        /* If handler is null set to button */
        if (handler != null){
            button.addActionListener(handler);
        }       
       return button; 
    }
    /********************************************************************************
    * @Purpose:             To handle all events and display it on the text field   *
    * @Author:              Niladri Sengupta                                        *
    * @Version:             1.0                                                     *
    * @See:                 calculator_a1_1, CalculatorView (Outer Class)           *
    * @Since:               8.2                                                     *
    *********************************************************************************/
    /* Private inner class: Controller */
    private class Controller implements ActionListener
    {
        /* Responsible for all the events generated and display it */
        /****************************************************
        * @Purpose:            To listen for an event       *
        * @Param:              ActionEvent e                *
        * @Return:             N/A                          *
        ****************************************************/    
        @Override
        public void actionPerformed(ActionEvent e)
        {
            CalculatorView.this.display.setText(e.getActionCommand());
        }
        
    }
    
}


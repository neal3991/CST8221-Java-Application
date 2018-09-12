/************************************************************************************************************************************
* Filename:                     CalculatorView.java                                                                                 *
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
    /* Setting upt backscpace button with its respetive label*/
    private static final String BP_LABEL = "\u21D0";
    private static final String I_LABEL = "Int";
    private static final String ONE_ZD = ".0";
    private static final String TWO_ZD = ".00";
    private static final String C_LABEL = "C";
    private static final String E_LABEL = "=";
    private static final String MUL = "\u2217";
    private static final String DIV = "\u2215";
    private static final String PLUS = "+";
    private static final String MINUS = "\u2212";
    private static final String DOT = "\u22C5";
    private static final String PLUS_MINUS = "\u2213";
    private static final String SCI_MODE = "Sci";
    private static final String F_MODE = "F";
    private static final String I_MODE = "I";
    
    
    
    
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
        Controller control = new Controller();
        /* Initializing elements and setting up borders and layout */
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black));
        
        /* Creating and setting top panel to white */
        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel show = new JPanel();
        show.setBackground(Color.white);
        
        /* Mode/Error Display Label */
        error = new JLabel(F_MODE);
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
        
        
        JButton bp_Button = new JButton(BP_LABEL);        
        /* Transparent, Red border, tool-tip, etc. */
        bp_Button.setContentAreaFilled(false);
        bp_Button.setBorder(BorderFactory.createLineBorder(Color.red, 1));
        bp_Button.setForeground(Color.red);
        bp_Button.setPreferredSize(new Dimension(25, 25));
        bp_Button.setMnemonic(KeyEvent.VK_B);
        bp_Button.setToolTipText("Backspace(Alt-B)");
        bp_Button.setActionCommand(BP_LABEL);
        bp_Button.addActionListener(control);
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
        
        JCheckBox ICheckBox = new JCheckBox(I_LABEL);
        ICheckBox.setBackground(Color.green);
        ICheckBox.setActionCommand(I_LABEL);
        ICheckBox.addActionListener(control);
        checkBoxI.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        checkBoxI.add(ICheckBox);
        
        /* One Decimal Radio Button*/
        
        JRadioButton ONE_ZDB = new JRadioButton(ONE_ZD);
        ONE_ZDB.setBackground(Color.yellow);
        ONE_ZDB.setActionCommand(ONE_ZD);
        ONE_ZDB.addActionListener(control);
        radioPanel.add(ONE_ZDB);
        radioButtons.add(ONE_ZDB);
        
        /* Two Decimal Radio Button*/
        
        JRadioButton TWO_ZDB = new JRadioButton(TWO_ZD);
        TWO_ZDB.setBackground(Color.yellow);
        TWO_ZDB.setActionCommand(TWO_ZD);
        TWO_ZDB.addActionListener(control);
        /* Setting it as a the default button at start */
        TWO_ZDB.setSelected(true);
        radioPanel.add(TWO_ZDB);
        radioButtons.add(TWO_ZDB);
        
        /* Sci radio button */
        
        JRadioButton sciRadioButton = new JRadioButton(SCI_MODE);
        sciRadioButton.setActionCommand(SCI_MODE);
        sciRadioButton.setBackground(Color.yellow);
        sciRadioButton.addActionListener(control);
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
            JButton button = createButton(label, label, foregroundColor, Color.blue, control);
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
        
        /* Top panel for Clear and Equal */
        JButton cButton = createButton(C_LABEL, C_LABEL, null, Color.red, control);
        cButton.setForeground(Color.black);
        JButton eButton = createButton(E_LABEL, E_LABEL, null, Color.yellow, control);
        eButton.setForeground(Color.black);
        topPanel_CE.add(cButton);
        topPanel_CE.add(eButton);
        /* Positioning pad */
        numPUD.add(topPanel_CE, BorderLayout.NORTH);
        this.add(numPUD, BorderLayout.CENTER);
        /* Bottom panel for Clear and Equal */
        JButton eButton_2 = createButton(E_LABEL, E_LABEL, null, Color.yellow, control);
        eButton_2.setForeground(Color.black);
        JButton cButton_2 = createButton(C_LABEL, C_LABEL, null, Color.red, control);
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
    /************** ******************************************************************
    * @Purpose:             To handle all events and display it on the text field   *
    * @Author:              Niladri Sengupta                                        *
    * @Version:             1.0                                                     *
    * @See:                 calculator_a1_1, CalculatorView (Outer Class)           *
    * @Since:               8.2                                                     *
    *********************************************************************************/
    /* Private inner class: Controller */
    private class Controller implements ActionListener {
        /* CalculatorModel class object */
        private CalculatorModel calc;
        /* Current value of input */
        private String curr_Input = "";
        /* Current selected operation */
        private boolean curr_Operator;
        /* Is result visible or not */
        private boolean result_Visible;
        /* Has the object been cleared or not */
        private boolean deleted;
        /* Whether dot is pressed or not*/
        private boolean dot_Pressed;
        
        /********************************************************************
        * @Purpose:            Default constructor for this class           *
        * @Param:              N/A                                          *
        * @Return:             N/A                                          *
        ********************************************************************/
        public Controller() {
            /* Obeject initializers */
            calc = new CalculatorModel();
            deleted = true; //true for calculator being ready
            dot_Pressed = false;
            result_Visible = false;
            deleted = false;
            curr_Operator = false;
        }
        
        /***************************************************************************
        * @Purpose:            Set the appropriate actions to its designated place *
        * @Param:              ActionEvent e                                       *
        * @Return:             N/A                                                 *
        ****************************************************************************/    
        @Override
        public void actionPerformed(ActionEvent e) {
            /* Getting the current action */
            String curr_Action = e.getActionCommand();
            /* For displaying on the text field */
            String new_Text = display.getText();
            
            /* If "C" then Clear */
            /* And check for possile error */
            if (curr_Action.equals(C_LABEL)) {
                if (error.getText().trim().equals("E")) {
                    if (calc.getOperMode() == CalculatorModel.OpMode.Integer) {
                        error.setText(I_LABEL);
                        error.setBackground(Color.GREEN);
                    }
                    else {
                        error.setText(F_MODE);
                        error.setBackground(Color.YELLOW);

                    }
                }
                calc.delete();
                curr_Input = "";
                new_Text = calc.getResult();
                dot_Pressed = false;
                result_Visible = false;
                deleted = true;
                curr_Operator = false;
            }
            /* If "=" then get result */
            /* And check for possile error */
            else if (curr_Action.equals(E_LABEL)) {
                if (error.getText().trim().equals("E")) {
                    return;
                }
                new_Text = compute();
                
                if (new_Text == "--") {
                    error.setText("E");	
                    error.setBackground(Color.RED);
                }
            } 
            /* If "*" then Multiply*/
            /* And check for possile error */
            else if (curr_Action.equals(MUL)) {
                if (error.getText().trim().equals("E")) {
                    return;
                }                
                setOpandInput(CalculatorModel.Oper.Multiplication);
            }
            /* If "/" then Divide */
            /* And check for possile error */
            else if (curr_Action.equals(DIV)) {
                if (error.getText().trim().equals("E")) {
                    return;
                }
                setOpandInput(CalculatorModel.Oper.Division);
            } 
            /* If "+" then Addition */
            /* And check for possile error */
            else if (curr_Action.equals(PLUS)) {
                if (error.getText().trim().equals("E")) {
                    return;
                }

                setOpandInput(CalculatorModel.Oper.Addition);
            }
            /* If "-" then Substract */
            /* And check for possile error */
            else if (curr_Action.equals(MINUS)) {
                if (error.getText().trim().equals("E")) {
                    return;
                }
                
                setOpandInput(CalculatorModel.Oper.Subtraction);
            }
            /* If "." then dotPressed*/
            /* And check for possile error */
            else if (curr_Action.equals(DOT)) {
                if (error.getText().trim().equals("E")) {
                    return;
                }
                
                if (!dot_Pressed) {
                    curr_Input += curr_Action;
                    new_Text = curr_Input;
                }
                
                dot_Pressed = true;
            }
            /* If "+/-" then change sign */
            /* And check for possile error */
            else if (curr_Action.equals(PLUS_MINUS)) {
                if (error.getText().trim().equals("E")) {
                    return;
                }

                String curr_String = display.getText();
                if (curr_String.length() != 0) {
                    if (curr_String.startsWith("-")) {
                        new_Text = curr_String.substring(1, curr_String.length());
                    }
                    else {
                        new_Text = "-" + curr_String;
                    }                    
                    curr_Input = new_Text;
                }
            }
            /* If "<-" then Backspace */
            /* And check for possile error */
            else if (curr_Action.equals(BP_LABEL)) {
                if (error.getText().trim().equals("E")) {
                    return;
                }

                String curr_String = display.getText();
                if ( (curr_String.length() <= 1) || (curr_String.length() == 2 && curr_String.startsWith("-"))|| curr_String.trim().equals("0.0") ) {
                    if (calc.getOperMode() == CalculatorModel.OpMode.Integer ) {
                        new_Text = "0";	
                    }
                    else {
                        new_Text = "0.0";	
                    }
                }
                else {
                    String tempString = curr_String.substring(0, curr_String.length()-1);
                    if (tempString.endsWith(".")) {
                        tempString = tempString.substring(0, tempString.length()-1);
                    }

                    new_Text = tempString;
                }
                curr_Input = new_Text;
            }
            /* If "I" then mode is Int */
            /* And check for possile error */
            else if (curr_Action.equals(I_LABEL)) {
                JCheckBox cb = (JCheckBox)e.getSource();
                
                if (cb.isSelected()) {
                    calc.setOperMode(CalculatorModel.OpMode.Integer);

                    if (error.getText().trim().equals("E")) {
                        return;
                    }

                    error.setText(I_MODE);
                    error.setBackground(Color.GREEN);
                    dotButton.setEnabled(false);
                    Double number = Double.parseDouble(display.getText());
                    new_Text = "" + number.intValue();
                }
                else {
                    calc.setOperMode(CalculatorModel.OpMode.Float);

                    if (error.getText().trim().equals("E")) {
                        return;
                    }

                    error.setText(F_MODE);
                    dotButton.setEnabled(true);
                    error.setBackground(Color.YELLOW);
                    new_Text = "" + Double.parseDouble(display.getText());
                }
            }
            /* If ".0" then one decimal */
            /* And check for possile error */
            else if (curr_Action.equals(ONE_ZD)) {
                calc.setPrec(CalculatorModel.Prec.Single);
                new_Text = calc.getResult();
            }
            /* If ".00" then two decimal */
            /* And check for possile error */
            else if (curr_Action.equals(TWO_ZD)) {
                calc.setPrec(CalculatorModel.Prec.Double);
                new_Text = calc.getResult();
            }
            /* If "Sci" then mode is scientific */
            /* And check for possile error */
            else if (curr_Action.equals(SCI_MODE)) {
                calc.setPrec(CalculatorModel.Prec.Scientific);
                new_Text = calc.getResult();
            }            
            else {
              if (error.getText().trim().equals("E")) {
                return;
              }
              curr_Input += curr_Action;
              new_Text = curr_Input;
            }
            deleted = false;
            display.setText(new_Text);
            repaint();
        }
        /***************************************************************************
        * @Purpose:            Set the operands and values                         *
        * @Param:              CalculatorModel oper                                *
        * @Return:             N/A                                                 *
        ****************************************************************************/ 
        private void setOpandInput(CalculatorModel.Oper oper) {
            /* Setting the operation values if displaying is required */
            if (result_Visible) {
                calc.setNum1(Double.parseDouble(display.getText()));
                result_Visible = false;
            }
            else {
                if (!curr_Operator) {
                    calc.setNum1(Double.parseDouble(curr_Input));
                }
            }
            calc.setOper(oper);
            curr_Input = "";
            dot_Pressed = false;
            curr_Operator = true;
        }
        /**********************************************************************************
        * @Purpose:            Calculates the result based on the given input and operand *
        * @Param:              N/A                                                        *
        * @Return:             N/A                                                        *
        **********************************************************************************/
        private String compute() {
            /* Computing result while making sure input and operands are valid */
            if (curr_Input != "") {
                calc.getNum2(Double.parseDouble(curr_Input));
            }
            else {
                calc.getNum2(calc.getNum1());
            }

            if (!curr_Operator) {
                return display.getText();
            }
            calc.performCalculations();
            curr_Input = "";
            dot_Pressed = false;
            result_Visible = true;
            curr_Operator = false;
            return calc.getResult();
        }        
    }
    
}
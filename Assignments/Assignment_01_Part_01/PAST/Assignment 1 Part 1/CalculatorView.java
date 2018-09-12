

/* imports */
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



@SuppressWarnings("serial") //disregard warnings for not serializing

public class CalculatorView extends JPanel {
    
    //string array for numeric values to be displayed on keypad
    private static final String[] NUM_PAD_LABELS = new String[]
    {
      "7","8","9","/","4","5","6","*","1","2","3","-","\u00B1","0",".","+"
    };
    
    private JTextField display; //the calculator display field reference
    private JLabel error; //the error display label reference
    private JButton dotButton; //the decimal point (dot) button reference
    
    //default constructor & initializing elements in panel
    public CalculatorView()
    { 
        /* Top panel start here */
        
        //setting border layout
        this.setLayout(new BorderLayout());
        //setting border size and color
        this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black));
        
        //creating top pannel and making it white
        JPanel displayAndUpPanel = new JPanel(new BorderLayout());
        JPanel showPanel = new JPanel();
        showPanel.setBackground(Color.white);
        
        //creating error label and setting its properties
        error = new JLabel("F");
        error.setPreferredSize(new Dimension(25, 25));
        error.setBackground(Color.yellow);
        error.setOpaque(true);
        error.setHorizontalAlignment(JLabel.CENTER);
        //display error label
        showPanel.add(error);
        
        //creating text field and setting its properties
        display = new JTextField("0.0", 16);
        display.setBackground(Color.white);
        display.setPreferredSize(new Dimension(0, 30));
        display.setHorizontalAlignment(JTextField.RIGHT);
        //won't let user enter values from keyboard
        display.setEditable(false);        
        //display text field
        showPanel.add(display);
        
        //set backspace label and creating button for it
        String backSpaceLabel = "\u2190";
        JButton backSpaceButton = new JButton(backSpaceLabel);        
        //creating backspace button
        //set transparency, borders, colors, dimensions, alt-b, tool tip text
        backSpaceButton.setContentAreaFilled(false);
        backSpaceButton.setBorder(BorderFactory.createLineBorder(Color.red, 1));
        backSpaceButton.setForeground(Color.red);
        backSpaceButton.setPreferredSize(new Dimension(25, 25));
        backSpaceButton.setMnemonic(KeyEvent.VK_B);
        backSpaceButton.setToolTipText("Backspace(Alt-B)");
        backSpaceButton.setActionCommand(backSpaceLabel);
        backSpaceButton.addActionListener(new Controller());
        //display upper panel
        showPanel.add(backSpaceButton);
        displayAndUpPanel.add(showPanel, BorderLayout.NORTH);
        
        /* Int & radio buttons panel start here */
        
        //now creating panel for check box and radio buttons
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.setBackground(Color.black);
        
        //create panel for radio buttons
        JPanel radioButtonsPanel = new JPanel();
        radioButtonsPanel.setBackground(Color.black);
        //display all radio buttons in one group
        radioButtonsPanel.setLayout(new BoxLayout(radioButtonsPanel, BoxLayout.LINE_AXIS));
        
        //create object for radio buttons
        ButtonGroup radioButtons = new ButtonGroup();
        
        //create check box for Int function
        JPanel checkBoxInt = new JPanel();
        checkBoxInt.setBackground(Color.black);
        //positioning of check box and radio buttons
        topPanel.add(checkBoxInt, BorderLayout.WEST);
        topPanel.add(radioButtonsPanel, BorderLayout.EAST);
        //displaying top panel
        displayAndUpPanel.add(topPanel, BorderLayout.SOUTH);
        this.add(displayAndUpPanel, BorderLayout.NORTH);
        
        //settings for check box for Int function
        String IntLabel = "Int";
        JCheckBox IntCheckBox = new JCheckBox(IntLabel);
        IntCheckBox.setBackground(Color.green);
        IntCheckBox.setActionCommand(IntLabel);
        IntCheckBox.addActionListener(new Controller());
        //gap between int function and radio buttons
        checkBoxInt.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        //add to panel
        checkBoxInt.add(IntCheckBox);
        
        //create single decimal radio button and its settings
        String oneDecimalLabel = ".0";
        JRadioButton oneDecimalRadioButton = new JRadioButton(oneDecimalLabel);
        oneDecimalRadioButton.setBackground(Color.yellow);
        oneDecimalRadioButton.setActionCommand(oneDecimalLabel);
        oneDecimalRadioButton.addActionListener(new Controller());
        //add to panel
        radioButtonsPanel.add(oneDecimalRadioButton);
        radioButtons.add(oneDecimalRadioButton);
        
        //create double decimal radio button and its settings
        String doubleDecimalLabel = ".00";
        JRadioButton doubleDecimalRadioButton = new JRadioButton(doubleDecimalLabel);
        doubleDecimalRadioButton.setBackground(Color.yellow);
        doubleDecimalRadioButton.setActionCommand(doubleDecimalLabel);
        doubleDecimalRadioButton.addActionListener(new Controller());
        //set as default radio button
        doubleDecimalRadioButton.setSelected(true);
        //add to panel
        radioButtonsPanel.add(doubleDecimalRadioButton);
        radioButtons.add(doubleDecimalRadioButton);
        
        //create sci radio button and its settings
        String sciFunctionLabel = "Sci";
        JRadioButton sciRadioButton = new JRadioButton(sciFunctionLabel);
        sciRadioButton.setActionCommand(sciFunctionLabel);
        sciRadioButton.setBackground(Color.yellow);
        sciRadioButton.addActionListener(new Controller());
        //add to panel
        radioButtonsPanel.add(sciRadioButton);
        radioButtons.add(sciRadioButton);
        
        /* Now, number pads and side panels start here */
        
        //creating panel for number pads and pads on both sides
        JPanel numberPadsAndSidesPanel = new JPanel(new BorderLayout());
        
        //creating sub panel for number pads and setting properties
        JPanel numberPadsPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        numberPadsPanel.setBorder(BorderFactory.createEmptyBorder(5, 2, 1, 2));
        
        //check what function is pad
        Pattern regex = Pattern.compile("[\\d.\\u00B1]");
        
        //create button, label & command for each pad & add to panel
        for (String label: NUM_PAD_LABELS)
        {
            //if not numeric, make it yellow
            Color foregroundColor = regex.matcher(label).matches() ? Color.black : Color.yellow;
            //create button according to parameters
            JButton button = createButton(label, label, foregroundColor, Color.blue, new Controller());
            
            //if dot, then point to new button
            if (label.equals("."))
                dotButton = button;
            
            numberPadsPanel.add(button);
        }
        
        //add number panel to main panel and align
        numberPadsAndSidesPanel.add(numberPadsPanel, BorderLayout.CENTER);
        
        //creating side panel for clear
        JPanel sidePanelClear = new JPanel(new GridLayout(1, 2, 5, 5));
        
        //create label for clear button, button and add to panel
        String clearLabel = "C";
        JButton clearButton = createButton(clearLabel, clearLabel, null, Color.red, new Controller());
        clearButton.setForeground(Color.black);
        sidePanelClear.add(clearButton);
        
        //positioning clear pad
        numberPadsAndSidesPanel.add(sidePanelClear, BorderLayout.WEST);
        this.add(numberPadsAndSidesPanel, BorderLayout.CENTER);
        
        //creating side panel for clear
        JPanel sidePanelEqual = new JPanel(new GridLayout(1, 2, 5, 5));
        
        //create label for equal button, button and add to panel
        String equalLabel = "=";
        JButton equalButton = createButton(equalLabel, equalLabel, null, Color.yellow, new Controller());
        equalButton.setForeground(Color.black);
        sidePanelEqual.add(equalButton);
        
        
        //positioning equal pad
        numberPadsAndSidesPanel.add(sidePanelEqual, BorderLayout.EAST);
        this.add(numberPadsAndSidesPanel, BorderLayout.CENTER);
    } //end of default constructor
    

    private JButton createButton(String text, String ac, Color fg, Color bg, ActionListener handler)
    {
        //create object with label
        JButton button = new JButton(text);
        
        //if null, assign to button
        if (ac != null)
            button.setActionCommand(ac);
        
        //resize the font to size 20
        button.setFont(new Font(button.getFont().getName(), button.getFont().getStyle(), 20));
        
        //set fg and bg color
        button.setForeground(fg);
        button.setBackground(bg);
        
        //if null, assign to button
        if (handler != null)
            button.addActionListener(handler);
        
       return button; 
    } //end of method createButton()
    

    private class Controller implements ActionListener
    {
        //if the check box or any buttonis clicked the code of the method must get the action command string 
        //from the event and display it on the calculator text field display
        @Override
        public void actionPerformed(ActionEvent e)
        {
            CalculatorView.this.display.setText(e.getActionCommand());
        } //end of method actionPerformed()
        
    } //end of inner class Controller
    
} //end of class CalculatorView

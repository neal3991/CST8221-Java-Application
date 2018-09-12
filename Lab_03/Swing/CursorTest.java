/* CST8221-JAP: LAB 03, Exercise 2 
   File name: CursorTest.java
*/
import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 Demonstrates different cursors.
 @version 1.16.2
 @author Svillen Ranev
 #since Java 1.2
*/
public class CursorTest extends JFrame {
 //default serial version ID - Swing components implement the Serializable interface 
 //generate a real serial version ID after your code has been completed and working 
 private static final long serialVersionUID = 1L; 
    
    //fields declarations
    private JButton button_01;
    private JPanel pane;
    private JLabel label_02;  
    private static final String FRAME_TITLE = "Cursor Test";
    private String labelText = "The current cursor name is: ";
    private int [] cursors;
    private int cursorCounter;
    private int cursorsMaxNumber;
/**
  Default constructor. Sets the GUI.
*/    
   public CursorTest(){
     //set the frame title
     super(FRAME_TITLE);
   //initialize the array of cursors here using the predefined constants in the Cursor class
   //use an anonymous array to perform the initialization
/*******************************/
   cursors = new int[] {Cursor.DEFAULT_CURSOR, Cursor.CROSSHAIR_CURSOR, Cursor.TEXT_CURSOR, Cursor.WAIT_CURSOR, Cursor.N_RESIZE_CURSOR, Cursor.S_RESIZE_CURSOR, Cursor.W_RESIZE_CURSOR, Cursor.E_RESIZE_CURSOR, Cursor.SW_RESIZE_CURSOR, Cursor.SE_RESIZE_CURSOR, Cursor.NW_RESIZE_CURSOR, Cursor.NE_RESIZE_CURSOR, Cursor.HAND_CURSOR, Cursor.MOVE_CURSOR};
/*******************************/
   cursorsMaxNumber = cursors.length-1;
   // Create and set up containers and components.
   button_01 = createButton("Click to change cursor!");
     // create a label to show the name of the cursor
   label_02 = new JLabel(labelText + Cursor.getDefaultCursor().getName());
   pane = new JPanel();
   // set a border around the JPanel
   pane.setBorder(BorderFactory.createEmptyBorder(25, 25, 10, 25));
   // change the default Layout Manager
   // use GridLayout with 2 rows and 1 column
   pane.setLayout(new GridLayout(2, 1));
     // Add components to JPanel container.
   pane.add(button_01);
   pane.add(label_02);
      // Install JPanel pane as the content pane of the frame
         this.setContentPane(pane);  
 }
/**
   Creates a button and registers (adds) an ActionListener to process the events generated by the button.
   @param buttonName the button label.
*/   
   private JButton createButton(String buttonName){
     // Create a button 
 JButton  button = new JButton(buttonName);
   //set the initial size of the component
   //in most cases it is better to leave to the UI Manager to determine the preferred size
   button.setPreferredSize(new Dimension(button.getText().length()*20,50));
   // Create a keyboard shortcut: Pressing ALT-C will act as a mouse click on the button 
 button.setMnemonic('C');
 // Create a Tool Tip. Will show up when the mouse hovers over the button
 button.setToolTipText("Please Click Me");
   // Handle the button clicks. Anonymous class is used to handle the events.
   // No need to check for the event source anymore.
   // Now each individual button will be responsible to handle its own events.
   button.addActionListener (new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent ae) {
      //button action: change the cursor shape
      // create a new cursor here: use Cursor.getPredefinedCursor()
      // using one of the cursors array elements as a parameter
/*******************************/    
    Cursor newCursor = new Cursor();/* add code here */
    //newCursor = 
    
    // set the button cursor here: call setCursor() on the button
    /* add code here */
    button_01.setCursor(newCursor);
    //set the label text here: use getName to get the name of the cursor
    /* add code here */
    label_02.setText(labelText + newCursor.getName());
/*******************************/
       if(cursorCounter ==  cursorsMaxNumber) cursorCounter= -1;     
      }
    });  
    return button;
   } 
/** 
  The main method.The GUI will start with the default Look and Feel 
  Anonymous class is used to pass the run method to the event dispatching thread.
  @param args not used
*/  
   public static void main(String[] args) {
     // Make all components to configured by the event dispatch thread.
     // This is the thread that passes user provoked events such as mouse clicks to 
     // the GUI components which have registered listeners for the events.
     // The following code fragment forces the statements in the run() method to be executed in the
     // event dispatching thread. 
     EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               CursorTest frame = new CursorTest();
               // set up the Close button (X) of the frame
               // no need to use explicitly a WindowListener. The line below will generate one for you. 
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setSize(300,400);
               frame.pack();
                
               // make the GUI visible
               frame.setVisible(true); 
            }
         });
     }
}

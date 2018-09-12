/*  CST8221-JAP: HA#07
    File name: FileChooserDemoFX.java
*/

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
/** 
 * This class Demonstrates how to use the JavaFX FileChooser class.
 * Link: http://docs.oracle.com/javafx/2/ui_controls/file-chooser.htm
 * @author Oracle JavaFX Documentation, modified by Sv. Ranev
 * @version 1.17.1
 * @since JavaFX 2.0
 * @see javax.swing.JFileChooser
 * @see javax.swing.filechooser.FileNameExtensionFilter
 */

public final class FileChooserDemoFX extends Application {

    private Desktop desktop = Desktop.getDesktop();

    @Override
    public void start(final Stage stage) {
        stage.setTitle("File Chooser Sample");

        final FileChooser fileChooser = new FileChooser();
        final Button openButton = new Button("Open a Picture...");
        final Button openMultipleButton = new Button("Open Pictures...");     
      
        openButton.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    configureFileChooser(fileChooser);
                    File file = fileChooser.showOpenDialog(stage);
                    if (file != null) {
                        openFile(file);
                    }
                }
            });

        openMultipleButton.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    configureFileChooser(fileChooser);                               
                    List<File> list = 
                        fileChooser.showOpenMultipleDialog(stage);
                    if (list != null) {
                        for (File file : list) {
                            openFile(file);
                        }
                    }
                }
            });


        final GridPane inputGridPane = new GridPane();

        GridPane.setConstraints(openButton, 0, 1);
        GridPane.setConstraints(openMultipleButton, 1, 1);
        inputGridPane.setHgap(6);
        inputGridPane.setVgap(6);
        inputGridPane.getChildren().addAll(openButton, openMultipleButton);
        
        final Pane rootGroup = new VBox(12);
        rootGroup.getChildren().addAll(inputGridPane);
        rootGroup.setPadding(new Insets(12, 12, 12, 12));

        stage.setScene(new Scene(rootGroup));
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    private static void configureFileChooser(
        final FileChooser fileChooser) {      
            fileChooser.setTitle("View Pictures");
            //set initial folder
            fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
               // new File(".")//current folder
            );                 
            //set filters
            fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
            );
    }

    private void openFile(File file) {
        try {
            /*The line below will open your desktop application
              currently associated with the extension of the file.
            */
            desktop.open(file);
        } catch (IOException ex) {
            //write the exception into a log file
            Logger.getLogger(FileChooserDemoFX.class.getName()).log(
                Level.SEVERE, null, ex
            );
        }
    }
}
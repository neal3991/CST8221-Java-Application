/*  CST8221-JAP: HA#06
    File name: JavaFXProgressDemo.java 
*/

//Progress Bar and Progress Indicator

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
* This class demonstrates how to use JavaFX Progress Bar and Progress Indicator. 
* For details visit: http://docs.oracle.com/javafx/2/ui_controls/progress.htm  
* @author Oracle JavaFV Documentation
* @version 1.17.1
* @see javafx.scene.control.ProgressBar
* @see javafx.scene.control.ProgressIndicator;
*/

public class JavaFXProgressDemo extends Application {

private final Float[] values = new Float[] {-1.0f, 0f, 0.6f, 1.0f};
private final Label [] labels = new Label[values.length];
private final ProgressBar[] pbs = new ProgressBar[values.length];
private final ProgressIndicator[] pins = new ProgressIndicator[values.length];
private final HBox hbs [] = new HBox [values.length];

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 300, 150);
        stage.setScene(scene);
        stage.setTitle("Progress Controls");

        for (int i = 0; i < values.length; i++) {
            final Label label = labels[i] = new Label();
            label.setText("progress:" + values[i]);

            final ProgressBar pb = pbs[i] = new ProgressBar();
            pb.setProgress(values[i]);

            final ProgressIndicator pin = pins[i] = new ProgressIndicator();
            pin.setProgress(values[i]);
            final HBox hb = hbs[i] = new HBox();
            hb.setSpacing(5);
            hb.setAlignment(Pos.CENTER);
            hb.getChildren().addAll(label, pb, pin);
        }

        final VBox vb = new VBox();
        vb.setSpacing(5);
        vb.getChildren().addAll(hbs);
        scene.setRoot(vb);
        stage.show();
    }
	
    public static void main(String[] args) {
        launch(args);
    }
}

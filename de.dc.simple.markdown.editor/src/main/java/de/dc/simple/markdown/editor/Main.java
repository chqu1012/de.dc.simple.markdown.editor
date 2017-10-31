package de.dc.simple.markdown.editor;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Borders");
        AnchorPane pane = new AnchorPane();
        
        Scene scene = new Scene(pane, 600, 330, Color.WHITE);
        
        AnchorPane cssEditorFld;
		try {
			cssEditorFld = FXMLLoader.load(getClass().getResource("MDEditor.fxml"));
			AnchorPane.setBottomAnchor(cssEditorFld, 0d);
			AnchorPane.setRightAnchor(cssEditorFld, 0d);
			AnchorPane.setLeftAnchor(cssEditorFld, 0d);
			AnchorPane.setTopAnchor(cssEditorFld, 0d);
			pane.getChildren().add(cssEditorFld);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
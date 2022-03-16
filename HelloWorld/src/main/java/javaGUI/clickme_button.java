package javaGUI;


import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class clickme_button extends Application
{
	Button btn;
	@Override public void start(Stage primaryStage)
	{
		//Create button
		btn = new Button();
		btn.setText("Click me please!");
		btn.setOnAction(e->buttonClick());
		
		//Add button to layout pane
		BorderPane pane = new BorderPane();
		pane.setCenter(btn);
		
		//Add layout pane to scene
		Scene scene = new Scene(pane,300,250);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Click Me Ultimate Clicker Game");
		primaryStage.show();
	}
	public void buttonClick()
	{
		if (btn.getText().equals("CLICK ME!"))
		{
			btn.setText("You clicked me!");
		}
		else 
		{
			btn.setText("CLICK ME!");
		}
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}

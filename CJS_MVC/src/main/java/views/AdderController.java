package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AdderController
{
	@FXML
    private Label firstNumLabel;

    @FXML
    private Label resultValLabel;

    @FXML
    private Label secondNumLabel;

    @FXML
    void onClickAdd(ActionEvent event) 
    {
    	System.out.println("Add Clicked");
    }
}

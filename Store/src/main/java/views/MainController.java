package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import models.ViewTransitionModelInterface;

public class MainController
{
	ViewTransitionModelInterface model;
	public void setModel(ViewTransitionModelInterface newModel)
	{
		model = newModel;
	}
	@FXML
    void onClickCash(ActionEvent event) 
    {
    	model.showCash();
		System.out.println("Cash Clicked");
    }

    @FXML
    void onClickGrocery(ActionEvent event) 
    {
    	model.showGroceries();
    	System.out.println("Grocery Clicked");
    }
}

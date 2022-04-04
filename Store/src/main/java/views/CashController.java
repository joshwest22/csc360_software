package views;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import models.StoreModel;

public class CashController
{
	StoreModel model;
	
	public void setModel(StoreModel newModel)
	{
		model = newModel;
		
		//bind label
		StringConverter<Number> fmt = new NumberStringConverter();
		
		Bindings.bindBidirectional(cashBalanceLabel.textProperty(), model.getMoney(),fmt);
	}
	
	private double getAmt()
	{
		double amt = 0;
		String val = deltaCashTextField.getText();
		
		try
		{
			amt = Double.parseDouble(val);
		}
		catch(NumberFormatException e)
		{
			deltaCashTextField.setText("");
		}
		return amt;
	}
	@FXML
    private Label cashBalanceLabel;

    @FXML
    private TextField deltaCashTextField;

    @FXML
    void onAddCash(ActionEvent event) 
    {
    	double value = getAmt();
    	model.deltaMoney(value);
    }

    @FXML
    void onRemoveCash(ActionEvent event) 
    {
    	double value = getAmt();
    	model.deltaMoney(-1*value);
    }
}

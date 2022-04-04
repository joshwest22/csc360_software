package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import models.GroceryItem;
import models.StoreModel;

public class GroceryController
{
	StoreModel model;
	
	public void setModel(StoreModel newModel)
	{
		model = newModel;
		grocView.setItems(model.getGroceries());
	}
	@FXML
    private ListView<GroceryItem> grocView;

    @FXML
    private TextField itemCostLabel;

    @FXML
    private TextField itemNameLabel;
    
    private double getAmt()
	{
		double amt = 0;
		String val = itemCostLabel.getText();
		
		try
		{
			amt = Double.parseDouble(val);
		}
		catch(NumberFormatException e)
		{
			itemCostLabel.setText("");
		}
		return amt;
	}
    
    @FXML
    void onAddItem(ActionEvent event) 
    {
    	GroceryItem gi = new GroceryItem(itemNameLabel.getText(),getAmt());
    	model.getGroceries().add(gi);
    }
}

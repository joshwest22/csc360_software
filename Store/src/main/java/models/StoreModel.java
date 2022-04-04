package models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StoreModel
{
	DoubleProperty money = new SimpleDoubleProperty();
	ObservableList<GroceryItem> groceries = FXCollections.observableArrayList();


public StoreModel()
{
	
}

public DoubleProperty getMoney()
{
	return money;
}

public void setMoney(DoubleProperty money)
{
	this.money = money;
}

public ObservableList<GroceryItem> getGroceries()
{
	return groceries;
}

public void setGroceries(ObservableList<GroceryItem> groceries)
{
	this.groceries = groceries;
}

public void deltaMoney(double amt)
{
	money.set(money.get()+amt);
}

}

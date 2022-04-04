package models;

import java.util.Objects;

public class GroceryItem
{
	String name;
	@Override
	public String toString()
	{
		return name + ": " + cost;
	}
	@Override
	public int hashCode()
	{
		return Objects.hash(cost, name);
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroceryItem other = (GroceryItem) obj;
		return Objects.equals(cost, other.cost) && Objects.equals(name, other.name);
	}
	public GroceryItem(String name, Double cost)
	{
		this.name = name;
		this.cost = cost;
	}
	Double cost;
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Double getCost()
	{
		return cost;
	}
	public void setCost(Double cost)
	{
		this.cost = cost;
	}
}

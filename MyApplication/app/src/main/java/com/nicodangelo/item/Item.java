package com.nicodangelo.item;

//version 1.0

public class Item
{
	String itemName;
	int amountOfItem;
	int warnLow;
	boolean isSelected = false;
	String type;
	String measurement;
	
	public SolidItems(String name, int amount, int low)
	{
		itemName = name;
		amountOfItem = amount;
		warnLow = low;
	}
   
   public SolidItems(String name, int amount)
	{
		itemName = name;
		amountOfItem = amount;
		warnLow = 0;
	}
   
   public SolidItems(String name)
	{
		itemName = name;
		amountOfItem = 0;
		warnLow = 0;
	}
	
	public SolidItems()
	{
		itemName = "";
		amountOfItem = 0;
		warnLow = 0;
	}
	public String getName()
	{
		return itemName;
	}
	
	public int getAmount()
	{
		return amountOfItem;
	}
    public int getLow()
	{
		return warnLow;
	}
	public boolean getSelected()
	{
		return isSelected;
	}
	public String getMeasurment()
	{
		return measurement;
	}
	public String getType()
	{
		return type;
	}
	public void setName(String name)
	{
		itemName = name;
	}
	
	public void setAmount(int newAmount)
	{
		amountOfItem = newAmount;
	}
   
	public void setLow(int low)
	{
		warnLow = low;
	}

	public void setSelected(boolean stuff)
	{
		isSelected = stuff;
	}
	public void setMeasurement(String s)
	{
		measurement = s;
	}
	public void setType(String s)
	{
		type = s;
	}
    public String getInfo()
    {
        if(amountOfItem != 0)
            return itemName + " " + amountOfItem;
        return itemName;
    }

}

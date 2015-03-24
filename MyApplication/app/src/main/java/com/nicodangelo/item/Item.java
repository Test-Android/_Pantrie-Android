package com.nicodangelo.item;

//version 1.0

public class Item
{
	String itemName;
	int amountOfItem;
	int warnLow;
	boolean isSelected = false;
	
	public Item(String name, int amount, int low)
	{
		itemName = name;
		amountOfItem = amount;
		warnLow = low;
	}
   
   public Item(String name, int amount)
	{
		itemName = name;
		amountOfItem = amount;
		warnLow = 0;
	}
   
   public Item(String name)
	{
		itemName = name;
		amountOfItem = 0;
		warnLow = 0;
	}
	
	public Item()
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
	
	public void setName(String name)
	{
		itemName = name;
	}
	
	public void setAmount(int newAmount)
	{
		amountOfItem = newAmount;
	}
   
    public int getLow()
	{
		return warnLow;
	}
	
	public void setLow(int low)
	{
		warnLow = low;
	}

	public boolean getSelected()
	{
		return isSelected;
	}

	public void setSelected(boolean stuff)
	{
		isSelected = stuff;
	}

    public String toString()
    {

        if(amountOfItem != 0)
            return itemName + " " + amountOfItem;
        return itemName;
    }


	

	
   
}

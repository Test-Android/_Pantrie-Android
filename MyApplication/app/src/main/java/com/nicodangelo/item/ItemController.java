//@Author Jett Kaspar
package com.nicodangelo.item;

import java.util.ArrayList;

public class ItemController
{
    public static ArrayList<Item> items = new ArrayList<Item>();
    public static int curSpot;
    public ItemController() {}

    public void printAll()
    {
        for(int k = 0; k < curSpot; k++)
        {
            System.out.print(items.get(k).getName());
        }
    }
    public void addItem(String s)
    {
        Item e = new Item(s);
        items.add(e);
        curSpot++;
    }

    public void setAmount(int i, int spot)
    {
        items.get(i).setAmount(spot);
    }
    public String getName(int spot)
    {
        return items.get(spot).getName();
    }
    public void setLowAmount(int spot, int low)
    {
        items.get(spot).setLow(low);
    }
    public int getSpot()
    {
        return curSpot;
    }
}

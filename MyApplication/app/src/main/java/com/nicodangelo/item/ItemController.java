//@Author Jett Kaspar
package com.nicodangelo.item;

import java.util.ArrayList;

public class ItemController
{
    public static ArrayList<Item> items;
    public static int curSpot;
    public ItemController()
    {
        items = new ArrayList<Item>();
    }

    public void addItem(String s)
    {
        Item e = new Item(s);
        items.add(e);
        curSpot++;
    }
    public void setAmount(int i)
    {
        items.get(curSpot).setAmount(i);
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

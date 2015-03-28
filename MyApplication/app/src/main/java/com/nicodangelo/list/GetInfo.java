package com.nicodangelo.list;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.nicodangelo.item.ItemController;
import com.nicodangelo.pantrie.R;

import java.io.File;
import java.io.FileOutputStream;

public class GetInfo extends ActionBarActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        ItemController itemList = new ItemController();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_info);

        File state = getCacheDir();
        try
        {
            FileOutputStream fo = new FileOutputStream(state);
            fo.write("true".getBytes());
            fo.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        Intent i = getIntent();
        int spot = i.getIntExtra("spot",0);
        spot--;
        TextView itemName = (TextView) findViewById(R.id.itemName);
        TextView amount = (TextView) findViewById(R.id.textView);
        TextView lowAmount = (TextView) findViewById(R.id.textView3);
        TextView type = (TextView) findViewById(R.id.textView4);
        TextView mes = (TextView) findViewById(R.id.textView5);

        itemName.setText(itemList.getName(spot));
        amount.setText("Amount: " + itemList.getAmount(spot));
        lowAmount.setText("Low Amount: " + itemList.getAmount(spot));
        type.setText("Item Type: " + itemList.getType(spot));
        mes.setText("Measurement: " + itemList.getMes(spot));
    }
    public void back(View view)
    {
        Intent i = new Intent(this, ListMain.class);
        startActivity(i);
    }

}

package com.nicodangelo.list;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.nicodangelo.item.ItemController;
import com.nicodangelo.pantrie.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class EditList extends ActionBarActivity
{
    ItemController c = new ItemController();
    int spot;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_list);
        Intent i = getIntent();
        spot = i.getIntExtra("editList", 0);
        tv = (TextView) findViewById(R.id.textView);
        File temp = getCacheDir();
        String state = "";
        try
        {
            FileOutputStream os = new FileOutputStream(temp);
            os.write(("true").getBytes());
            os.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        tv.setText(c.getItem(0));
    }

}

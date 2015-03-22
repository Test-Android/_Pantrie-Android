package com.nicodangelo.list;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.nicodangelo.Util.Settings;
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
    EditText cAmount;
    EditText cLow;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_list);
        Intent i = getIntent();
        spot = c.getSpot() - 1;
        tv = (TextView) findViewById(R.id.textView);
        cAmount = (EditText) findViewById(R.id.cAmount);
        cLow = (EditText)findViewById(R.id.cLow);
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
        tv.setText(c.getName(spot));
    }
    public void commitChange(View view)
    {
        if(!TextUtils.isEmpty(cLow.getText()))
            c.setLowAmount(spot,Integer.parseInt(cLow.getText().toString()));
        if(!TextUtils.isEmpty(cAmount.getText()))
            c.setAmount(spot,Integer.parseInt(cAmount.getText().toString()));
        Intent what = new Intent(this, ListMain.class);
        startActivity(what);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            Intent i = new Intent(this, Settings.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}

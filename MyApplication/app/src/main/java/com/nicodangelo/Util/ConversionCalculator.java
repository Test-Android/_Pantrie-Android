//@author Jake Cox

package com.nicodangelo.Util;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import com.nicodangelo.list.ListMain;
import com.nicodangelo.pantrie.R;

public class ConversionCalculator extends ActionBarActivity
{
    AlertDialog.Builder ab;
    AlertDialog.Builder ac;
    EditText firstNumberText;
    EditText seccondNumberText;
    Button firstChoice;
    Button seccondChoice;
    String[] listItems1 = new String[]{"ounces"};
    String[] listItems2 = new String[]{"grams"};
    String firstIdent;
    String seccIdent;
    Button ConvertButton;
    double firstNum;
    double secNum;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_calculator);

        ab = new AlertDialog.Builder(this)
                .setTitle("Measurements")
                .setMessage("Pick a measurement to convert from.");
        ab.setCancelable(false);

        final Button ounces = new Button(ConversionCalculator.this);
        final Button grams = new Button(ConversionCalculator.this);

        ounces.setText("Ounces");
        ounces.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                firstChoice = (Button) findViewById(R.id.firstChoice);
                firstChoice.setText("ounces");
                firstIdent = "ounces";
            }
        });

        grams.setText("Grams");
        ounces.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                firstChoice = (Button) findViewById(R.id.seccondChoice);
                firstChoice.setText("ounces");
                firstIdent = "ounces";
            }
        });

        LinearLayout lay = new LinearLayout(ConversionCalculator.this);
        lay.setOrientation(LinearLayout.VERTICAL);
        lay.addView(grams);
        lay.addView(ounces);
        ab.setView(lay);
        ab.create();

        ac = new AlertDialog.Builder(this)
                .setTitle("Measurements")
                .setMessage("Pick a measurement to convert from.");
        ac.setCancelable(false);

        final Button ounces2 = new Button(ConversionCalculator.this);
        final Button grams2 = new Button(ConversionCalculator.this);

        ounces2.setText("Ounces");
        ounces2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                seccondChoice = (Button) findViewById(R.id.firstChoice);
                seccondChoice.setText("ounces");
                seccIdent = "ounces";
            }
        });

        grams2.setText("Grams");
        grams2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                seccondChoice = (Button) findViewById(R.id.seccondChoice);
                seccondChoice.setText("grams");
                seccIdent = "grams";
            }
        });

        LinearLayout lay2 = new LinearLayout(ConversionCalculator.this);
        lay2.setOrientation(LinearLayout.VERTICAL);
        lay2.removeAllViews();
        lay2.addView(grams2);
        lay2.addView(ounces2);
        ab.setView(lay2);
        ab.create();
    }

    public void convertThings(View view)
    {
        firstNumberText = (EditText)findViewById(R.id.firstNumberText);
        seccondNumberText = (EditText) findViewById(R.id.seccondNumberText);
        firstNum = Integer.parseInt(firstNumberText.getText().toString());
        System.out.println("number aquired!");

        if(firstIdent.equals("ounces") && seccIdent.equals("grams"))
        {
            secNum = firstNum * 28.3;
            String space = Double.toString(secNum);
            seccondNumberText.setText(space);
        }
    }
    public void firstChoiceDialog(View view)
    {
        ab.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_conversion_calculator, menu);
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

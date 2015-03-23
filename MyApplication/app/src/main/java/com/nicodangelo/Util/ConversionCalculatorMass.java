//@author Jake Cox

package com.nicodangelo.Util;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nicodangelo.pantrie.R;

public class ConversionCalculatorMass extends ActionBarActivity
{
    //They may be not used however these are all the "Objects" in the class that are active and do things:)
    private EditText input;
    private TextView output;
    private Button itemSelect1;
    private Button itemSelect2;
    private Button convert;
    private AlertDialog.Builder a;
    private AlertDialog ad;
    private AlertDialog.Builder b;
    private AlertDialog bd;
    private double inputNum = 0;
    private double outputNum = 0;
    private LinearLayout layout1;
    private LinearLayout layout2;
    private String index1 = "grams";
    private String index2 = "grams";

    //these are not used yet but are placements for later (keep these:))
    private String onceString;
    private String gramString;
    private String poundString;
    private String milligramString;
    private String kilogramsString;
    private String teaspoonString;
    private String tablespoonString;
    private String fluidOunceString;
    private String gillString;
    private String cupString;
    private String pintString;
    private String quartString;
    private String gallonString;
    private String milliliterString;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_calculator);
    }

///////////////////////////////////////////////////////////////////////////////////////////////////
    //When you hit the Conversion button all this happens!!
///////////////////////////////////////////////////////////////////////////////////////////////////
    public void makeConversion(View view)
    {
        input = (EditText) findViewById(R.id.input);
        if (TextUtils.isEmpty(input.getText().toString()))
        {
            Toast toast = Toast.makeText(getApplicationContext(), "Try Again... please", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        layout1.removeAllViews();
        layout2.removeAllViews();
        output = (TextView) findViewById(R.id.output);

        inputNum = Double.parseDouble(input.getText().toString());

        //There are a lot of if statements here:) They do all the maths for the conversions
        if (!TextUtils.isEmpty(input.getText().toString()))
        {
            //MASS AND WEIGHT
            if(index1.equals(index2)) {outputNum = inputNum;}
            if(index1.equals("ounces") && index2.equals("grams")) {outputNum = inputNum * 28.3;}
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////
            if(index1.equals("grams") && index2.equals("ounces")) {outputNum = inputNum * .0353;}
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////
            if(index1.equals("pounds") && index2.equals("grams")) {outputNum = inputNum * 453.59;}
            if(index1.equals("grams") && index2.equals("pounds")) {outputNum = inputNum * 0.0022046;}
            if(index1.equals("pounds") && index2.equals("ounces")) {outputNum = inputNum * 16.000;}
            if(index1.equals("ounces") && index2.equals("pounds")) {outputNum = inputNum * 0.062500;}
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////
            if(index1.equals("milligrams") && index2.equals("grams")) {outputNum = inputNum / 1000.0;}
            if(index1.equals("milligrams") && index2.equals("ounces")) {outputNum = inputNum * 0.000035274;}
            if(index1.equals("milligrams") && index2.equals("pounds")) {outputNum = inputNum * 0.000002204;}
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////
            if(index1.equals("grams") && index2.equals("milligrams")) {outputNum = inputNum / 0.0010000;}
            if(index1.equals("ounces") && index2.equals("milligrams")) {outputNum = inputNum * 28349.523;}
            if(index1.equals("pounds") && index2.equals("milligrams")) {outputNum = inputNum * 453592;}
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////
            if(index1.equals("kilograms") && index2.equals("grams")) {outputNum = inputNum * 1000.0;}
            if(index1.equals("kilograms") && index2.equals("ounces")) {outputNum = inputNum * 35.274;}
            if(index1.equals("kilograms") && index2.equals("pounds")) {outputNum = inputNum * 2.20462;}
            if(index1.equals("kilograms") && index2.equals("milligrams")) {outputNum = inputNum * 1000000;}
            if(index1.equals("ounces") && index2.equals("kilograms")) {outputNum = inputNum * 0.0283495;}
            if(index1.equals("pounds") && index2.equals("kilograms")) {outputNum = inputNum * 0.453592;}
            if(index1.equals("grams") && index2.equals("kilograms")) {outputNum = inputNum * 0.001;}
            if(index1.equals("milligrams") && index2.equals("kilograms")) {outputNum = inputNum * 0.000001;}

            //VOLUME
            if(index1.equals(index2)) {outputNum = inputNum;}
            if(index1.equals("teaspoon") && index2.equals("tablespoon")) {outputNum = inputNum * 0.33333;}
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////
            if(index1.equals("tablespoon") && index2.equals("teaspoon")) {outputNum = inputNum * 3;}
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////
            if(index1.equals("fluid ounce") && index2.equals("teaspoon")) {outputNum = inputNum * 6;}
            if(index1.equals("fluid ounce") && index2.equals("tablespoon")) {outputNum = inputNum * 2;}
            if(index1.equals("teaspoon") && index2.equals("fluid ounce")) {outputNum = inputNum * 0.166667;}
            if(index1.equals("tablespoon") && index2.equals("fluid ounce")) {outputNum = inputNum * 0.5;}
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////
            if(index1.equals("gill") && index2.equals("teaspoon")) {outputNum = inputNum * 24;}
            if(index1.equals("gill") && index2.equals("tablespoon")) {outputNum = inputNum * 8;}
            if(index1.equals("gill") && index2.equals("fluid ounce")) {outputNum = inputNum * 4;}
            if(index1.equals("teaspoon") && index2.equals("gill")) {outputNum = inputNum * 0.0416666667;}
            if(index1.equals("tablespoon") && index2.equals("gill")) {outputNum = inputNum * 0.125;}
            if(index1.equals("fluid ounce") && index2.equals("gill")) {outputNum = inputNum * 0.25;}
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////
            if(index1.equals("cup") && index2.equals("teaspoon")) {outputNum = inputNum * 48;}
            if(index1.equals("cup") && index2.equals("tablespoon")) {outputNum = inputNum * 16;}
            if(index1.equals("cup") && index2.equals("fluid ounce")) {outputNum = inputNum * 8;}
            if(index1.equals("cup") && index2.equals("gill")) {outputNum = inputNum * 2;}
            if(index1.equals("teaspoon") && index2.equals("cup")) {outputNum = inputNum * 0.0208333;}
            if(index1.equals("tablespoon") && index2.equals("cup")) {outputNum = inputNum * 0.0625;}
            if(index1.equals("fluid ounce") && index2.equals("cup")) {outputNum = inputNum * 0.125;}
            if(index1.equals("gill") && index2.equals("cup")) {outputNum = inputNum * 0.5;}
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////
            if(index1.equals("pint") && index2.equals("teaspoon")) {outputNum = inputNum * 96;}
            if(index1.equals("pint") && index2.equals("tablespoon")) {outputNum = inputNum * 32;}
            if(index1.equals("pint") && index2.equals("fluid ounce")) {outputNum = inputNum * 16;}
            if(index1.equals("pint") && index2.equals("gill")) {outputNum = inputNum * 4;}
            if(index1.equals("pint") && index2.equals("cup")) {outputNum = inputNum * 2;}
            if(index1.equals("teaspoon") && index2.equals("pint")) {outputNum = inputNum * 0.0104167;}
            if(index1.equals("tablespoon") && index2.equals("pint")) {outputNum = inputNum * 0.03125;}
            if(index1.equals("fluid ounce") && index2.equals("pint")) {outputNum = inputNum * 0.0625;}
            if(index1.equals("gill") && index2.equals("pint")) {outputNum = inputNum * 0.25;}
            if(index1.equals("cup") && index2.equals("pint")) {outputNum = inputNum * 0.5;}
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////
            if(index1.equals("quart") && index2.equals("teaspoon")) {outputNum = inputNum * 192;}
            if(index1.equals("quart") && index2.equals("tablespoon")) {outputNum = inputNum * 64;}
            if(index1.equals("quart") && index2.equals("fluid ounce")) {outputNum = inputNum * 32;}
            if(index1.equals("quart") && index2.equals("gill")) {outputNum = inputNum * 8;}
            if(index1.equals("quart") && index2.equals("cup")) {outputNum = inputNum * 4;}
            if(index1.equals("quart") && index2.equals("pint")) {outputNum = inputNum * 2;}
            if(index1.equals("teaspoon") && index2.equals("quart")) {outputNum = inputNum * 0.00520833;}
            if(index1.equals("tablespoon") && index2.equals("quart")) {outputNum = inputNum * 0.015625;}
            if(index1.equals("fluid ounce") && index2.equals("quart")) {outputNum = inputNum * 0.03125;}
            if(index1.equals("gill") && index2.equals("quart")) {outputNum = inputNum * 0.125;}
            if(index1.equals("cup") && index2.equals("quart")) {outputNum = inputNum * 0.25;}
            if(index1.equals("pint") && index2.equals("quart")) {outputNum = inputNum * 0.5;}
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////
            if(index1.equals("gallon") && index2.equals("teaspoon")) {outputNum = inputNum * 768;}
            if(index1.equals("gallon") && index2.equals("tablespoon")) {outputNum = inputNum * 256;}
            if(index1.equals("gallon") && index2.equals("fluid ounce")) {outputNum = inputNum * 128;}
            if(index1.equals("gallon") && index2.equals("gill")) {outputNum = inputNum * 32;}
            if(index1.equals("gallon") && index2.equals("cup")) {outputNum = inputNum * 16;}
            if(index1.equals("gallon") && index2.equals("pint")) {outputNum = inputNum * 8;}
            if(index1.equals("gallon") && index2.equals("quart")) {outputNum = inputNum * 4;}
            if(index1.equals("teaspoon") && index2.equals("gallon")) {outputNum = inputNum * 0.00130208;}
            if(index1.equals("tablespoon") && index2.equals("gallon")) {outputNum = inputNum * 0.00390625;}
            if(index1.equals("fluid ounce") && index2.equals("gallon")) {outputNum = inputNum * 0.0078125;}
            if(index1.equals("gill") && index2.equals("gallon")) {outputNum = inputNum * 0.03125;}
            if(index1.equals("cup") && index2.equals("gallon")) {outputNum = inputNum * 0.0625;}
            if(index1.equals("pint") && index2.equals("gallon")) {outputNum = inputNum * 0.125;}
            if(index1.equals("quart") && index2.equals("gallon")) {outputNum = inputNum * 0.25;}
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////
            if(index1.equals("milliliter") && index2.equals("teaspoon")) {outputNum = inputNum * 0.202884;}
            if(index1.equals("milliliter") && index2.equals("tablespoon")) {outputNum = inputNum * 0.067628;}
            if(index1.equals("milliliter") && index2.equals("fluid ounce")) {outputNum = inputNum * 0.33814;}
            if(index1.equals("milliliter") && index2.equals("gill")) {outputNum = inputNum * 0.00845350568;}
            if(index1.equals("milliliter") && index2.equals("cup")) {outputNum = inputNum * 0.00422675;}
            if(index1.equals("milliliter") && index2.equals("pint")) {outputNum = inputNum * 0.00211338;}
            if(index1.equals("milliliter") && index2.equals("quart")) {outputNum = inputNum * 0.00105669;}
            if(index1.equals("milliliter") && index2.equals("gallon")) {outputNum = inputNum * 0.000264172;}
            if(index1.equals("teaspoon") && index2.equals("milliliter")) {outputNum = inputNum * 4.92892;}
            if(index1.equals("tablespoon") && index2.equals("milliliter")) {outputNum = inputNum * 14.7868;}
            if(index1.equals("fluid ounce") && index2.equals("milliliter")) {outputNum = inputNum * 29.5735;}
            if(index1.equals("gill") && index2.equals("milliliter")) {outputNum = inputNum * 118.294118;}
            if(index1.equals("cup") && index2.equals("milliliter")) {outputNum = inputNum * 236.588;}
            if(index1.equals("pint") && index2.equals("milliliter")) {outputNum = inputNum * 473.176;}
            if(index1.equals("quart") && index2.equals("milliliter")) {outputNum = inputNum * 946.353;}
            if(index1.equals("gallon") && index2.equals("milliliter")) {outputNum = inputNum * 3785.41;}
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////
                //liter
                //deciliter

            //LENGTH
                //millimeter
                //centimeter
                //meter
                //inch
                //foot
                //yard
                //mile
                //kilometer

           output.setText(Double.toString(outputNum));
        }
        else
        {
            Toast toast = Toast.makeText(getApplicationContext(), "Try Again... please", Toast.LENGTH_SHORT);
        }



    }

///////////////////////////////////////////////////////////////////////////////////////////////////
    //This is the first conversion button box:
///////////////////////////////////////////////////////////////////////////////////////////////////
    public void firstConversion(View view)
    {
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        //THE FIRST DIALOG BOX AND ITS ATTRIBUTES

        itemSelect1 = (Button) findViewById(R.id.itemSelect1);

        //create the Alert Dialog 1
        a = new AlertDialog.Builder(this)
                .setTitle("Measurements")
                .setMessage("Pick a measurement to convert from");
        a.setCancelable(false);

        //Create the button
        final Button ounces1 = new Button(ConversionCalculatorMass.this);
        final Button grams1 = new Button(ConversionCalculatorMass.this);
        final Button pounds1 = new Button(ConversionCalculatorMass.this);
        final Button milligrams1 = new Button(ConversionCalculatorMass.this);
        final Button kilograms1 = new Button (ConversionCalculatorMass.this);

        //set the name to the buttons
        ounces1.setText("ounces");
        grams1.setText("grams");
        pounds1.setText("pounds");
        milligrams1.setText("milligrams");
        kilograms1.setText("kilograms");

        //all the on click listeners...
        ounces1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ad.dismiss();
                index1 = "ounces";
                itemSelect1.setText("ounces");
            }
        });

        grams1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ad.dismiss();
                index1 = "grams";
                itemSelect1.setText("grams");

            }
        });

        pounds1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ad.dismiss();
                index1 = "pounds";
                itemSelect1.setText("pounds");

            }
        });

        milligrams1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ad.dismiss();
                index1 = "milligrams";
                itemSelect1.setText("milligrams");
            }
        });

        kilograms1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ad.dismiss();
                index1 = "kilograms";
                itemSelect1.setText("kilograms");
            }
        });


        //NOW ADD THE STUFF CREATED ABOVE TO THE VIEW WITH A NEW LAYOUT

        layout1 = new LinearLayout(ConversionCalculatorMass.this);
        layout1.setOrientation(LinearLayout.VERTICAL);
        //Add the buttons to the layout
        layout1.addView(ounces1);
        layout1.addView(grams1);
        layout1.addView(pounds1);
        layout1.addView(milligrams1);
        layout1.addView(kilograms1);
        //now set the view and create it
        a.setView(layout1);
        ad = a.create();
        ad = a.show();
    }

///////////////////////////////////////////////////////////////////////////////////////////////////
    //This is the first conversion button box:
///////////////////////////////////////////////////////////////////////////////////////////////////
    public void secondConversion(View view)
    {
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        //THE SECOND DIALOG BOX AND ITS ATTRIBUTES

        itemSelect2 = (Button) findViewById(R.id.itemSelect2);

        b = new AlertDialog.Builder(this)
                .setTitle("Measurements")
                .setMessage("Pick a measurement to convert from");
        b.setCancelable(false);

        //Create the button
        final Button ounces2 = new Button(ConversionCalculatorMass.this);
        final Button grams2 = new Button(ConversionCalculatorMass.this);
        final Button pounds2 = new Button(ConversionCalculatorMass.this);
        final Button milligrams2 = new Button(ConversionCalculatorMass.this);
        final Button kilograms2 = new Button(ConversionCalculatorMass.this);

        //set the name to the buttons
        ounces2.setText("ounces");
        grams2.setText("grams");
        pounds2.setText("pounds");
        milligrams2.setText("milligrams");
        kilograms2.setText("kilograms");

        //all the on click listeners...
        ounces2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                bd.dismiss();
                index2 = "ounces";
                itemSelect2.setText("ounces");
            }
        });

        grams2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                bd.dismiss();
                index2 = "grams";
                itemSelect2.setText("grams");
            }
        });

        pounds2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                bd.dismiss();
                index2 = "pounds";
                itemSelect2.setText("pounds");
            }
        });

        milligrams2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                bd.dismiss();
                index2 = "milligrams";
                itemSelect2.setText("milligrams");
            }
        });

        kilograms2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                bd.dismiss();
                index2 = "kilograms";
                itemSelect2.setText("kilograms");
            }
        });

        layout2 = new LinearLayout(ConversionCalculatorMass.this);
        layout2.setOrientation(LinearLayout.VERTICAL);
        //Add the buttons to the layout
        layout2.addView(ounces2);
        layout2.addView(grams2);
        layout2.addView(pounds2);
        layout2.addView(milligrams2);
        layout2.addView(kilograms2);
        //now set the view and create it
        b.setView(layout2);
        bd = b.create();
        bd = b.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_conversion_calculator, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.volume)
        {
            Intent i = new Intent(this, ConversionCalculatorVolume.class);
            startActivity(i);
            return true;
        }
        else if(id == R.id.length)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

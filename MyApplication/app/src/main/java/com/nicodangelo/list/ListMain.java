// @Author Jett Kaspar
package com.nicodangelo.list;

import com.nicodangelo.Util.Settings;
import com.nicodangelo.item.ItemController;
import com.nicodangelo.pantrie.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.InputType;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.zip.Inflater;

//import static com.nicodangelo.pantrie.R.id.editList;
import static com.nicodangelo.pantrie.R.layout.activity_list_main;

public class ListMain extends ActionBarActivity
{
    ArrayList<String> list = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ItemController itemList = new ItemController();
    int curSize = 0;
    ListView lv;
    Boolean paused = false;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(activity_list_main);

        File temp = getCacheDir();
        String state = "";
        try
        {
            FileInputStream fs = new FileInputStream(temp);
            int c;
            while((c = fs.read()) != -1)
                state = state + ((char)c);
            fs.close();
            if(state.equals("true"))
            {
                System.out.print(state);
                for(int k = 0; k < itemList.getSpot(); k++)
                {
                    list.add(itemList.getName(k));
                    System.out.print(itemList.getName(k));
                }
                curSize = itemList.getSpot();
                FileOutputStream fo = new FileOutputStream(temp);
                fo.write(("false").getBytes());
                fo.close();
                itemList.printAll();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        Button btn = (Button) findViewById(R.id.btnAdd);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

        View.OnClickListener listener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EditText edit = (EditText) findViewById(R.id.txtItem);
                itemList.addItem(edit.getText().toString());
                list.add(itemList.getName(curSize));
                edit.setText("");
                curSize++;
                adapter.notifyDataSetChanged();
            }
        };

        btn.setOnClickListener(listener);
        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                for(int k = 0; k < curSize; k++)
                {
                    if(k == position)
                    {
                        final int a = k;
                        AlertDialog.Builder ab = new AlertDialog.Builder(ListMain.this)
                                .setTitle("Edit Pantrie?")
                                .setPositiveButton("Edit Item", new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which)
                                    {
                                        AlertDialog.Builder builder = new AlertDialog.Builder(ListMain.this);
                                        builder.setTitle(itemList.getName(position));

                                        final EditText one = new EditText(ListMain.this);
                                        one.setHint("Set Amount");
                                        final EditText two = new EditText(ListMain.this);
                                        two.setHint("Set Low Amount");

                                        one.setInputType(InputType.TYPE_CLASS_NUMBER);
                                        two.setInputType(InputType.TYPE_CLASS_NUMBER);

                                        LinearLayout lay = new LinearLayout(ListMain.this);
                                        lay.setOrientation(LinearLayout.VERTICAL);
                                        lay.addView(one);
                                        lay.addView(two);
                                        builder.setView(lay);
                                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener()
                                        {
                                            public void onClick(DialogInterface dialog, int whichButton)
                                            {
                                                if(!TextUtils.isEmpty(one.getText().toString()))
                                                {
                                                    itemList.setAmount(a, Integer.parseInt(one.getText().toString()));
                                                    list.set(a,itemList.getInfo(a));
                                                }
                                                if(!TextUtils.isEmpty(two.getText().toString()))
                                                    itemList.setAmount(a,Integer.parseInt(two.getText().toString()));
                                                adapter.notifyDataSetChanged();

                                            }
                                        });
                                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int whichButton) {
                                                dialog.cancel();
                                            }
                                        });
                                        builder.create();
                                        builder.show();
                                    }
                                })
                                .setNeutralButton("New Item", new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which)
                                    {
                                        AlertDialog.Builder builder = new AlertDialog.Builder(ListMain.this);
                                        builder.setTitle("Create New Item");
                                        final EditText name = new EditText(ListMain.this);
                                        name.setHint("Name of item (required)");
                                        final EditText amount = new EditText(ListMain.this);
                                        amount.setHint("Amount of items(Not Required)");
                                        final EditText setLow = new EditText(ListMain.this);
                                        setLow.setHint("Set Low Amount(Not Required)");


                                        name.setInputType(InputType.TYPE_CLASS_TEXT);
                                        amount.setInputType(InputType.TYPE_CLASS_NUMBER);
                                        setLow.setInputType(InputType.TYPE_CLASS_NUMBER);

                                        LinearLayout lay = new LinearLayout(ListMain.this);
                                        lay.setOrientation(LinearLayout.VERTICAL);
                                        lay.addView(name);
                                        lay.addView(amount);
                                        lay.addView(setLow);
                                        builder.setView(lay);
                                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int whichButton) {
                                                itemList.addItem(name.getText().toString());
                                                if (!TextUtils.isEmpty(amount.getText().toString()))
                                                    itemList.setAmount(a + 1, Integer.parseInt(setLow.getText().toString()));
                                                if (!TextUtils.isEmpty(setLow.getText().toString()))
                                                    itemList.setAmount(a + 1, Integer.parseInt(setLow.getText().toString()));
                                                list.add(itemList.getName(a + 1));
                                                curSize++;
                                                adapter.notifyDataSetChanged();


                                            }
                                        });
                                        builder.create();
                                        builder.show();
                                    }
                                })
                                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() { @Override public void onClick(DialogInterface dialog, int which){ adapter.notifyDataSetChanged();}});
                        ab.create();
                        ab.show();
                    }

                }
            }
        });
    }

    @Override
    protected void onPause()
    {
        itemList.printAll();
        paused = true;
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_add_item, menu);
        getMenuInflater().inflate(R.menu.menu_settings, menu);
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
        if(id == R.id.action_settings)
        {
            Intent i = new Intent(this, Settings.class);
            startActivity(i);
            return true;
        }
        else if(id == R.id.action_add_item)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(ListMain.this);
            builder.setTitle("Create New Item");
            final EditText name = new EditText(ListMain.this);
            name.setHint("Name of item (required)");
            final EditText amount = new EditText(ListMain.this);
            amount.setHint("Amount of items(Not Required)");
            final EditText setLow = new EditText(ListMain.this);
            setLow.setHint("Set Low Amount(Not Required)");


            name.setInputType(InputType.TYPE_CLASS_TEXT);
            amount.setInputType(InputType.TYPE_CLASS_NUMBER);
            setLow.setInputType(InputType.TYPE_CLASS_NUMBER);

            LinearLayout lay = new LinearLayout(ListMain.this);
            lay.setOrientation(LinearLayout.VERTICAL);
            lay.addView(name);
            lay.addView(amount);
            lay.addView(setLow);
            builder.setView(lay);
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int whichButton)
                {
                    itemList.addItem(name.getText().toString());
                    if (!TextUtils.isEmpty(amount.getText().toString()))
                        itemList.setAmount(curSize, Integer.parseInt(amount.getText().toString()));
                    if (!TextUtils.isEmpty(setLow.getText().toString()))
                        itemList.setLowAmount(curSize, Integer.parseInt(setLow.getText().toString()));
                    list.add(itemList.getInfo(curSize));
                    curSize++;
                    adapter.notifyDataSetChanged();

                }
            });
            builder.create();
            builder.show();
        }

        return super.onOptionsItemSelected(item);
    }
}

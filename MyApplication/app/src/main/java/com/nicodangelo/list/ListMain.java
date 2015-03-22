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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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

public class ListMain extends Activity
{
    ArrayList<String> list = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ItemController itemList = new ItemController();
    int curSize = 0;
    ListView lv;

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
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for(int k = 0; k < curSize; k++)
                {
                    if(k == position)
                    {
                        AlertDialog.Builder ab = new AlertDialog.Builder(ListMain.this)
                                .setTitle("Options")
                                .setMessage("What do you want to do with this item? ")
                                .setPositiveButton("Edit Item", new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which)
                                    {
                                        Intent editList = new Intent(ListMain.this, EditList.class);
                                        startActivity(editList);
                                    }
                                })
                                .setNeutralButton("New Item", new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which)
                                    {

                                    }
                                })
                                .setNegativeButton("Cancel", new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {} });
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
        
    }
}

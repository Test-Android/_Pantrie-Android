// @Author Jett Kaspar
package com.nicodangelo.list;
import com.nicodangelo.item.Item;
import com.nicodangelo.item.ItemController;
import com.nicodangelo.pantrie.R;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.Override;
import java.lang.String;import java.util.ArrayList;

public class ListMain extends ListActivity
{

    ArrayList<String> list = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ItemController itemList = new ItemController();
    int curSize = 0;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_main);

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
                for(int k = 0; k < itemList.getSpot(); k++)
                {
                    list.add(itemList.getName(k));
                    System.out.print(itemList.getName(k));
                }
                curSize = itemList.getSpot();
                FileOutputStream fo = new FileOutputStream(temp);
                fo.write(("false").getBytes());
                fo.close();

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
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        for(int k = 0; k < curSize; k++)
        {
            if(k == position)
            {
                AlertDialog.Builder ab = new AlertDialog.Builder(this)
                        .setTitle("Options")
                        .setMessage("What do you want to do with this item? ")
                        .setPositiveButton("Edit Item", new DialogInterface.OnClickListener() {
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
                            public void onClick(DialogInterface dialog, int which)
                            {

                            }
                        });
                ab.create();
                ab.show();
            }
        }
        super.onListItemClick(l, v, position, id);
    }
}

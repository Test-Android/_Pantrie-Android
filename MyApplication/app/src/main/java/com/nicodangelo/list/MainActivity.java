// @Author Jett Kaspar
package com.nicodangelo.list;
import com.nicodangelo.item.Item;
import com.nicodangelo.pantrie.R;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.lang.Override;import java.lang.String;import java.util.ArrayList;

public class MainActivity extends ListActivity
{

    ArrayList<String> list = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ArrayList<Item> itemList;
    int curSize = 1;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btnAdd);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        itemList = new ArrayList<Item>();
        Item item = new Item("Nuts");
        itemList.add(item);
        list.add(itemList.get(0).toString());

        View.OnClickListener listener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EditText edit = (EditText) findViewById(R.id.txtItem);
                Item im = new Item(edit.getText().toString());
                itemList.add(im);
                list.add(itemList.get(curSize).toString());
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

                            }
                        })
                        .setNeutralButton("New Item", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                ab.create();
                ab.show();
            }
        }
        super.onListItemClick(l, v, position, id);
    }
}

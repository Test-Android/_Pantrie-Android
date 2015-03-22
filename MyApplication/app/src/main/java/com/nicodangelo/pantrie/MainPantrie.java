//@author Jake Cox

package com.nicodangelo.pantrie;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.nicodangelo.list.ListMain;
import com.nicodangelo.pantrie.R;
import com.parse.Parse;


public class MainPantrie extends ActionBarActivity
{
    private static EditText usernameText;
    private static EditText passwordText;

    private static String username;
    private static String password;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        ///////////////////////////////////////////////////////////////////////////////////////////
        // Enable Local Datastore, and make a Test Parse Object!
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "pBnaKMYAdbbfRhdvcKQEWFLiKtmsXXzOZXAAGoLh", "tJpug7m4dtF6FhpaMoM9PWAxlTRAbSoAKLcdWx5J");
        ///////////////////////////////////////////////////////////////////////////////////////////

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pantrie);
    }

    public void launchNewLogIn()
    {

    }

    public void logIn()
    {

    }

    public void goToJett()
    {
        Intent i = new Intent(this,ListMain.class);
        startActivity(i);
    }
}

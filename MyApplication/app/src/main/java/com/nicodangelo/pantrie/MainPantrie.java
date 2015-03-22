//@author Jake Cox

package com.nicodangelo.pantrie;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.nicodangelo.list.ListMain;
import com.nicodangelo.pantrie.R;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseUser;


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

    public void logIn(View view)
    {
        usernameText = (EditText) view.findViewById(R.id.usernameText);
        passwordText = (EditText) view.findViewById(R.id.passwordText);

        username = usernameText.getText().toString();
        password = passwordText.getText().toString();

        ParseUser.logInInBackground(username, password, new LogInCallback()
        {
            public void done(ParseUser user, com.parse.ParseException e)
            {
                if (user != null)
                {
                    // Hooray! The user is logged in.
                    System.out.println("YOU ARE LOGGED IN");
                } else
                {
                    // Signup failed. Look at the ParseException to see what happened.
                    System.out.println("SignIn Failed!");
                }
            }
        });
    }

    public void launchNewLogIn(View view)
    {
        Intent i = new Intent(this,NewLogIn.class);
        startActivity(i);
    }

    public void goToJett(View view)
    {
        Intent i = new Intent(this,ListMain.class);
        startActivity(i);
    }
}

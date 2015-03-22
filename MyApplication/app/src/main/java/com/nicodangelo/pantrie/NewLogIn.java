//@author Jake Cox

package com.nicodangelo.pantrie;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.parse.Parse;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class NewLogIn extends ActionBarActivity
{
    private static EditText newUsernameText;
    private static EditText newEmailText;
    private static EditText newPasswordText;
    private static EditText newConfirmPasswordText;

    private static String newUsername;
    private static String newEmail;
    private static String newPassword;
    private static String newConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        ///////////////////////////////////////////////////////////////////////////////////////////
        // Enable Local Datastore, and make a Test Parse Object!
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "pBnaKMYAdbbfRhdvcKQEWFLiKtmsXXzOZXAAGoLh", "tJpug7m4dtF6FhpaMoM9PWAxlTRAbSoAKLcdWx5J");
        ///////////////////////////////////////////////////////////////////////////////////////////

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_log_in);
    }

    public void createNewAccount(View view)
    {
        newUsernameText = (EditText) findViewById(R.id.newUsernameText);
        newEmailText = (EditText) findViewById(R.id.newEmailText);
        newPasswordText = (EditText) findViewById(R.id.newPasswordText);
        newPasswordText = (EditText) findViewById(R.id.newPasswordText);

        newUsername = newUsernameText.getText().toString();
        newEmail = newEmailText.getText().toString();
        newPassword = newPasswordText.getText().toString();
        newConfirmPassword = newConfirmPasswordText.getText().toString();

        if(newPassword.equalsIgnoreCase(newConfirmPassword))
        {
            ParseUser user = new ParseUser();
            if(!newUsername.isEmpty())
            {
                user.setUsername(newUsername);
                user.setEmail(newEmail);
                user.setPassword(newPassword);
            }

            // other fields can be set just like with ParseObject

            user.signUpInBackground(new SignUpCallback()
            {
                @Override
                public void done(com.parse.ParseException e)
                {
                    if (e == null)
                    {
                        // Hooray! Let them use the app now.
                        newUserCreated();

                    } else
                    {
                        // Sign up didn't succeed. Look at the ParseException
                        System.out.println("the sign in failed!!");
                        // to figure out what went wrong
                    }
                }
            });
        }
        else
        {
            System.out.println("password don't match");
        }

    }

    public void newUserCreated()
    {

    }
}

package me.andrewbruce.assessment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.LoginFilter;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    // private global variables
    private EditText txtUsername;
    private EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // sets title
        setTitle("Log In");

        // assigns on screen text boxes to variables
        txtUsername = (EditText)findViewById(R.id.txtUsername);
        txtPassword = (EditText)findViewById(R.id.txtPassword);

    }

    // fires when login button is tapped
    public void btnLogIn_Click(View v) {

        // takes the username and password from Edit Texts and assigns them to strings
        String username = txtUsername.getText().toString();
        String password = txtPassword.getText().toString();

        // new instance of DBManager
        DBManager DbManager = new DBManager(this);

        // checks if the username of password Edit Texts are empty
        if (username.isEmpty() || password.isEmpty()) {
            new Alert().display(this, "Empty fields", "Must enter username and password");
        }
        // checks if the username and password match any in the database
        else if(DbManager.checkLogin(username, password)) {
            Intent i = new Intent(this, MenuActivity.class);

            // passes the firstname and username to the next activity
            i.putExtra("firstName", DbManager.getFirstName(username));
            i.putExtra("username", username);

            // finishes this activity
            finish();

            // starts the next activity
            startActivity(i);
        } else {
            // displays if the username and password don't match any
            new Alert().display(this, "Invalid Login", "Username or password incorrect");
        }
    }

    // fires when the register button is tapped, takes to the registration activity
    public void lblRegister_Click(View v) {
        finish();
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
    }

    public void lblReset_Click(View v) {
        Intent i = new Intent(this, ResetPasswordActivity.class);
        startActivity(i);
    }
}

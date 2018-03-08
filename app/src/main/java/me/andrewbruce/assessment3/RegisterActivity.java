package me.andrewbruce.assessment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    // private global variables
    private EditText txtFirstName;
    private EditText txtLastName;
    private EditText txtUsername;
    private EditText txtPassword;
    private EditText txtRetypePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // set title
        setTitle("Register");

        // assigns on screen Edit Texts to variables
        txtFirstName=(EditText)findViewById(R.id.txtFirstName);
        txtLastName=(EditText)findViewById(R.id.txtLastName);
        txtUsername=(EditText)findViewById(R.id.txtUsername);
        txtPassword=(EditText)findViewById(R.id.txtPassword);
        txtRetypePassword=(EditText)findViewById(R.id.txtRetypePassword);
    }

    // fires when login button is pressed, takes user to login screen
    public void lblLogin_Click(View v) {
        finish();
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }

    // fires when register button is clicked
    public void btnRegister_Click(View v) {

        // takes text from Edit Texts and assigns to string variables
        String firstName = txtFirstName.getText().toString();
        String lastName = txtLastName.getText().toString();
        String username = txtUsername.getText().toString();
        String password = txtPassword.getText().toString();
        String retypePassword = txtRetypePassword.getText().toString();

        // new instance of DBManager
        DBManager DbManager = new DBManager(this);

        // new instance of Alert
        Alert alert = new Alert();

        // checks if any fields are empty and displays an error if they are
        if(firstName.isEmpty() || lastName.isEmpty() || username.isEmpty()
                || password.isEmpty() || retypePassword.isEmpty()) {
            alert.display(this, "Empty fields", "Please fill in all fields");
        }
        // checks both passwords fields are the same
        else if (!password.equals(retypePassword)) {
            alert.display(this, "Passwords Don't match", "Passwords do not match, please try again");
        }
        // checks the password is at least 8 characters long
        else if (password.length() < 8) {
            alert.display(this, "Too short", "Password must be 8 characters or more");
        }
        // checks if the username has already been taken
        else if (DbManager.usernameTaken(username)) {
            alert.display(this, "Duplicate username", "Sorry, that username is already in use");
            txtUsername.setText("");
        }
        else {
            // uses User constructor to create an instance of our user
            User user = new User(firstName, lastName, username, password);
            try {
                // tries to add user to the database
                DbManager.addUser(user);

                // closes this activity and starts the login activity, displays success toast
                Intent i = new Intent(this, LoginActivity.class);
                finish();
                startActivity(i);
                Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show();
            } catch(Exception ex) {
                // displays the exception as an error alert
                alert.display(this, "Registration failed", "Error: " + ex);
            }
        }
    }
}

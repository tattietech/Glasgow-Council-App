package me.andrewbruce.assessment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ResetPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        // set title
        setTitle("Reset Password");

        // adds the back arrow to the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    // method fires when the back arrow is pressed, finishes current activity
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void btnChange_Click(View v) {
        // assigns on screen Edit Texts to variables
        EditText txtUsername = (EditText)findViewById(R.id.txtUsername);
        EditText txtCurrentPassword = (EditText)findViewById(R.id.txtCurrentPassword);
        EditText txtNewPassword = (EditText)findViewById(R.id.txtNewPassword);
        EditText txtRetypePassword = (EditText)findViewById(R.id.txtRetypePassword);

        // converts them all to strings
        String username = txtUsername.getText().toString();
        String currentPassword = txtCurrentPassword.getText().toString();
        String newPassword = txtNewPassword.getText().toString();
        String retypePassword = txtRetypePassword.getText().toString();

        // new instance of DBManager
        DBManager db = new DBManager(this);

        // new instance of Alert
        Alert alert = new Alert();

        // checks that none of the fields are empty
        if(username.isEmpty() || currentPassword.isEmpty() || newPassword.isEmpty() || retypePassword.isEmpty()) {
            alert.display(this, "Empty fields", "Please enter all fields");
            return;
        }
        // checks that the user has entered the new password twice the same
        else if (!newPassword.equals(retypePassword)) {
            alert.display(this, "Passwords do not match", "The new passwords you provided do not match");
            return;
        }
        // checks the password is at least 8 characters long
        else if (newPassword.length() < 8) {
            alert.display(this, "Not long enough", "Your new password must be at least 8 characters");
        }
        // checks that the current username and password are correct
        else if(db.checkLogin(username, currentPassword)) {
            try {
                // updates the password for this user in the db
                db.updatePassword(username, newPassword);
                Toast.makeText(this, "Password Reset Successfully", Toast.LENGTH_SHORT).show();
                finish();
            } catch (Exception ex) {
                alert.display(this, "Error", ex.toString());
            }
        } else {
            alert.display(this, "Invalid credentials", "The current username or password you entered is incorrect");
        }
    }
}

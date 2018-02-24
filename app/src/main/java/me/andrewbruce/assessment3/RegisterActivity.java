package me.andrewbruce.assessment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private EditText txtFirstName;
    private EditText txtLastName;
    private EditText txtEmail;
    private EditText txtPassword;
    private EditText txtRetypePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("Register");

        txtFirstName=(EditText)findViewById(R.id.txtFirstName);
        txtLastName=(EditText)findViewById(R.id.txtLastName);
        txtEmail=(EditText)findViewById(R.id.txtEmail);
        txtPassword=(EditText)findViewById(R.id.txtPassword);
        txtRetypePassword=(EditText)findViewById(R.id.txtRetypePassword);
    }

    public void lblLogin_Click(View v) {
        finish();
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }

    public void btnRegister_Click(View v) {
        String firstName = txtFirstName.getText().toString();
        String lastName = txtLastName.getText().toString();
        String email = txtEmail.getText().toString();
        String password = txtPassword.getText().toString();
        String retypePassword = txtRetypePassword.getText().toString();
        DBManager DbManager = new DBManager(this);
        Alert alert = new Alert();

        if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()
                || password.isEmpty() || retypePassword.isEmpty()) {
            alert.display(this, "Empty fields", "Please fill in all fields");
        } else if (!password.equals(retypePassword)) {
            alert.display(this, "Passwords Don't match", "Passwords do not match, please try again");
        } else if (password.length() < 8) {
            alert.display(this, "Too short", "Password must be 8 characters or more");
        } else if (DbManager.emailTaken(email)) {
            alert.display(this, "Duplicate email", "Sorry, that email is already in use");
            txtEmail.setText("");
        }
        else {
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPassword(password);
            try {
                DbManager.addUser(user);
                Intent i = new Intent(this, LoginActivity.class);
                finish();
                startActivity(i);
                Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show();
            } catch(Exception ex) {
                alert.display(this, "Registration failed", "Error: " + ex);
            }
        }
    }
}

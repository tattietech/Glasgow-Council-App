package me.andrewbruce.assessment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText txtEmail;
    private EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Log In");

        txtEmail = (EditText)findViewById(R.id.txtEmail);
        txtPassword = (EditText)findViewById(R.id.txtPassword);

    }

    public void btnLogIn_Click(View v) {
        String email = txtEmail.getText().toString();
        String password = txtPassword.getText().toString();
        DBManager DbManager = new DBManager(this);

        if (email.isEmpty() || password.isEmpty()) {
            new Alert().display(this, "Empty fields", "Must enter username and password");
        } else if(DbManager.checkLogin(email, password)) {
            Intent i = new Intent(this, MenuActivity.class);
            i.putExtra("name", DbManager.getName(email));
            finish();
            startActivity(i);
        } else {
            new Alert().display(this, "Invalid Login", "Username or password incorrect");
        }
    }

    public void lblRegister_Click(View v) {
        finish();
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
    }
}

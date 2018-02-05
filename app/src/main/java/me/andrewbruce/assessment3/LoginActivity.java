package me.andrewbruce.assessment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Log In");

    }

    public void btnLogIn_Click(View v) {
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
    }

    public void lblRegister_Click(View v) {
        finish();
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
    }
}

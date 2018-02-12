package me.andrewbruce.assessment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AttractionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attractions);
        setTitle("Places to visit");
    }

    public void attraction1_Click(View v) {
        Intent i = new Intent(this, Attraction1.class);
        startActivity(i);
    }

    public void attraction2_Click(View v) {
        Intent i = new Intent(this, Attraction2.class);
        startActivity(i);
    }

    public void attraction3_Click(View v) {
        Intent i = new Intent(this, Attraction3.class);
        startActivity(i);
    }

    public void attraction4_Click(View v) {
        Intent i = new Intent(this, Attraction4.class);
        startActivity(i);
    }

    public void attraction5_Click(View v) {
        Intent i = new Intent(this, Attraction5.class);
        startActivity(i);
    }

    public void attraction6_Click(View v) {
        Intent i = new Intent(this, Attraction6.class);
        startActivity(i);
    }
}

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
}

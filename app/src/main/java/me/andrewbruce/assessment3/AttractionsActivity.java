package me.andrewbruce.assessment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class AttractionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attractions);
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        setTitle(name + "'s Places to visit");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void attraction1_Click(View v) {
        Intent i = new Intent(this, Attraction1Activity.class);
        startActivity(i);
    }

    public void attraction2_Click(View v) {
        Intent i = new Intent(this, Attraction2Activity.class);
        startActivity(i);
    }

    public void attraction3_Click(View v) {
        Intent i = new Intent(this, Attraction3Activity.class);
        startActivity(i);
    }

    public void attraction4_Click(View v) {
        Intent i = new Intent(this, Attraction4Activity.class);
        startActivity(i);
    }

    public void attraction5_Click(View v) {
        Intent i = new Intent(this, Attraction5Activity.class);
        startActivity(i);
    }

    public void attraction6_Click(View v) {
        Intent i = new Intent(this, Attraction6Activity.class);
        startActivity(i);
    }
}

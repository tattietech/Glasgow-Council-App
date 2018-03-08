package me.andrewbruce.assessment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class AttractionsActivity extends AppCompatActivity {
    //global variables to take users first name and username
    private String firstName;
    private String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attractions);

        // gets firstname and username from intent
        Intent i = getIntent();
        firstName = i.getStringExtra("firstName");
        username = i.getStringExtra("username");

        // personalised greeting from intent
        setTitle(firstName + "'s Places to visit");

        // places back arrow in toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    // fires when back button is tapped, finishes current activity
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    // below 6 methods are links to specific attraction pages
    // passing in the username to each one so when the user comments it knows who's doing it
    public void attraction1_Click(View v) {
        Intent i = new Intent(this, Attraction1Activity.class);
        i.putExtra("username", username);
        startActivity(i);
    }

    public void attraction2_Click(View v) {
        Intent i = new Intent(this, Attraction2Activity.class);
        i.putExtra("username", username);
        startActivity(i);
    }

    public void attraction3_Click(View v) {
        Intent i = new Intent(this, Attraction3Activity.class);
        i.putExtra("username", username);
        startActivity(i);
    }

    public void attraction4_Click(View v) {
        Intent i = new Intent(this, Attraction4Activity.class);
        i.putExtra("username", username);
        startActivity(i);
    }

    public void attraction5_Click(View v) {
        Intent i = new Intent(this, Attraction5Activity.class);
        i.putExtra("username", username);
        startActivity(i);
    }

    public void attraction6_Click(View v) {
        Intent i = new Intent(this, Attraction6Activity.class);
        i.putExtra("username", username);
        startActivity(i);
    }
}

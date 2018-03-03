package me.andrewbruce.assessment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    private String firstName;
    private String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent i = getIntent();
        firstName = i.getStringExtra("firstName");
        username = i.getStringExtra("username");

        setTitle(firstName + "'s Main Menu");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        TextView lblWelcome = (TextView)findViewById(R.id.lblWelcome);
        lblWelcome.setText("Hello " + firstName + ".\nWelcome to The City Of Glasgow Council App");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            Intent i = new Intent(this, LoginActivity.class);
            finish();
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    public void attractions_Click(View v) {
        Intent i = new Intent(this, AttractionsActivity.class);
        i.putExtra("firstName", firstName);
        i.putExtra("username", username);
        startActivity(i);
    }

    public void events_Click(View v) {
        Intent i = new Intent(this, EventsActivity.class);
        i.putExtra("firstName", firstName);
        startActivity(i);
    }

    public void travel_Click(View v) {
        Intent i = new Intent(this, TravelActivity.class);
        i.putExtra("firstName", firstName);
        startActivity(i);
    }
}

package me.andrewbruce.assessment3;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class Event3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event3);

        // sets title
        setTitle("TRNSMT");

        // displays back arrow in tool bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    // fires when back arrow is pressed, finished current activity
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    // opens google map location of event venue
    public void ViewOnMap3_Click(View v) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://bit.ly/2F78GPj"));
        startActivity(i);
    }

    // opens ticket website for event
    public void GetTickets3_Click(View v) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://trnsmtfest.com/tickets"));
        startActivity(i);
    }
}

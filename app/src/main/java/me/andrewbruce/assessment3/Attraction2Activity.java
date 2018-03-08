package me.andrewbruce.assessment3;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Attraction2Activity extends AppCompatActivity {
    // global variable for our username
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction2);
        setTitle("Riverside Museum");

        // gets the username from the last intent and assigns it to gloval variable
        Intent i = getIntent();
        username = i.getStringExtra("username");

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

    // fires when the add comment button is clicked
    public void btnAdd_Click(View v) {

        // finds the comment box and selection spinner
        EditText txtComment=(EditText)findViewById(R.id.txtComment);
        Spinner spnRating=(Spinner)findViewById(R.id.spnRating);

        // creates instances of variables to be used several times
        // alert is a class with our error message method in it
        Alert alert = new Alert();
        int rating;

        // convert comment body to string
        String commentBody = txtComment.getText().toString();

        // checks if the comment body is empty and returns an error if it is
        if(commentBody.isEmpty()) {
            alert.display(this, "Must add comment", "Please include text in comment body");
            return;
        }

        // tries to convert the rating to an int, if it fails it's because the user
        // hasn't select one and it will error accordingly
        try {
            rating = Integer.parseInt(spnRating.getSelectedItem().toString());
        } catch (Exception ex) {
            alert.display(this, "Select rating", "Please select a rating before posting comment");
            return;
        }

        // gets the current date and time
        Date date = new Date();

        // converts it to a formatted string for display
        String modifiedDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(date);

        // creates a new comment object, taking in the attractionId as a hardcoded first parameter
        Comment comment = new Comment(2, username, commentBody, rating, modifiedDate);

        // tries to add the comment to the database and reset the onscreen elements
        // if successful it displays a toast, if not if gives the exception in an error box
        try {
            DBManager db = new DBManager(this);
            db.addComment(comment);
            txtComment.setText("");
            spnRating.setSelection(0);
            Toast.makeText(this, "Post successful", Toast.LENGTH_SHORT).show();
        } catch(Exception ex) {
            new Alert().display(this, "Error", ex.toString());
            return;
        }
    }

    // fires when the Comments button is tapped
    // passes the attractionId and the title, so it can display correct info
    // on the comments page
    public void btnComments_Click(View v) {
        Intent i = new Intent(this, CommentsActivity.class);
        i.putExtra("attractionId", 2);
        i.putExtra("title", "Riverside Museum");
        startActivity(i);
    }

    // fires when map button is pressed
    // opens Google maps location of Attraction
    public void btnMap_Click(View v) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://bit.ly/2EAZe8Y"));
        startActivity(i);
    }

    // fires when website button is pressed
    // opens website of attraction
    public void btnWebsite_Click(View v) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://bit.ly/2H9sNgf"));
        startActivity(i);
    }
}

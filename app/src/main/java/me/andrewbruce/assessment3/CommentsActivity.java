package me.andrewbruce.assessment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class CommentsActivity extends AppCompatActivity {
    // private global variable
    private int attractionId;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        // displays back arrow in the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // gets the ID and title of the attraction from the intent
        Intent i = getIntent();
        attractionId = i.getIntExtra("attractionId", 0);
        title = i.getStringExtra("title");

        // sets title to "Attraction Name Comments"
        setTitle(title + " Comments");

        // calls the displayComments() function below
        displayComments();
    }

    // fires when the back arrow is pressed, finished the current activity
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }


    public void displayComments() {

        // creates instance of DBManager
        DBManager db = new DBManager(this);

        // gets an array list of comments from the database
        ArrayList<Comment> comments = db.getComments(attractionId);

        // if there's no comments then it displays this message to the user
        if(comments.size() == 0) {
            TextView lblNoComments = (TextView)findViewById(R.id.lblNoComments);
            lblNoComments.setText(
                    "No comments have been left for " + title + " :(\n" +
                    "Press back and be the first to leave a comment!");
        }

        // reverses the order, so it display newest first
        Collections.reverse(comments);

        // creates a new instance of the comment adapter I created
        CommentAdapter commentAdapter = new CommentAdapter(this, comments);

        // find the list view
        ListView lstComments = (ListView)findViewById(R.id.lstComments);

        // assigns the comment adapter to the list view
        lstComments.setAdapter(commentAdapter);
    }
}

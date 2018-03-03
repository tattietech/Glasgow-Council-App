package me.andrewbruce.assessment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class CommentsActivity extends AppCompatActivity {
    private int attractionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent i = getIntent();
        attractionId = i.getIntExtra("attractionId", 0);
        String title = i.getStringExtra("title");

        setTitle(title + " Comments");

        displayComments();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void displayComments() {
        DBManager db = new DBManager(this);
        ArrayList<Comment> comments = db.getComments(attractionId);
        Collections.reverse(comments);

        CommentAdapter commentAdapter = new CommentAdapter(this, comments);
        ListView lstComments = (ListView)findViewById(R.id.lstComments);

        lstComments.setAdapter(commentAdapter);
    }
}

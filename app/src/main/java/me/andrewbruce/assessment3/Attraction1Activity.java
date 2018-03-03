package me.andrewbruce.assessment3;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.TimeZone;

public class Attraction1Activity extends AppCompatActivity {
    private String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction1);
        setTitle("Kelvingrove Gallery");

        Intent i = getIntent();
        username = i.getStringExtra("username");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

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

    public void btnMap_Click(View v) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://bit.ly/2nR68xu"));
        startActivity(i);
    }

    public void btnWebsite_Click(View v){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://bit.ly/2ECJaUk"));
        startActivity(i);
    }

    public void btnAdd_Click(View v) {
        EditText txtComment=(EditText)findViewById(R.id.txtComment);
        Spinner spnRating=(Spinner)findViewById(R.id.spnRating);

        String commentBody = txtComment.getText().toString();
        int rating = Integer.parseInt(spnRating.getSelectedItem().toString());

        Date date = new Date();
        String modifiedDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(date);

        Comment comment = new Comment(1, username, commentBody, rating, modifiedDate);

        try {
            DBManager db = new DBManager(this);
            db.addComment(comment);
            txtComment.setText("");
            displayComments();
            Toast.makeText(this, "Post successful", Toast.LENGTH_SHORT).show();
        } catch(Exception ex) {
            new Alert().display(this, "Error", ex.toString());
            return;
        }
    }

    public void displayComments() {
        DBManager db = new DBManager(this);
        ArrayList<Comment> comments = db.getComments(1);
        Collections.reverse(comments);

        CommentAdapter commentAdapter = new CommentAdapter(this, comments);
        ListView lstComments = (ListView)findViewById(R.id.lstComments);

        lstComments.getLayoutParams().height = 250 * (comments.size());
        lstComments.requestLayout();
        lstComments.setAdapter(commentAdapter);
        lstComments.setScrollContainer(false);
    }
}

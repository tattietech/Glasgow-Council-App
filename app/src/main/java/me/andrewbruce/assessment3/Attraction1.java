package me.andrewbruce.assessment3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.TimeZone;

public class Attraction1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction1);
        ArrayList<Comment> al = new ArrayList<>();

        for(int i=0; i<10;i++) {
            Comment comment = new Comment("Username", "This is the comments main body " + i);
            al.add(comment);
        }

        CommentAdapter commentAdapter = new CommentAdapter(this, al);


        ListView lstComments = (ListView)findViewById(R.id.lstComments);
        lstComments.setAdapter(commentAdapter);
      //  lstComments.setScrollContainer(false);
    }
}

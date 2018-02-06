package me.andrewbruce.assessment3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class Attraction1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction1);

        ArrayList<Comment> al = new ArrayList<>();

        CommentAdapter commentAdapter = new CommentAdapter(this, al);
        ListView lstComments = (ListView)findViewById(R.id.lstComments);

        Date date = new Date();
        String modifiedDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(date);

        int i;
        for(i=0; i<4;i++) {
            Comment comment = new Comment("Username", "This is the comments main body " + i + " ", modifiedDate);
            al.add(comment);
        }

        lstComments.getLayoutParams().height = 200 * (i);
        lstComments.requestLayout();
        lstComments.setAdapter(commentAdapter);;
        lstComments.setScrollContainer(false);

    }
}

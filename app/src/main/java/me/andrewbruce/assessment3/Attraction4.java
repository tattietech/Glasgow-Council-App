package me.andrewbruce.assessment3;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Attraction4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction4);

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

    public void btnMap_Click(View v) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://bit.ly/2BroYTu"));
        startActivity(i);
    }

    public void btnWebsite_Click(View v){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.merchantsquareglasgow.com"));
        startActivity(i);
    }
}

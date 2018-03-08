package me.andrewbruce.assessment3;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

// created my own Array Adapter specifically for comments so they can be laid out better
public class CommentAdapter extends ArrayAdapter<Comment> {

    public CommentAdapter(Context context, ArrayList<Comment> listItems) {
        super(context, 0, listItems);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Get the data item for this position
        Comment comment = getItem(position);

        //Check if an existing view is being reused, otherwise inflate a new view from custom row layout
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.comment_layout, parent, false);
        }

        //Grab references of view so we can populate them with specific note row data
        TextView listItemUsername = (TextView)convertView.findViewById(R.id.listItemUsername);
        TextView listItemRating = (TextView)convertView.findViewById(R.id.listItemRating);
        TextView listItemComment = (TextView)convertView.findViewById(R.id.listItemComment);
        TextView listItemDate = (TextView)convertView.findViewById(R.id.listItemDate);
        TextView listItemTime = (TextView)convertView.findViewById(R.id.listItemTime);

        // seperates date and time so they can be displayed on seperate lines
        String[] dateTime = comment.getDate().split("\\s+");

        // sets the data of our comment_layout items to data contained in the
        // comment object declared at the top
        listItemUsername.setText(comment.getUsername());
        listItemRating.setText("Rating: " + Integer.toString(comment.getRating()) + "/5");
        listItemComment.setText(comment.getComment());
        listItemDate.setText(dateTime[0]);
        listItemTime.setText(dateTime[1]);

        return convertView;
    }


}
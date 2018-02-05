package me.andrewbruce.assessment3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

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
        TextView listItemComment = (TextView)convertView.findViewById(R.id.listItemComment);

        listItemUsername.setText(comment.getUsername());
        listItemComment.setText(comment.getComment());

        return convertView;
    }


}
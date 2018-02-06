package me.andrewbruce.assessment3;


import java.util.Date;

public class Comment {
    private String username;
    private String comment;
    private String date;

    public Comment(String username, String comment, String date) {
        this.username = username;
        this.comment = comment;
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public String getComment() {
        return comment;
    }

    public String getDate() {
        return date;
    }


}

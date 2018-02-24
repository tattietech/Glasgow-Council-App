package me.andrewbruce.assessment3;


import java.util.Date;

public class Comment {
    private String email;
    private String comment;
    private String date;
    private String attractionId;

    public Comment(String username, String comment, String date) {
        this.email = username;
        this.comment = comment;
        this.date = date;
    }

    public String getUsername() {
        return email;
    }

    public String getComment() {
        return comment;
    }

    public String getDate() {return date;}

    public String getAttractionId(){return attractionId;}


}

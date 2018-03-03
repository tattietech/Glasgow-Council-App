package me.andrewbruce.assessment3;


import java.util.Date;

public class Comment {
    private String username;
    private String comment;
    private String date;
    private int attractionId;
    private int rating;

    public Comment(int attractionId, String username, String comment, int rating, String date) {
        this.username = username;
        this.comment = comment;
        this.attractionId = attractionId;
        this.rating = rating;
        this.date = date;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAttractionId(int attractionId) {
        this.attractionId = attractionId;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getUsername() {
        return username;
    }

    public String getComment() {
        return comment;
    }

    public String getDate() {return date;}

    public int getAttractionId(){return attractionId;}

    public int getRating(){return rating;}


}

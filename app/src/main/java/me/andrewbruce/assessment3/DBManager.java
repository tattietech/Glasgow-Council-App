package me.andrewbruce.assessment3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBManager extends SQLiteOpenHelper {
    //Final private variables to hold the names of the tables
    public static final String TABLE_USERS = "users";
    public static final String TABLE_COMMENTS = "comments";

    //Final private variables to hold the columns for the user table
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FIRST_NAME = "first_name";
    public static final String COLUMN_LAST_NAME = "last_name";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";

    //Final private variables to hold the columns for the comments table
    public static final String COLUMN_ATTRACTION_ID = "attractionId";
    public static final String COLUMN_ATTRACTION_COMMENT = "attractionComment";
    public static final String COLUMN_ATTRACTION_RATING = "attractionRating";
    public static final String COLUMN_DATE = "date";

    //constructor for the DBHandler class - takes in a parameter defining the context
    public DBManager(Context context) {
        //UsersDB is the name of the database which will be created
        //null is to say use the standard SQL Cursor behaviours   //1 is the version number of the DB
        super(context, "UsersDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //build a string which contains the necessary SQL to create the USERS table
        final String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS +
                "(" + COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_USERNAME + " TEXT," + COLUMN_PASSWORD + " TEXT," +
                COLUMN_FIRST_NAME + " TEXT," + COLUMN_LAST_NAME + " TEXT" +
                ")";

        //execute the sql by calling the execSQL method
        db.execSQL(CREATE_USERS_TABLE);


        //build a string which contains the necessary SQL to create the REVIEWS table
        final String CREATE_COMMENTS_TABLE = "CREATE TABLE " + TABLE_COMMENTS +
                "(" + COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_ATTRACTION_ID + " INT," + COLUMN_USERNAME + " TEXT," +
                COLUMN_ATTRACTION_COMMENT + " TEXT," + COLUMN_ATTRACTION_RATING + " INT," + COLUMN_DATE + " TEXT" +
                ")";

        //execute the sql by calling the execSQL method
        db.execSQL(CREATE_COMMENTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {//method not needed}
    }

    //add user to users table - takes in a parameter of User
    public void addUser(User user) {
        //content values class allows us to store all the data we wish to insert for the new user
        ContentValues values = new ContentValues();

        //call the put method to add the data we wish for a certain column
        values.put(COLUMN_FIRST_NAME, user.getFirstName());
        values.put(COLUMN_LAST_NAME, user.getLastName());
        values.put(COLUMN_USERNAME, user.getUsername());
        values.put(COLUMN_PASSWORD, user.getPassword());

        //get a connection to the db we setup
        SQLiteDatabase db = this.getWritableDatabase();

        //call the insert method to add all the data in the ContentValues object to a new row in the db
        db.insert(TABLE_USERS, null, values);

        //close the db
        db.close();
    }

    //Check if new username is already in table - takes in the email address
    public boolean usernameTaken(String username) {
        //build a string which contains the necessary SQL to check if the username exists
        String query = "SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME +
                " = '" + username + "'";

        //get a connection to the db we setup
        SQLiteDatabase db = this.getWritableDatabase();

        //declare a cursor which will be used to read the data from the database table
        Cursor cursor = db.rawQuery(query, null);

        //declare a boolean to hold whether the username is found or not
        boolean taken = false;

        //Carry out SQL query on username from users Table
        //Use 'Cursor' to hold any results - should be 1 result if found and 0 if not
        if (cursor.getCount() > 0) {
            taken = true;
            cursor.close();
        }

        //close the db connection
        db.close();

        //return the boolean value
        return taken;
    }

    //CheckLogin method confirms if username is in database and if so checks if stored password matches input
    //both checks must pass to return true - the user logged in correctly
    public boolean checkLogin(String username, String password) {
        //build a string which contains the necessary SQL to check if the username and password combo ecist
        String query = "SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + " = '" +
                username + "' AND " + COLUMN_PASSWORD + " = '" + password + "'";

        //get a connection to the db we setup
        SQLiteDatabase db = this.getWritableDatabase();

        //db.execSQL("delete from "+ TABLE_USERS);
        //db.execSQL("delete from "+ TABLE_REVIEWS);

        //declare a cursor which will be used to read the data from the database table
        Cursor cursor = db.rawQuery(query, null);

        //Carry out SQL query on username and password from users Table
        //Use 'Cursor' to hold any results - should be 1 result if found and 0 if not
        boolean valid = false;

        if(cursor.getCount() > 0) {
            valid = true;
            cursor.close();
        }

        return valid;
    }

    // passes in an email address and returns the first name of the account it belongs to
    public String getFirstName(String username) {
        String query = "SELECT " + COLUMN_FIRST_NAME + " FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + " = '" + username + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(query, null);
        String firstName = "";

        if (c.moveToFirst()) {
            firstName = c.getString(c.getColumnIndex(COLUMN_FIRST_NAME));
        }

        return firstName;
    }

    // add comment to the comment table
    public void addComment(Comment comment) {
        ContentValues values = new ContentValues();

        values.put(COLUMN_ATTRACTION_ID, comment.getAttractionId());
        values.put(COLUMN_USERNAME, comment.getUsername());
        values.put(COLUMN_ATTRACTION_COMMENT, comment.getComment());
        values.put(COLUMN_ATTRACTION_RATING, comment.getRating());
        values.put(COLUMN_DATE, comment.getDate());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_COMMENTS, null, values);

        db.close();
    }

    public ArrayList<Comment> getComments(int attractionId) {
        ArrayList<Comment> comments = new ArrayList<>();

        String query =
                "SELECT * FROM " + TABLE_COMMENTS + " WHERE " + COLUMN_ATTRACTION_ID +
                " = " + attractionId + "";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if(cursor.getCount() > 0) {
            cursor.moveToFirst();
            while(cursor.moveToNext()) {
                Comment comment = new Comment(cursor.getInt(1), cursor.getString(2), cursor.getString(3), cursor.getInt(4), cursor.getString(5));

                comments.add(comment);
            }
        }

        return comments;
    }


}

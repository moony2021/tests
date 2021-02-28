package com.example.tests;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Zoom on 10/1/2018.
 */

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context) {
        super(context, DataOptions.DATABASE_NAME, null, DataOptions.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create table
        db.execSQL(DataOptions.CREATE_TABLE_USER_);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + DataOptions.USER_TABLE);
        // Create tables again
        onCreate(db);
    }

    public User queryUser(String email, String password) {

        SQLiteDatabase db = this.getReadableDatabase();
        User user = null;

        Cursor cursor = db.query(DataOptions.USER_TABLE, new String[]{DataOptions.ID,
                        DataOptions.EMAIL, DataOptions.PASSWORD}, DataOptions.EMAIL + "=? and " + DataOptions.PASSWORD + "=?",
                new String[]{email, password}, null, null, null, "1");
        if (cursor != null)
            cursor.moveToFirst();
        if (cursor != null && cursor.getCount() > 0) {
            user = new User(cursor.getString(0), cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6));
        }
        // return user
        return user;
    }

    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DataOptions.EMAIL, user.getEMail());
        values.put(DataOptions.PASSWORD, user.getUserPassword());

       values.put(DataOptions.FULL_NAME, user.getFullName());
        values.put(DataOptions.GENDER, user.getUserGender());
       values.put(DataOptions.BIRTH_DATE, user.getUserBirthDate());
        values.put(DataOptions.USER_CITY, user.getUserCity());
        values.put(DataOptions.MOBILE, user.getMobile());
        values.put(DataOptions.EMAIL, user.getEMail());
        values.put(DataOptions.PASSWORD, user.getUserPassword());

        // Inserting Row
        db.insert(DataOptions.USER_TABLE, null, values);
        db.close(); // Closing database connection

    }

}
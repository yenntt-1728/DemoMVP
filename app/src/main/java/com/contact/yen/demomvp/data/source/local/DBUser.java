package com.contact.yen.demomvp.data.source.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBUser extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "user";
    public static final String TABLE_NAME = "user";
    public static final String  COLUMN_ID = "mID";
    public static final String COLUMN_USERNAME = "mUsername";
    public static final String COLUMN_PASSWORD = "mPassword";
    public static final String COLUMN_EMAIL = "mEmail";

    public static final int VERSION = 1;


    public DBUser(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlQuery = "CREATE TABLE "+TABLE_NAME +" (" +
                COLUMN_ID +" integer primary key, "+
                COLUMN_USERNAME + " TEXT, "+
                COLUMN_PASSWORD +" TEXT, "+
                COLUMN_EMAIL+" TEXT )";
        db.execSQL(sqlQuery);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}

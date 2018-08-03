package com.contact.yen.demomvp.data.source.local;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.contact.yen.demomvp.data.model.User;
import com.contact.yen.demomvp.data.source.UserDataSource;

import java.util.ArrayList;
import java.util.List;

public class UserLocalDataSource implements UserDataSource.LocalDataSource {
    private DBUser mDBUser;
    public static final String TABLE_NAME = "user";
    public static final String COLUMN_ID = "mID";
    public static final String COLUMN_USERNAME = "mUsername";
    public static final String COLUMN_PASSWORD = "mPassword";
    public static final String COLUMN_EMAIL = "mEmail";

    public UserLocalDataSource(DBUser dbUser) {
    }

    @Override
    public void addUser(User user) {
        SQLiteDatabase db = mDBUser.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USERNAME, user.getUsername());
        contentValues.put(COLUMN_PASSWORD, user.getUsername());
        contentValues.put(COLUMN_EMAIL, user.getUsername());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    @Override
    public List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        SQLiteDatabase db = mDBUser.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(cursor.getInt(0));
                user.setUsername(cursor.getString(1));
                user.setPassword(cursor.getString(2));
                user.setEmail(cursor.getString(3));
                users.add(user);
            } while (cursor.moveToNext());
        }

        return users;
    }

    @Override
    public boolean checkLogin(String username, String password) {
        boolean STATE = false;
        SQLiteDatabase db = mDBUser.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(1);
                String pass = cursor.getString(2);
                if (name.equals(username) && pass.equals(password)) {
                    STATE = true;
                }
            } while (cursor.moveToNext());
        }
        db.close();
        return STATE;
    }
}

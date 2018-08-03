package com.contact.yen.demomvp.data.model;

import java.lang.ref.PhantomReference;

public class User {
    private int mID;
    private String mUsername;
    private String mPassword;
    private String mEmail;
    private String mReentryPassword;

    public User() {
    }

    public User(int mID, String username, String password, String email, String reentryPassword) {
        this.mID = mID;
        mUsername = username;
        mPassword = password;
        mEmail = email;
        mReentryPassword = reentryPassword;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getReentryPassword() {
        return mReentryPassword;
    }

    public void setReentryPassword(String reentryPassword) {
        mReentryPassword = reentryPassword;
    }

    public int getId() {
        return mID;
    }

    public void setId(int id) {
        this.mID = id;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

package com.contact.yen.demomvp.data.repository;

import com.contact.yen.demomvp.data.model.User;
import com.contact.yen.demomvp.data.source.UserDataSource;
import com.contact.yen.demomvp.data.source.local.UserLocalDataSource;

import java.util.List;

public class UserRepository implements UserDataSource.LocalDataSource{
    private UserLocalDataSource mUserLocalDataSource;

    public UserRepository(UserLocalDataSource userLocalDataSource) {
        this.mUserLocalDataSource = userLocalDataSource;
    }

    @Override
    public void addUser(User user) {
        mUserLocalDataSource.addUser(user);
    }

    @Override
    public List<User> loadUsers() {
        return mUserLocalDataSource.loadUsers();
    }

    @Override
    public boolean checkLogin(String username, String password) {
        return false;
    }
}

package com.contact.yen.demomvp.data.source;

import com.contact.yen.demomvp.data.model.User;

import java.util.List;

public interface UserDataSource {
    interface LocalDataSource{
        void addUser(User user);
        List<User> loadUsers();
        boolean checkLogin(String username, String password);
    }

}

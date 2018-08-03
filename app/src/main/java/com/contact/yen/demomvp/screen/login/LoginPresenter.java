package com.contact.yen.demomvp.screen.login;

import android.content.Context;

import com.contact.yen.demomvp.data.repository.UserRepository;

public class LoginPresenter implements LoginContract.Presenter {
    private UserRepository mUserRepository;
    private Context mContext;
    private LoginContract.View mLoginContract;

    public LoginPresenter(UserRepository mUserRepository, Context context) {
        this.mUserRepository = mUserRepository;
        this.mContext = context;
    }

    @Override
    public boolean checkLogin(String username, String password) {
        if(mUserRepository.checkLogin(username, password)){
            mLoginContract.clearText();
        }else mLoginContract.showError();
        return false;
    }
}

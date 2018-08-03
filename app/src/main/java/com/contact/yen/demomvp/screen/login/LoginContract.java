package com.contact.yen.demomvp.screen.login;

public interface LoginContract {
    interface View{
        void showError();
        void clearText();
    }
    interface Presenter{
        boolean checkLogin(String username, String password);
    }

}

package com.contact.yen.demomvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.contact.yen.demomvp.data.repository.UserRepository;
import com.contact.yen.demomvp.data.source.local.DBUser;
import com.contact.yen.demomvp.data.source.local.UserLocalDataSource;
import com.contact.yen.demomvp.screen.login.LoginContract;
import com.contact.yen.demomvp.screen.login.LoginPresenter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, LoginContract.View {

    private EditText mEditUsername;
    private EditText mEditPassword;
    private Button mButtonLogin;
    private DBUser mDBUser;
    private UserRepository mUserRepository;
    private LoginContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mButtonLogin.setOnClickListener(this);
        mDBUser = new DBUser(this);
        UserRepository mUserRepository = new UserRepository(new UserLocalDataSource(mDBUser));
        mPresenter = new LoginPresenter(mUserRepository, this);
    }

    private void initView() {
        mEditUsername = findViewById(R.id.edit_username);
        mEditPassword = findViewById(R.id.edit_password);
        mButtonLogin = findViewById(R.id.button_login);
    }

    @Override
    public void onClick(View v) {
        String name = mEditUsername.getText().toString();
        String pass = mEditPassword.getText().toString();
        boolean state = mPresenter.checkLogin(name, pass);
        if(state == true){
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            startActivity(intent);
        }else showError();
    }

    @Override
    public void showError() {
        Toast.makeText(this,getString(R.string.error), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearText() {
        mEditUsername.setText("");
        mEditPassword.setText("");
    }
}

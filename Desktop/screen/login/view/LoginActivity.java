package com.example.ma.loginmvp.screen.login.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ma.loginmvp.R;
import com.example.ma.loginmvp.screen.home.view.HomeActivity;
import com.example.ma.loginmvp.screen.login.presenter.LoginPresenter;
import com.example.ma.loginmvp.screen.login.presenter.LoginPresenterImp;

public class LoginActivity extends AppCompatActivity implements LoginView,View.OnClickListener {
    private ProgressBar mProgress;
    private EditText mEditUserName, mEditPassWord;
    private Button mButtonLogin;
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    @Override
    public void showProgress() {
        mProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgress.setVisibility(View.GONE);
    }

    @Override
    public void setUserNameError() {
        Toast.makeText(this,getString(R.string.user_name_invalid),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPassWordError() {
        Toast.makeText(this,getString(R.string.pass_word_invalid),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateHomeActivity() {
        startActivity(new Intent(LoginActivity.this,HomeActivity.class));
    }

    private void initViews(){
        mEditUserName = findViewById(R.id.edit_user_name);
        mEditPassWord = findViewById(R.id.edit_pass_word);
        mButtonLogin = findViewById(R.id.button_login);
        mProgress = findViewById(R.id.progress_main);
        mLoginPresenter = new LoginPresenterImp(this);
        mButtonLogin.setOnClickListener(this);

        mProgress.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        showProgress();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mLoginPresenter.validateLogin(mEditUserName.getText().toString(),mEditPassWord.getText().toString());
            }
        },1000);
    }
}

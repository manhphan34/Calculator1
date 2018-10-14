package com.example.ma.loginmvp.screen.login.presenter;

import com.example.ma.loginmvp.screen.login.view.LoginView;

public class LoginPresenterImp implements LoginPresenter {
    private LoginView mLoginView;
    public LoginPresenterImp(LoginView loginView){
        mLoginView = loginView;
    }
    @Override
    public void validateLogin(String userName, String passWord) {
        if(userName.isEmpty()){
            mLoginView.hideProgress();
            mLoginView.setUserNameError();
        }else if(passWord.isEmpty()){
            mLoginView.hideProgress();
            mLoginView.setPassWordError();
        }else{
            mLoginView.hideProgress();
            mLoginView.navigateHomeActivity();
        }
    }
}

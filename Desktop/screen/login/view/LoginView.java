package com.example.ma.loginmvp.screen.login.view;

public interface LoginView {
    void showProgress();
    void hideProgress();
    void setUserNameError();
    void setPassWordError();
    void navigateHomeActivity();
}

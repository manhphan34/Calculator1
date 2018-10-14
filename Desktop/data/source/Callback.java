package com.example.ma.loginmvp.data.source;

public interface Callback<T> {
    void getDataSuccess(T data);
    void getDataFailure(Exception e);
}

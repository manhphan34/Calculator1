package com.example.ma.loginmvp.data.source.Home;

import com.example.ma.loginmvp.data.model.CategoryImage;
import com.example.ma.loginmvp.data.source.Callback;

import java.util.ArrayList;

public interface RemoteDataSource {
    void getPlayList(Callback<ArrayList<CategoryImage>> callback);
}

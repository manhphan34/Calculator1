package com.example.ma.loginmvp.data.repository;

import com.example.ma.loginmvp.data.model.CategoryImage;
import com.example.ma.loginmvp.data.source.Callback;
import com.example.ma.loginmvp.data.source.Home.FetchDataFromApi;
import com.example.ma.loginmvp.data.source.Home.RemoteDataSource;
import com.example.ma.loginmvp.myclass.MyKey;

import java.util.ArrayList;

public class HomeRepository implements RemoteDataSource {
    private static HomeRepository mInstance;
    public static HomeRepository getInstance(){
        if(mInstance == null) mInstance = new HomeRepository();
        return mInstance;
    }
    @Override
    public void getPlayList(Callback<ArrayList<CategoryImage>> callback) {
        new FetchDataFromApi.ContentCategory(callback).execute(MyKey.URL_CAT_IMAGE);
    }
}

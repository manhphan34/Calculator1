package com.example.ma.loginmvp.screen.home.presenter;

import android.util.Log;

import com.example.ma.loginmvp.data.model.CategoryImage;
import com.example.ma.loginmvp.data.repository.HomeRepository;
import com.example.ma.loginmvp.data.source.Callback;
import com.example.ma.loginmvp.screen.home.view.HomeView;

import java.util.ArrayList;

public class HomePresenterIpm implements HomePresenter {
    private HomeView mHomeView;
    public HomePresenterIpm(HomeView homeView){
        this.mHomeView = homeView;
    }
    @Override
    public void getCategory(HomeRepository homeRepository) {
        homeRepository.getPlayList(new Callback<ArrayList<CategoryImage>>() {
            @Override
            public void getDataSuccess(ArrayList<CategoryImage> data) {
                mHomeView.showCategory(data);
            }

            @Override
            public void getDataFailure(Exception e) {

            }
        });
    }
}

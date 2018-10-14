package com.example.ma.loginmvp.screen.home.presenter;

import com.example.ma.loginmvp.data.repository.HomeRepository;

import java.util.ArrayList;

public interface HomePresenter {
    void getCategory(HomeRepository homeRepository);
}

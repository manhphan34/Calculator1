package com.example.ma.loginmvp.screen.home.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ma.loginmvp.R;
import com.example.ma.loginmvp.data.model.CategoryImage;
import com.example.ma.loginmvp.data.repository.HomeRepository;
import com.example.ma.loginmvp.screen.home.presenter.HomePresenter;
import com.example.ma.loginmvp.screen.home.presenter.HomePresenterIpm;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements HomeView {
    private RecyclerView mRecCategory;
    private HomePresenter mHomePresenter;
    private Context mContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();
        loadData();
    }
    @Override
    public void showCategory(ArrayList<CategoryImage> categoryImages) {
        mHomePresenter.getCategory(HomeRepository.getInstance());
        initRecycleView(categoryImages);
    }

    private void initViews(){
        mContext = getBaseContext();
        mHomePresenter = new HomePresenterIpm(this);
        mRecCategory = findViewById(R.id.rec_category_image);
    }
    private void loadData(){
        mHomePresenter.getCategory(HomeRepository.getInstance());
    }
    private void initRecycleView(ArrayList<CategoryImage> categoryImages){
        HomeAdapter homeAdapter = new HomeAdapter(mContext,categoryImages);
        mRecCategory.setLayoutManager(new GridLayoutManager(mContext,2));
        mRecCategory.setAdapter(homeAdapter);
    }
}

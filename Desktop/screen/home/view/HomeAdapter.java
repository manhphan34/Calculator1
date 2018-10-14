package com.example.ma.loginmvp.screen.home.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ma.loginmvp.R;
import com.example.ma.loginmvp.data.model.CategoryImage;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.CategoryViewHolder> {
    private Context mContext;
    private ArrayList<CategoryImage> arrayList;

    public HomeAdapter(Context mContext, ArrayList<CategoryImage> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_category,viewGroup,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {
        CategoryImage image = arrayList.get(i);
        Picasso.get().load(image.getCatPathImage())
                .resize(250,180)
                .into(categoryViewHolder.mImageCat);
        categoryViewHolder.mTextCat.setText(image.getCatName());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageCat;
        private TextView mTextCat;
        private View mView;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            mImageCat = mView.findViewById(R.id.image_view_category);
            mTextCat = mView.findViewById(R.id.text_view_category);
        }
    }
}

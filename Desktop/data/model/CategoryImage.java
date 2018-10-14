package com.example.ma.loginmvp.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.ma.loginmvp.myclass.MyKey;

import org.json.JSONException;
import org.json.JSONObject;

public class CategoryImage implements Parcelable {
    private int mCatId;
    private String mCatName;
    private String mCatPathImage;

    public CategoryImage(int mCatId, String mCatName, String mCatPathImage) {
        this.mCatId = mCatId;
        this.mCatName = mCatName;
        this.mCatPathImage = mCatPathImage;
    }

    protected CategoryImage(Parcel in) {
        this.mCatId = in.readInt();
        this.mCatName = in.readString();
        this.mCatPathImage = in.readString();
    }
    public CategoryImage(JSONObject jsonObject){
        try {
            this.mCatId = jsonObject.getInt(MyKey.CAT_ID);
            this.mCatName = jsonObject.getString(MyKey.CAT_NAME);
            this.mCatPathImage = jsonObject.getString(MyKey.CAT_IMAGE_PATH);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static final Creator<CategoryImage> CREATOR = new Creator<CategoryImage>() {
        @Override
        public CategoryImage createFromParcel(Parcel in) {
            return new CategoryImage(in);
        }

        @Override
        public CategoryImage[] newArray(int size) {
            return new CategoryImage[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mCatId);
        dest.writeString(mCatName);
        dest.writeString(mCatPathImage);
    }

    public int getCatId() {
        return mCatId;
    }

    public void setCatId(int mCatId) {
        this.mCatId = mCatId;
    }

    public String getCatName() {
        return mCatName;
    }

    public void setCatName(String mCatName) {
        this.mCatName = mCatName;
    }

    public String getCatPathImage() {
        return mCatPathImage;
    }

    public void setCatPathImage(String mCatPathImage) {
        this.mCatPathImage = mCatPathImage;
    }
}

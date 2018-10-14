package com.example.ma.loginmvp.data.source.Home;

import android.os.AsyncTask;
import android.util.Log;

import com.example.ma.loginmvp.data.model.CategoryImage;
import com.example.ma.loginmvp.data.source.Callback;
import com.example.ma.loginmvp.myclass.MyKey;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class FetchDataFromApi {
    public static String getCategoryJson(String path){
        String json = "";
        try {
            URL url = new URL(path);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String str;
            while ((str = in.readLine()) != null) {
                    json = json.concat(str.concat("\n"));
            }
            in.close();
            httpURLConnection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }
    public static ArrayList<CategoryImage> getCategoryData(String json){
        ArrayList<CategoryImage> categoryImages = new ArrayList<>();
        try {
            JSONArray cats = new JSONArray(new JSONObject(json).getString(MyKey.HD_WALLPAPER));
            for(int i = 0 ;i <cats.length();i++){
                categoryImages.add(new CategoryImage(cats.getJSONObject(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return categoryImages;
    }
    public static class ContentCategory extends AsyncTask<String,Void,String>{
        private Callback<ArrayList<CategoryImage>> mCallback;
        public ContentCategory(Callback<ArrayList<CategoryImage>> callback){
            mCallback = callback;
        }
        @Override
        protected String doInBackground(String... strings) {
            return FetchDataFromApi.getCategoryJson(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            mCallback.getDataSuccess(FetchDataFromApi.getCategoryData(s));
        }
    }
}

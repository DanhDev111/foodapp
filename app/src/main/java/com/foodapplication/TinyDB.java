package com.foodapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.preference.PreferenceManager;

import java.util.ArrayList;

public class TinyDB {
    SharedPreferences preferences;
    String DEFAULT_APP_IMAGEDATA_DIRECTORY;
    String lastImagePath ="";
    public  TinyDB(Context appContext){
        preferences= PreferenceManager.getDefaultSharedPreferences(appContext);
    }
    public Bitmap getImages(String path){
        Bitmap bitmapFromPath = null;
        try {
            bitmapFromPath = BitmapFactory.decodeFile(path);
        } catch (Exception e){
            e.printStackTrace();
        }
        return  bitmapFromPath;
    }
    public  String getSavedImagePath(){
        return lastImagePath;
    }

    public void putListObject(String cartList, ArrayList<FoodDomain> listFood) {
    }

//    public ArrayList<FoodDomain> getListObject(String cartList) {
//    }
}

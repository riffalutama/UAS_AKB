package com.example.uas_akb_if13_10116652.Model;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.uas_akb_if13_10116652.Presenter.SplashPresenter;

public class SplashModel {// 15 Agustus 2019 - 10116652 - Riffal Utama - IF-13//
    SplashPresenter presenter;

    public SplashModel(SplashPresenter presenter) {
        this.presenter = presenter;
    }

    public static void save(Context context, String name, String value){
        SharedPreferences sharedPreferences = context.getSharedPreferences("first",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(name , value);
        editor.apply();
    }

    public static String read(Context context, String name, String defvalue){
        SharedPreferences sharedPreferences = context.getSharedPreferences("first", Context.MODE_PRIVATE);
        return sharedPreferences.getString(name , defvalue);
    }
}


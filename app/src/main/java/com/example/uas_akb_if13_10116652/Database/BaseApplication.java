package com.example.uas_akb_if13_10116652.Database;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class BaseApplication extends Application {// 15 Agustus 2019 - 10116652 - Riffal Utama - IF-13//
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("database.realm")
                .schemaVersion(0)
                .build();
        Realm.setDefaultConfiguration(config);
    }
}
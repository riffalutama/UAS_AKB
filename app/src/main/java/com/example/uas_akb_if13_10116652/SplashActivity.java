package com.example.uas_akb_if13_10116652;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.uas_akb_if13_10116652.Database.RealmHelper;
import com.example.uas_akb_if13_10116652.Model.SplashModel;
import com.example.uas_akb_if13_10116652.Model.UserModel;
import com.example.uas_akb_if13_10116652.R;
import com.example.uas_akb_if13_10116652.View.SplashView;
import com.wang.avi.AVLoadingIndicatorView;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class SplashActivity extends AppCompatActivity implements SplashView {
    // 15 Agustus 2019 - 10116652 - Riffal Utama - IF-13//
    Realm realm;
    RealmHelper realmHelper;

    private LinearLayout lv_loading;
    private AVLoadingIndicatorView avi;

    boolean firstTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        lv_loading = (LinearLayout) findViewById(R.id.lv_loading);
        avi = (AVLoadingIndicatorView) findViewById(R.id.avi);
        avi.setIndicator("BallClipRotateMultipleIndicator");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                firstTime();
            }
        },5000);
    }

    @Override
    public void firstTime() {
        firstTime = Boolean.valueOf(SplashModel.read(getApplicationContext(),"first","false"));
        if(firstTime){
            startActivity(new Intent(SplashActivity.this,BottomNavigation.class));
            finish();
        }else{
            dataAwal();

            startActivity(new Intent(SplashActivity.this,InfoApp.class));
            SplashModel.save(getApplicationContext(),"first","true");
            finish();
        }
    }

    private void dataAwal() {
        RealmConfiguration configuration = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
        realm = Realm.getInstance(configuration);

        UserModel userModel = new UserModel();
        userModel.setNim("10116652");
        userModel.setNama("Riffal Utama");
        userModel.setEmail("riffalsiutama@gmail.com");
        userModel.setKelas("IF-13");
        userModel.setTelepon("0895389965104");
        userModel.setInstagram("@riffal");
        realmHelper = new RealmHelper(realm);
        realmHelper.save(userModel);

        UserModel userModel2 = new UserModel();
        userModel2.setNim("10116666");
        userModel2.setNama("Yuno");
        userModel2.setEmail("yunchan@gmail.com");
        userModel2.setKelas("IF-13");
        userModel2.setTelepon("08999999999");
        userModel2.setInstagram("@ayunchan");

        realmHelper = new RealmHelper(realm);
        realmHelper.save(userModel2);
    }
}

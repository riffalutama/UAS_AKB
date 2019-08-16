package com.example.uas_akb_if13_10116652;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.uas_akb_if13_10116652.Model.MainModel;
import com.example.uas_akb_if13_10116652.R;
import com.example.uas_akb_if13_10116652.View.MainView;

public class BottomNavigation extends AppCompatActivity implements MainView {
    // 15 Agustus 2019 - 10116652 - Riffal Utama - IF-13//
    Boolean session;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_profile:
                    selectedFragment = new ProfileFragment();

                    break;
                case R.id.navigation_contact:
                    selectedFragment = new ContactFragment();
                    break;
                case R.id.navigation_friends:
                    startActivity(new Intent(BottomNavigation.this,Friends.class));
                    finish();
                    break;
                case R.id.navigation_logout:
                    MainModel.save(getApplicationContext(),"session","false");
                    startActivity(new Intent(BottomNavigation.this,Login.class));
                    finish();
                    break;
            }
            if(selectedFragment!=null){
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                return true;
            }else
                return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        SESSION();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProfileFragment()).commit();
    }

    @Override
    public void SESSION() {
        session = Boolean.valueOf(MainModel.read(getApplicationContext(),"session","false"));
        if(session){

        }else{
            startActivity(new Intent(BottomNavigation.this,Login.class));
        }
    }
}

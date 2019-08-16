package com.example.uas_akb_if13_10116652.Presenter;

import com.example.uas_akb_if13_10116652.Model.SplashModel;
import com.example.uas_akb_if13_10116652.View.SplashView;

public class SplashPresenterImpt implements SplashPresenter {// 15 Agustus 2019 - 10116652 - Riffal Utama - IF-13//

    SplashView view;
    SplashModel model;

    public SplashPresenterImpt(SplashView view) {
        this.view = view;
        this.model = new SplashModel(this);
    }

    @Override
    public void firstTime() {
        view.firstTime();
    }
}

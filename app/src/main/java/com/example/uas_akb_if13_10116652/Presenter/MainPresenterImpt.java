package com.example.uas_akb_if13_10116652.Presenter;

import com.example.uas_akb_if13_10116652.Model.MainModel;
import com.example.uas_akb_if13_10116652.View.MainView;

public class MainPresenterImpt implements MainPresenter {// 15 Agustus 2019 - 10116652 - Riffal Utama - IF-13//
    MainView view;
    MainModel model;

    public MainPresenterImpt(MainView view) {
        this.view = view;
        this.model = new MainModel(this);
    }

    @Override
    public void SESSION() {
        view.SESSION();
    }
}

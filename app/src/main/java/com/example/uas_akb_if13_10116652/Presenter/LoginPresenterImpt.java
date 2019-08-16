package com.example.uas_akb_if13_10116652.Presenter;

import android.support.design.widget.TextInputLayout;

import com.example.uas_akb_if13_10116652.Model.LoginModel;
import com.example.uas_akb_if13_10116652.View.LoginView;

public class LoginPresenterImpt implements LoginPresenter {// 15 Agustus 2019 - 10116652 - Riffal Utama - IF-13//
    LoginView view;
    LoginModel model;

    public LoginPresenterImpt(LoginView view) {
        this.view = view;
        this.model = new LoginModel(this);
    }

    @Override
    public boolean validateUsername(TextInputLayout input, String username, String dataUsername, String dataEmail) {
        return model.validateUsername(input,username,dataUsername,dataEmail);
    }

    @Override
    public boolean validatePassword(TextInputLayout input, String password, String dataPassword) {
        return model.validatePassword(input,password,dataPassword);
    }
}

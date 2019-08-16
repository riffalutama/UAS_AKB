package com.example.uas_akb_if13_10116652.Presenter;

import android.support.design.widget.TextInputLayout;

import com.example.uas_akb_if13_10116652.Model.RegisterModel;
import com.example.uas_akb_if13_10116652.View.RegisterView;

public class RegisterPresenterImpt implements RegisterPresenter {// 15 Agustus 2019 - 10116652 - Riffal Utama - IF-13//

    RegisterView view;
    RegisterModel model;

    public RegisterPresenterImpt(RegisterView view) {
        this.view = view;
        this.model = new RegisterModel(this);
    }


    @Override
    public boolean validateEmail(TextInputLayout input, String email) {
        return model.validateEmail(input, email);
    }

    @Override
    public boolean validateUsername(TextInputLayout input, String username) {
        return model.validateUsername(input, username);
    }

    @Override
    public boolean validatePassword(TextInputLayout input, String password) {
        return model.validatePassword(input, password);
    }
}

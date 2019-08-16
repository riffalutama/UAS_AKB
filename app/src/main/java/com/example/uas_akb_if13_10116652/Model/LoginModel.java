package com.example.uas_akb_if13_10116652.Model;

import android.support.design.widget.TextInputLayout;

import com.example.uas_akb_if13_10116652.Presenter.LoginPresenter;


public class LoginModel {// 15 Agustus 2019 - 10116652 - Riffal Utama - IF-13//

    LoginPresenter presenter;

    public LoginModel(LoginPresenter presenter) {
        this.presenter = presenter;
    }

    public boolean validateUsername(TextInputLayout inputLayout, String usernameInput, String username, String email) {

        if (usernameInput.isEmpty()) {
            inputLayout.setError("Data tidak boleh kosong");
            return false;
        } else if ((!username.equalsIgnoreCase(usernameInput)) && (!email.equalsIgnoreCase(usernameInput))) {
            inputLayout.setError("Username tidak terdaftar");
            return false;
        } else {
            inputLayout.setError(null);
            return true;
        }
    }

    public boolean validatePassword(TextInputLayout inputLayout, String passwordInput, String password) {

        if (passwordInput.isEmpty()) {
            inputLayout.setError("Data tidak boleh kosong");
            return false;
        } else if (!password.equalsIgnoreCase(passwordInput)) {
            inputLayout.setError("Password tidak sesuai");
            return false;
        } else {
            inputLayout.setError(null);
            return true;
        }
    }

}

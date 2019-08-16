package com.example.uas_akb_if13_10116652.Model;

import android.support.design.widget.TextInputLayout;
import android.util.Patterns;

import com.example.uas_akb_if13_10116652.Presenter.RegisterPresenter;


public class RegisterModel {// 15 Agustus 2019 - 10116652 - Riffal Utama - IF-13//

    RegisterPresenter presenter;

    public RegisterModel(RegisterPresenter presenter) {
        this.presenter = presenter;
    }

    public boolean validateEmail(TextInputLayout input, String emailInput){

        if (emailInput.isEmpty()) {
            input.setError("Data tidak boleh kosong");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            input.setError("Email address tidak valid");
            return false;
        } else {
            input.setError(null);
            return true;
        }
    }

    public boolean validateUsername(TextInputLayout inputLayout, String usernameInput) {

        if (usernameInput.isEmpty()) {
            inputLayout.setError("Data tidak boleh kosong");
            return false;
        } else if (usernameInput.length() < 4) {
            inputLayout.setError("Username minimal 4 karakter");
            return false;
        } else {
            inputLayout.setError(null);
            return true;
        }
    }

    public boolean validatePassword(TextInputLayout inputLayout, String passwordInput) {

        if (passwordInput.isEmpty()) {
            inputLayout.setError("Data tidak boleh kosong");
            return false;
        } else if (passwordInput.length() < 4) {
            inputLayout.setError("Password minimal 4 karakter");
            return false;
        } else {
            inputLayout.setError(null);
            return true;
        }
    }
}

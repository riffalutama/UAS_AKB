package com.example.uas_akb_if13_10116652.Presenter;

import android.support.design.widget.TextInputLayout;

public interface LoginPresenter {
    boolean validateUsername(TextInputLayout input, String username, String dataUsername, String dataEmail);
    boolean validatePassword(TextInputLayout input, String password, String dataPassword);
}

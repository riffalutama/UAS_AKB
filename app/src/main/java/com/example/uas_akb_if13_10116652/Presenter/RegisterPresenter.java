package com.example.uas_akb_if13_10116652.Presenter;

import android.support.design.widget.TextInputLayout;

public interface RegisterPresenter {
    boolean validateEmail(TextInputLayout input, String email);
    boolean validateUsername(TextInputLayout input, String username);
    boolean validatePassword(TextInputLayout input, String password);
}

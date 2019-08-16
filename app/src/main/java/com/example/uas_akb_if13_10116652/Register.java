package com.example.uas_akb_if13_10116652;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.uas_akb_if13_10116652.Model.MainModel;
import com.example.uas_akb_if13_10116652.Presenter.RegisterPresenter;
import com.example.uas_akb_if13_10116652.Presenter.RegisterPresenterImpt;
import com.example.uas_akb_if13_10116652.R;
import com.example.uas_akb_if13_10116652.View.RegisterView;


public class Register extends AppCompatActivity implements RegisterView {
    // 15 Agustus 2019 - 10116652 - Riffal Utama - IF-13//
    private TextInputLayout textInputEmail;
    private TextInputLayout textInputUsername;
    private TextInputLayout textInputPassword;

    RegisterPresenter presenter;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    String emailInput,usernameInput,passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textInputEmail = findViewById(R.id.text_input_email);
        textInputUsername = findViewById(R.id.text_input_username);
        textInputPassword = findViewById(R.id.text_input_password);

        presenter = new RegisterPresenterImpt(this);

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);


    }

    public boolean validateEmail() {
        emailInput = textInputEmail.getEditText().getText().toString().trim();

        return presenter.validateEmail(textInputEmail, emailInput);
    }

    public boolean validateUsername() {
        usernameInput = textInputUsername.getEditText().getText().toString().trim();

        return presenter.validateUsername(textInputUsername, usernameInput);
    }

    public boolean validatePassword() {
        passwordInput = textInputPassword.getEditText().getText().toString().trim();

        return presenter.validatePassword(textInputPassword, passwordInput);
    }

    public void confirmInput(View v) {
        if (!validateEmail() | !validateUsername() | !validatePassword()) {

        }else {
            editor = sharedPreferences.edit();
            emailInput = textInputEmail.getEditText().getText().toString().trim();
            usernameInput = textInputUsername.getEditText().getText().toString().trim();
            passwordInput = textInputPassword.getEditText().getText().toString().trim();

            editor.putString("emailKey", emailInput);
            editor.putString("nameKey", usernameInput);
            editor.putString("passwordKey", passwordInput);
            editor.commit();
            Toast.makeText(Register.this, "Registration Successful", Toast.LENGTH_SHORT).show();

            MainModel.save(getApplicationContext(),"session","true");
            startActivity(new Intent(Register.this,Login.class));
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Register.this,Login.class));
        finish();
    }
}

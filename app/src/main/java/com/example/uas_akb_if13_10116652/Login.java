package com.example.uas_akb_if13_10116652;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uas_akb_if13_10116652.Model.MainModel;
import com.example.uas_akb_if13_10116652.Presenter.LoginPresenter;
import com.example.uas_akb_if13_10116652.Presenter.LoginPresenterImpt;
import com.example.uas_akb_if13_10116652.R;
import com.example.uas_akb_if13_10116652.View.LoginView;

public class Login extends AppCompatActivity implements LoginView {
    // 15 Agustus 2019 - 10116652 - Riffal Utama - IF-13//
    TextInputLayout textUsername,textPassword;
    TextView daftar;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textUsername = (TextInputLayout)findViewById(R.id.textUsername);
        textPassword = (TextInputLayout)findViewById(R.id.textPassword);
        daftar = (TextView)findViewById(R.id.daftarDisini);

        presenter = new LoginPresenterImpt(this);

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,Register.class));
                finish();
            }
        });

    }

    public boolean validateUsername() {
        String usernameInput = textUsername.getEditText().getText().toString().trim();
        final String email = sharedPreferences.getString("emailKey","admin");
        final String username = sharedPreferences.getString("nameKey", "admin");

        return presenter.validateUsername(textUsername,usernameInput,username,email);
    }

    public boolean validatePassword() {
        String passwordInput = textPassword.getEditText().getText().toString().trim();
        final String password = sharedPreferences.getString("passwordKey", "admin");

        return presenter.validatePassword(textPassword, passwordInput, password);
    }

    public void confirmInput(View v) {
        if (!validateUsername() | !validatePassword()) {

        }else {

            Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show();
            MainModel.save(getApplicationContext(),"session","true");
            startActivity(new Intent(Login.this,BottomNavigation.class));
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.exit(0);
    }
}

package com.example.uas_akb_if13_10116652;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.uas_akb_if13_10116652.Adapter.UserAdapter;
import com.example.uas_akb_if13_10116652.Database.RealmHelper;
import com.example.uas_akb_if13_10116652.Model.UserModel;
import com.example.uas_akb_if13_10116652.R;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class Friends extends AppCompatActivity {
    // 15 Agustus 2019 - 10116652 - Riffal Utama - IF-13//
    Realm realm;
    RealmHelper realmHelper;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    UserAdapter adapter;
    List<UserModel> userModel;

    FloatingActionButton fab;

    TextInputEditText edtNim,edtNama,edtKelas,edtEmail,edtTelepon,edtInstagram;
    String strNim, strNama, strKelas, strEmail, strTelepon,strInstagram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        //setup realm
        RealmConfiguration configuration = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
        realm = Realm.getInstance(configuration);

        recyclerView = (RecyclerView)findViewById(R.id.myRecycler);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        realmHelper = new RealmHelper(realm);
        userModel = new ArrayList<>();

        userModel = realmHelper.getAllUser();

        adapter = new UserAdapter(userModel,this);

        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

        fab = (FloatingActionButton)findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddDialog();
            }
        });
    }

    private void showAddDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Friends.this);
        alertDialog.setTitle("Tambah Kontak");

        LayoutInflater inflater = this.getLayoutInflater();
        View add_layout = inflater.inflate(R.layout.add_layout,null);

        edtNim = (TextInputEditText) add_layout.findViewById(R.id.edtNim);
        edtNama = (TextInputEditText)add_layout.findViewById(R.id.edtNama);
        edtKelas = (TextInputEditText)add_layout.findViewById(R.id.edtKelas);
        edtEmail = (TextInputEditText)add_layout.findViewById(R.id.edtEmail);
        edtTelepon = (TextInputEditText)add_layout.findViewById(R.id.edtTelepon);
        edtInstagram = (TextInputEditText)add_layout.findViewById(R.id.edtInstagram);

        alertDialog.setView(add_layout);
        alertDialog.setIcon(R.drawable.icon_add_black_24dp);

        //set button
        alertDialog.setPositiveButton("Tambah", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

                strNim = edtNim.getText().toString();
                strNama = edtNama.getText().toString();
                strKelas = edtKelas.getText().toString();
                strEmail = edtEmail.getText().toString();
                strTelepon = edtTelepon.getText().toString();
                strInstagram = edtInstagram.getText().toString();

                if(!strNim.isEmpty() && !strNama.isEmpty()){
                    UserModel userModel = new UserModel();
                    userModel.setNim(strNim);
                    userModel.setNama(strNama);
                    userModel.setEmail(strEmail);
                    userModel.setKelas(strKelas);
                    userModel.setTelepon(strTelepon);
                    userModel.setInstagram(strInstagram);

                    realmHelper = new RealmHelper(realm);
                    realmHelper.save(userModel);

                    Toast.makeText(Friends.this, "Data Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();

                    edtNim.setText("");
                    edtInstagram.setText("");
                    edtTelepon.setText("");
                    edtEmail.setText("");
                    edtKelas.setText("");
                    edtNama.setText("");
                }else{
                    Toast.makeText(Friends.this, "Data Harus Diisi!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        alertDialog.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Friends.this,BottomNavigation.class));
        finish();
    }
}

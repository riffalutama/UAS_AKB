package com.example.uas_akb_if13_10116652.Database;

import android.util.Log;

import com.example.uas_akb_if13_10116652.Model.UserModel;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmHelper {// 15 Agustus 2019 - 10116652 - Riffal Utama - IF-13//
    Realm realm;

    public RealmHelper(Realm realm) {
        this.realm = realm;
    }

    //save data to realm
    public void save(final UserModel userModel){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (realm != null){
                    Log.e("success","database was created");
                    Number currentIdNum = realm.where(UserModel.class).max("id");
                    int nextId;
                    if(currentIdNum == null){
                        nextId = 1;
                    }else {
                        nextId = currentIdNum.intValue() + 1;
                    }
                    userModel.setId(nextId);
                    UserModel u = realm.copyToRealm(userModel);
                }else{
                    Log.e("failed","database not exist");
                }
            }
        });
    }

    //select data from realm
    public List<UserModel> getAllUser(){
        RealmResults<UserModel> userModels = realm.where(UserModel.class).findAll();
        return userModels;
    }

    //edit
    public void update(final int id, final String nim, final String nama, final String kelas, final String telepon, final String email, final String instagram){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                UserModel users = realm.where(UserModel.class)
                        .equalTo("id",id)
                        .findFirst();

                users.setNim(nim);
                users.setNama(nama);
                users.setKelas(kelas);
                users.setTelepon(telepon);
                users.setEmail(email);
                users.setInstagram(instagram);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.e("success","Update Successfully");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                error.printStackTrace();
            }
        });
    }

    //delete
    public void delete(final int id){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                UserModel users = realm.where(UserModel.class)
                        .equalTo("id",id)
                        .findFirst();

                users.deleteFromRealm();
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.e("success","Update Successfully");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                error.printStackTrace();
            }
        });
    }
}
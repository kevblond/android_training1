package com.example.kbl.githubappcopy;

import android.app.Application;

import com.example.kbl.githubappcopy.model.dao.RealmManager;

import io.realm.Realm;

public class MyApplication extends Application {
    private static MyApplication myApplication;

    public static Application getInstance() {
        return myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (myApplication == null) {
            myApplication = this;
        }
        Realm.init(this);

        RealmManager.initializeRealmConfig(this);
    }
}

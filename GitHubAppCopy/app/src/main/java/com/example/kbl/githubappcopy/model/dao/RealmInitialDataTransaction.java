package com.example.kbl.githubappcopy.model.dao;


import android.content.Context;
import android.util.Log;

import com.example.kbl.githubappcopy.model.Repositorie;
import com.example.kbl.githubappcopy.utils.FileUtils;

import java.io.IOException;

import io.realm.Realm;

/**
 * RealmInitialDataTransaction class
 */
public class RealmInitialDataTransaction implements Realm.Transaction {
    /**
     * Application context
     */
    private Context mContext;

    /**
     * Constructor
     *
     * @param context
     */
    public RealmInitialDataTransaction(final Context context) {
        this.mContext = context;
    }

    @Override
    public void execute(Realm realm) {
    }

}

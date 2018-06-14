package com.example.kbl.githubappcopy.model.dao;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * RealmManager class.
 */

public class RealmManager {
    static RealmConfiguration realmConfiguration;

    /**
     * Initializes configuration
     * @param context the context
     */
    public static void initializeRealmConfig(final Context context) {
        if(realmConfiguration == null) {
            setRealmConfiguration(new RealmConfiguration.Builder()
                    .deleteRealmIfMigrationNeeded()
                    .build());
        }
    }

    /**
     * Defines realm configuration
     * @param realmConfiguration the configuration
     */
    public static void setRealmConfiguration(RealmConfiguration realmConfiguration) {
        RealmManager.realmConfiguration = realmConfiguration;
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}


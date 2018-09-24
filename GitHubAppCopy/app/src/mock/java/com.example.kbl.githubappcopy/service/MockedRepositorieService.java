package com.example.kbl.githubappcopy.service;

import android.content.res.AssetManager;
import android.util.Log;

import com.example.kbl.githubappcopy.MyApplication;
import com.example.kbl.githubappcopy.model.Repositorie;
import com.example.kbl.githubappcopy.service.converter.RepositoriesDeserializer;
import com.example.kbl.githubappcopy.service.enumError.ErrorService;
import com.example.kbl.githubappcopy.utils.FileUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;
/**
 * Mocked service used for loading Json assets
 */
public class MockedRepositorieService implements IRepositoriesService {
    public static final String TAG = MockedRepositorieService.class.getSimpleName();

    ///////////////////////////////////////////////////////////////////////////
    // List Repositories
    ///////////////////////////////////////////////////////////////////////////
    @Override
    public void retrieveListRepositories(final String token, final ServiceCallBack<List<Repositorie>> callBack) {
        Log.d(TAG, "retrieveListRepo");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    Type t = new TypeToken<List<Repositorie>>(){}.getType();
                    GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(t,new RepositoriesDeserializer());
                    Gson gson = gsonBuilder.create();

                    String jSonLoaded = FileUtils.loadJsonFromAssets(token + ".json");

                    final List<Repositorie> listRepositories = gson.fromJson(jSonLoaded, t);
                    callBack.onSuccess(listRepositories);
                } catch (Exception e) {
                    Log.e("getListRepositorie", e.getMessage(), e);
                    callBack.onError(ErrorService.ERROR_LOADER);
                }
            }
        }).start();
    }
}

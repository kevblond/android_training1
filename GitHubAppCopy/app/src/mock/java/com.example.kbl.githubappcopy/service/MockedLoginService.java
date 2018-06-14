package com.example.kbl.githubappcopy.service;

import android.content.res.AssetManager;
import android.util.Log;

import com.example.kbl.githubappcopy.MyApplication;
import com.example.kbl.githubappcopy.service.enumError.ErrorService;

import java.io.IOException;

/**
 * service mocked for testing if Json assets exist
 */
public class MockedLoginService implements ILoginService {
    public static final String TAG = MockedLoginService.class.getSimpleName();

    @Override
    public void checkUser(final String token, final ServiceCallBack<String> callBack) {
        Log.d(TAG, "checkUser");
        AssetManager assetManager = MyApplication.getInstance().getAssets();
        try {
            assetManager.open(token + ".json");
        } catch (IOException e) {
            callBack.onError(ErrorService.ERROR_USER);
            return;
        }
        callBack.onSuccess(token);
    }
}

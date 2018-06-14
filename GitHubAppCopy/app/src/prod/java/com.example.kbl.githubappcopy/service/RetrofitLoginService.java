package com.example.kbl.githubappcopy.service;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.kbl.githubappcopy.model.Owner;
import com.example.kbl.githubappcopy.service.enumError.ErrorService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * class who take the online information about repositorie, if the information are received, callback onsuccess, callback onerror else.
 */
public class RetrofitLoginService implements ILoginService {

    public static final String TAG = RetrofitLoginService.class.getSimpleName();

    @Override
    public void checkUser(final String token, final ServiceCallBack<String> callBack) {
        Log.d(TAG, "checkUserRetrofit");
        final RetrofitLoginServiceEndpoint apiService = RetrofitServiceGenerator.createRepositorieService(RetrofitLoginServiceEndpoint.class);

        Call<Owner> call = apiService.getOwner(token);
        call.enqueue(new Callback<Owner>() {
            @Override
            public void onResponse(@NonNull Call<Owner> call, @NonNull Response<Owner> response) {
                Log.d(TAG, "checkUserRetrofit onResponse: " + response.raw());
                if (response.isSuccessful()) {
                    Log.d(TAG, "checkUserRetrofit onResponse: user available");
                    Owner owner = response.body();
                    if(Integer.valueOf(owner.getPublic_repos())>0){
                        callBack.onSuccess(token);
                    } else{
                        callBack.onError(ErrorService.ERROR_EMPTY);
                    }
                } else {
                    Log.d(TAG, "checkUserRetrofit onResponse: user unavailable");
                    if(response.message().equals("Not Found")){
                        callBack.onError(ErrorService.ERROR_USER);
                    }
                    else if(response.message().equals("Forbidden")){
                        callBack.onError(ErrorService.ERROR_REQUEST);
                    }
                    else{
                        callBack.onError(ErrorService.ERROR);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<Owner> call, @NonNull Throwable t) {
                Log.d(TAG, "checkUserRetrofit onFailure: " + t);
                callBack.onError(ErrorService.ERROR_NETWORK);
            }

        });
    }
}

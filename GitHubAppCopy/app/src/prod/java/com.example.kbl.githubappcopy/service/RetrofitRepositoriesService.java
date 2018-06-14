package com.example.kbl.githubappcopy.service;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.kbl.githubappcopy.model.Repositorie;
import com.example.kbl.githubappcopy.service.enumError.ErrorService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * class who take the online information about repositories and use RetrofitServiceGenerator for translate then to a List of Repositorie
 * if the response are correct, callback success, callback error else.
 */
public class RetrofitRepositoriesService implements IRepositoriesService {

    private static final String TAG = RetrofitRepositoriesService.class.getSimpleName();

    @Override
    public void retrieveListRepositories(final String token, final ServiceCallBack<List<Repositorie>> callBack) {
        Log.d(TAG, "retrieveListRepositories");
        final RetrofitRepositoriesServiceEndpoint apiService = RetrofitServiceGenerator.createRepositorieService(RetrofitRepositoriesServiceEndpoint.class);

        Call<List<Repositorie>> call = apiService.listRepos(token);
        call.enqueue(new Callback<List<Repositorie>>() {

            @Override
            public void onResponse(@NonNull Call<List<Repositorie>> call, @NonNull Response<List<Repositorie>> response) {
                Log.d(TAG, "retrieveRetrofit onResponse: " + response.raw());
                if (response.isSuccessful()) {
                    Log.d(TAG, "retrieveRetrofit onResponse: inSuccess");
                    List<Repositorie> repositories = response.body();
                    callBack.onSuccess(repositories);
                } else {
                    Log.d(TAG, "retrieveRetrofit onResponse: user unavailable");
                    callBack.onError(ErrorService.ERROR_LOADER);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Repositorie>> call, @NonNull Throwable t) {
                Log.d(TAG, "retrieveRetrofit onFailure: " + t);
                callBack.onError(ErrorService.ERROR_NETWORK);
            }

        });
    }
}

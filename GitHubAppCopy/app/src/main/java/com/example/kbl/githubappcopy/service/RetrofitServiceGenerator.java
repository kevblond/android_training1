package com.example.kbl.githubappcopy.service;

import com.example.kbl.githubappcopy.model.Repositorie;
import com.example.kbl.githubappcopy.service.converter.RepositoriesDeserializer;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * class used to create a retrofit service for receive net information
 */
public final class RetrofitServiceGenerator {
    private static final String API_REPO_BASE_URL = "https://api.github.com/";
    private static Retrofit.Builder retrofitRepositorieBuilder = new Retrofit.Builder()
            .baseUrl(API_REPO_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(
                    new GsonBuilder().registerTypeAdapter(new TypeToken<List<Repositorie>>() {
                    }.getType(), new RepositoriesDeserializer()).create()
            ));

    private RetrofitServiceGenerator() {
    }

    public static <S> S createRepositorieService(Class<S> serviceClass) {
        Retrofit retrofit = retrofitRepositorieBuilder.client(new OkHttpClient.Builder().build()).build();
        return retrofit.create(serviceClass);
    }
}

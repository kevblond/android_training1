package com.example.kbl.githubappcopy.service;

import com.example.kbl.githubappcopy.model.Repositorie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * class utiliser pour recupérer les informations des repositories en ligne
 */
public interface RetrofitRepositoriesServiceEndpoint {

    @GET("users/{user}/repos")
    Call<List<Repositorie>> listRepos(@Path("user") String user);
}
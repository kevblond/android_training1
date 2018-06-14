package com.example.kbl.githubappcopy.service;

import com.example.kbl.githubappcopy.model.Repositorie;

import java.util.List;

public interface IRepositoriesService {
    void retrieveListRepositories(final String token, final ServiceCallBack<List<Repositorie>> callBack);
}

package com.example.kbl.githubappcopy.service;

public class RepositoriesServiceFactory {
    private RepositoriesServiceFactory() {

    }

    public static IRepositoriesService getRepositoriesService() {
        return new MockedRepositorieService();
    }
}

package com.example.kbl.githubappcopy.service;

public class LoginServiceFactory {
    private LoginServiceFactory() {

    }

    public static RetrofitLoginService getLoginService() {
        return new RetrofitLoginService();
    }
}

package com.example.kbl.githubappcopy.service;

public class LoginServiceFactory {
    private LoginServiceFactory() {

    }

    public static MockedLoginService getLoginService() {
        return new MockedLoginService();
    }
}

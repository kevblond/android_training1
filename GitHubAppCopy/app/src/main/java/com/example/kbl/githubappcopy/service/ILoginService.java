package com.example.kbl.githubappcopy.service;

public interface ILoginService {
    void checkUser(final String token, final ServiceCallBack<String> callBack);
}

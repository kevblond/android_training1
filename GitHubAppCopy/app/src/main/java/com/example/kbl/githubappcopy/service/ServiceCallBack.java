package com.example.kbl.githubappcopy.service;

import com.example.kbl.githubappcopy.service.enumError.ErrorService;

public interface ServiceCallBack<E> {
    void onSuccess(E values);
    void onError(ErrorService errorService);
}

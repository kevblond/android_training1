package com.example.kbl.githubappcopy.presenter;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;

import com.example.kbl.githubappcopy.contract.AbstractContract;
import com.example.kbl.githubappcopy.controller.event.BusProvider;

public abstract class AbstractPresenter<V extends AbstractContract.IView> {

    protected V view;

    AbstractPresenter(@NonNull V view) {
        this.view = view;
    }

    @CallSuper
    public void onCreate() {
        BusProvider.register(this);
    }

    @CallSuper
    public void onDestroy() {
        view = null;
        BusProvider.unregister(this);
    }
}

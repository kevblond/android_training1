package com.example.kbl.a5asecvisu.presenter;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;

import com.example.kbl.a5asecvisu.contract.AbstractContract;


public abstract class AbstractPresenter<V extends AbstractContract.IView> {

    protected V view;

    AbstractPresenter(@NonNull V view) {
        this.view = view;
    }

    @CallSuper
    public void onCreate() {
    }

    @CallSuper
    public void onDestroy() {
        view = null;
    }
}

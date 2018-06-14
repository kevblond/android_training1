package com.example.kbl.a5asecvisu.view.view;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.kbl.a5asecvisu.contract.AbstractContract;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class AbstractActivity<P extends AbstractContract.IPresenter> extends AppCompatActivity implements AbstractContract.IView {

    protected P presenter;

    private Unbinder unbinder;

    ///////////////////////////////////////////////////////////////////////////
    // AbstractContract
    ///////////////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        initView();
        initPresenter();
        willAppear();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.onDestroy();
        }
        unbinder.unbind();
    }

    protected abstract P newPresenter();

    @NonNull
    public P getPresenter() {
        if (presenter == null) {
            return newPresenter();
        } else {
            return presenter;
        }
    }

    /**
     * called after init view and presenter
     */
    protected abstract void willAppear();

    ///////////////////////////////////////////////////////////////////////////
    // Abstract Initialization
    ///////////////////////////////////////////////////////////////////////////
    protected abstract @LayoutRes
    int getContentView();


    /**
     * Initialize the presenter
     */
    protected void initPresenter() {
        presenter = newPresenter();
        if (presenter != null) {
            presenter.onCreate();
        }
    }

    @CallSuper
    protected void initView() {
        // Binding ButterKnife
        unbinder = ButterKnife.bind(this);
    }
}

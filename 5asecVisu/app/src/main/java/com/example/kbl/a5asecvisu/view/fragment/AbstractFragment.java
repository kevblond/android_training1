package com.example.kbl.a5asecvisu.view.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kbl.a5asecvisu.R;
import com.example.kbl.a5asecvisu.contract.AbstractContract;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class AbstractFragment<P extends AbstractContract.IPresenter> extends Fragment implements AbstractContract.IView {

    protected P presenter;

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getContentView(),container,false);
        initView(view);
        initPresenter();
        willAppear();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(presenter!=null){
            presenter.onDestroy();
        }
        unbinder.unbind();
    }

    @CallSuper
    protected void initView(View rootView) {
        // Binding ButterKnife
        unbinder = ButterKnife.bind(this,rootView);
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

    protected abstract void willAppear();

    protected abstract @LayoutRes
    int getContentView();

    protected void initPresenter() {
        presenter = newPresenter();
        if (presenter != null) {
            presenter.onCreate();
        }
    }
}

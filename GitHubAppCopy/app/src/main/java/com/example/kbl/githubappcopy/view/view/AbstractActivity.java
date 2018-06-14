package com.example.kbl.githubappcopy.view.view;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.kbl.githubappcopy.R;
import com.example.kbl.githubappcopy.contract.AbstractContract;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class AbstractActivity<P extends AbstractContract.IPresenter> extends AppCompatActivity implements AbstractContract.IView {

    private static final String TAG = AbstractActivity.class.getSimpleName();

    protected P presenter;

    ProgressDialog progressDiag;

    AlertDialog alertDialog;

    private Unbinder unbinder;


    ///////////////////////////////////////////////////////////////////////////
    // Loader
    ///////////////////////////////////////////////////////////////////////////
    @Override
    public void showLoader() {
        Log.d(TAG, "showLoader");
        if(progressDiag==null){
            initProgressDiag();
        }
        progressDiag.show(); // Display Progress Dialog
    }

    private void initProgressDiag() {
        progressDiag = new ProgressDialog(this);
        progressDiag.setMessage("Loading...");
        progressDiag.setTitle("Loading Repositories"); // Setting Title
        progressDiag.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
        progressDiag.setCancelable(false);
    }

    @Override
    public void hideLoader() {
        Log.d(TAG, "hideLoader");
        progressDiag.cancel();
    }

    ///////////////////////////////////////////////////////////////////////////
    // Error Popup
    ///////////////////////////////////////////////////////////////////////////
    @Override
    public void showMessage(@NonNull String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(AbstractActivity.this);
        builder.setCancelable(true);
        builder.setTitle(R.string.error);
        builder.setMessage(message);
        builder.setNegativeButton(R.string.back, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alertDialog = builder.create();
        alertDialog.show();
    }

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
        Log.d(TAG, "onDestroy");
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
        Log.d(TAG, "initPresenter");
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

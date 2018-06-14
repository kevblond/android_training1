package com.example.kbl.githubappcopy.contract;

import android.support.annotation.NonNull;

public interface AbstractContract {

    interface IView {
        void showLoader();

        void hideLoader();

        void showMessage(@NonNull String message);
    }

    interface IPresenter {
        void onCreate();

        void onDestroy();
    }
}

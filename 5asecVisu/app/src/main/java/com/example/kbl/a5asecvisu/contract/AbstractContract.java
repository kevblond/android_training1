package com.example.kbl.a5asecvisu.contract;

public interface AbstractContract {
    interface IView {
    }
    interface IPresenter {
        void onCreate();

        void onDestroy();
    }
}

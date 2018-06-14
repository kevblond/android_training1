package com.example.kbl.githubappcopy.contract;

public interface LoginContract {
    interface View extends AbstractContract.IView {
        void goListScreen(String userName);
    }

    interface Presenter extends AbstractContract.IPresenter {
        void checkUser(String userName);
    }
}

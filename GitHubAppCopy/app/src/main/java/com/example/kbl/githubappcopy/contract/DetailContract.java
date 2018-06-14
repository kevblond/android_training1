package com.example.kbl.githubappcopy.contract;


import com.example.kbl.githubappcopy.presenter.VO.RepositorieVO;

public interface DetailContract {
    interface View extends AbstractContract.IView {
        void displayRepositorie(RepositorieVO repositorieVO);
    }

    interface Presenter extends AbstractContract.IPresenter {
        void getRepositorie(RepositorieVO repositorieVO);
    }
}

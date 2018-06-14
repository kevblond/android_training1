package com.example.kbl.githubappcopy.contract;

import android.support.annotation.NonNull;

import com.example.kbl.githubappcopy.presenter.VO.RepositorieVO;

import java.util.List;

public interface MainContract {
    interface View extends AbstractContract.IView {
        void displayRespositories(@NonNull final List<RepositorieVO> repos);
    }

    interface Presenter extends AbstractContract.IPresenter {
        void getListRepositories(String userName,boolean forceUpdate);
    }
}

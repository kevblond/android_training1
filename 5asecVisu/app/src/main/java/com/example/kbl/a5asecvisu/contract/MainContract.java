package com.example.kbl.a5asecvisu.contract;

import com.example.kbl.a5asecvisu.presenter.VO.HomeVO;

public interface MainContract {
    interface View extends AbstractContract.IView {
        void displayHome(HomeVO homeVO);
    }

    interface Presenter extends AbstractContract.IPresenter {
        void loadHome();
    }
}
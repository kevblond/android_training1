package com.example.kbl.a5asecvisu.contract;

import com.example.kbl.a5asecvisu.presenter.VO.AlertVO;

import java.util.List;

public interface ProfilContract {
    interface View extends AbstractContract.IView {
        void displayProfil(List<AlertVO> profilVO);
    }

    interface Presenter extends AbstractContract.IPresenter {
        void loadProfil();
    }
}
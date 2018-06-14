package com.example.kbl.a5asecvisu.contract;

import com.example.kbl.a5asecvisu.presenter.VO.HistoryVO;
import com.example.kbl.a5asecvisu.presenter.VO.HomeVO;

import java.util.List;

public interface HistoryContract {
    interface View extends AbstractContract.IView {
        void displayHistory(HomeVO homeVO, List<HistoryVO> historyVO);
    }

    interface Presenter extends AbstractContract.IPresenter {
        void loadHistory();
    }
}
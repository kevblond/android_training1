package com.example.kbl.a5asecvisu.contract;

import com.example.kbl.a5asecvisu.presenter.VO.HistoryDetailVO;
import com.example.kbl.a5asecvisu.presenter.VO.HistoryVO;

import java.util.List;

public interface HistoryPriceFragmentContract {
    interface View extends AbstractContract.IView {
        void displayHistory(List<HistoryDetailVO> historyVO);
    }

    interface Presenter extends AbstractContract.IPresenter {
        void loadHistory();
    }
}
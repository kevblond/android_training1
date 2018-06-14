package com.example.kbl.a5asecvisu.presenter;

import android.support.annotation.NonNull;

import com.example.kbl.a5asecvisu.contract.HistoryPriceFragmentContract;
import com.example.kbl.a5asecvisu.presenter.VO.HistoryDetailVO;

import java.util.ArrayList;
import java.util.List;

public class HistoryPriceFragmentPresenter extends AbstractPresenter<HistoryPriceFragmentContract.View> implements HistoryPriceFragmentContract.Presenter {

    public HistoryPriceFragmentPresenter(@NonNull HistoryPriceFragmentContract.View view) {
        super(view);
    }

    @Override
    public void loadHistory() {
        List<HistoryDetailVO> listHistoryVO = new ArrayList<>();

        HistoryDetailVO historyDetailVO = new HistoryDetailVO();
        historyDetailVO.setName("Pantalon");
        historyDetailVO.setSolde(String.valueOf(24));
        historyDetailVO.setCountry("ue");
        listHistoryVO.add(historyDetailVO);

        historyDetailVO = new HistoryDetailVO();
        historyDetailVO.setName("Manteau");
        historyDetailVO.setSolde(String.valueOf(30));
        historyDetailVO.setCountry("ue");
        listHistoryVO.add(historyDetailVO);

        historyDetailVO = new HistoryDetailVO();
        historyDetailVO.setName("Gant");
        historyDetailVO.setSolde(String.valueOf(150));
        historyDetailVO.setCountry("ue");
        listHistoryVO.add(historyDetailVO);

        historyDetailVO = new HistoryDetailVO();
        historyDetailVO.setName("Botte");
        historyDetailVO.setSolde(String.valueOf(4));
        historyDetailVO.setCountry("ue");
        listHistoryVO.add(historyDetailVO);

        view.displayHistory(listHistoryVO);
    }
}

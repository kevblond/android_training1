package com.example.kbl.a5asecvisu.presenter;

import android.support.annotation.NonNull;

import com.example.kbl.a5asecvisu.R;
import com.example.kbl.a5asecvisu.contract.HistoryContract;
import com.example.kbl.a5asecvisu.presenter.VO.HistoryDetailVO;
import com.example.kbl.a5asecvisu.presenter.VO.HistoryVO;
import com.example.kbl.a5asecvisu.presenter.VO.HomeVO;
import com.example.kbl.a5asecvisu.utils.RessourceUtils;

import java.util.ArrayList;
import java.util.List;

public class HistoryPresenter extends AbstractPresenter<HistoryContract.View> implements HistoryContract.Presenter {

    public HistoryPresenter(@NonNull HistoryContract.View view) {
        super(view);
    }

    @Override
    public void loadHistory() {
        List<HistoryVO> listHistoryVO = new ArrayList<>();
        HomeVO homeVO = new HomeVO();
        for (int i = 0; i < 3; i++) {
            HistoryVO historyVO = new HistoryVO();
            historyVO.setLocation("Paris Saint Charles");
            historyVO.setDate("23.11.2017" + " " + "11:18");
            historyVO.setCountry("ue");
            historyVO.setNumberTicket(String.valueOf(91736+i));
            historyVO.setNumberShop("FR9565");
            historyVO.setListDetail(setDetailVO(historyVO));
            listHistoryVO.add(historyVO);
        }
        homeVO.setBalanceSolde("175");
        homeVO.setBalanceCountry("ue");
        homeVO.setBalanceDate(RessourceUtils.getString(R.string.home_balance_date) + " " + "28.11.2017");
        view.displayHistory(homeVO, listHistoryVO);
    }

    private List<HistoryDetailVO> setDetailVO(HistoryVO historyVO) {
        List<HistoryDetailVO> historyDetailVOList = new ArrayList<>();
        historyVO.setSolde("0");

        HistoryDetailVO historyDetailVO = new HistoryDetailVO();
        historyDetailVO.setName("Pantalon");
        historyDetailVO.setSolde(String.valueOf(24));
        historyVO.setSolde(String.valueOf(Integer.valueOf(historyVO.getSolde())+Integer.valueOf(historyDetailVO.getSolde())));
        historyDetailVO.setCountry("ue");
        historyDetailVOList.add(historyDetailVO);

        historyDetailVO = new HistoryDetailVO();
        historyDetailVO.setName("Pantalon");
        historyDetailVO.setSolde(String.valueOf(24));
        historyVO.setSolde(String.valueOf(Integer.valueOf(historyVO.getSolde())+Integer.valueOf(historyDetailVO.getSolde())));
        historyDetailVO.setCountry("ue");
        historyDetailVOList.add(historyDetailVO);

        historyDetailVO = new HistoryDetailVO();
        historyDetailVO.setName("Manteau");
        historyDetailVO.setSolde(String.valueOf(30));
        historyVO.setSolde(String.valueOf(Integer.valueOf(historyVO.getSolde())+Integer.valueOf(historyDetailVO.getSolde())));
        historyDetailVO.setCountry("ue");
        historyDetailVOList.add(historyDetailVO);

        return historyDetailVOList;
    }
}

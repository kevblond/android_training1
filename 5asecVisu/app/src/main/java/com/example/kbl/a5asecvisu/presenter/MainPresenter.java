package com.example.kbl.a5asecvisu.presenter;

import android.support.annotation.NonNull;

import com.example.kbl.a5asecvisu.R;
import com.example.kbl.a5asecvisu.contract.MainContract;
import com.example.kbl.a5asecvisu.presenter.VO.HomeVO;
import com.example.kbl.a5asecvisu.utils.RessourceUtils;

public class MainPresenter extends AbstractPresenter<MainContract.View> implements MainContract.Presenter {

    public MainPresenter(@NonNull MainContract.View view) {
        super(view);
    }

    @Override
    public void loadHome() {
        HomeVO homeVO = new HomeVO();

        homeVO.setBalanceSolde("175");
        homeVO.setBalanceCountry("ue");
        homeVO.setBalanceDate(RessourceUtils.getString(R.string.home_balance_date)+" "+"28.11.2017");
        homeVO.setOrderNumber("commande #27654");
        homeVO.setOrderState("En cours");
        homeVO.setOrderDate("16.DEC - 14h");
        homeVO.setAdressDetail1("paris saint charles");
        homeVO.setAdressDetail2("96 Rue Saint Charles");
        homeVO.setAdressDetail3("75015 paris");
        homeVO.setAdressDetail4("0140598127");
        homeVO.setAdressOpen("ouvert");
        view.displayHome(homeVO);
    }
}

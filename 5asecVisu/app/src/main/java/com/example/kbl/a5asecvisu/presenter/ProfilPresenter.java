package com.example.kbl.a5asecvisu.presenter;

import android.support.annotation.NonNull;

import com.example.kbl.a5asecvisu.contract.ProfilContract;
import com.example.kbl.a5asecvisu.presenter.VO.AlertVO;

import java.util.ArrayList;
import java.util.List;

public class ProfilPresenter extends AbstractPresenter<ProfilContract.View> implements ProfilContract.Presenter {

    public ProfilPresenter(@NonNull ProfilContract.View view) {
        super(view);
    }

    @Override
    public void loadProfil() {
        List<AlertVO> alerteVOList = new ArrayList<>();
        List<String> alerte = new ArrayList<>();
        alerte.add("Prestation terminée");
        alerte.add("Prestation en retard");
        alerte.add("Solde insuffisant");
        for(int i=0;i<3;i++){
            AlertVO alerteVO = new AlertVO();
            alerteVO.setAlerte(alerte.get(i));
            alerteVO.setCheckbox(i%2==0);
            alerteVOList.add(alerteVO);
        }
        view.displayProfil(alerteVOList);
    }
}

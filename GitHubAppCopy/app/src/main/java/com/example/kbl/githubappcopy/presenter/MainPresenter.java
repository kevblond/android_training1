package com.example.kbl.githubappcopy.presenter;


import android.util.Log;

import com.example.kbl.githubappcopy.contract.MainContract;
import com.example.kbl.githubappcopy.controller.RepositorieController;
import com.example.kbl.githubappcopy.controller.event.ListRepositoriesEvent;
import com.example.kbl.githubappcopy.controller.event.RepositorieFailEvent;
import com.example.kbl.githubappcopy.model.Repositorie;
import com.example.kbl.githubappcopy.model.mapper.MapperRepositorieToRepositorieVO;
import com.example.kbl.githubappcopy.presenter.VO.RepositorieVO;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * presenter of the MainActivity
 */
public class MainPresenter extends AbstractPresenter<MainContract.View> implements MainContract.Presenter {
    public static final String TAG = MainPresenter.class.getSimpleName();

    public MainPresenter(MainContract.View view) {
        super(view);
    }

    ///////////////////////////////////////////////////////////////////////////
    // MainContract.Presenter
    ///////////////////////////////////////////////////////////////////////////
    @Override
    public void getListRepositories(String userName,boolean forceUpdate) {
        view.showLoader();
        RepositorieController.getInstance().retrieveRepositories(userName,forceUpdate);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Bus events
    ///////////////////////////////////////////////////////////////////////////
    @Subscribe
    public void onRepositoriesLoaded(final ListRepositoriesEvent event) {
        Log.d(TAG,"onRepositoriesLoaded");
        List<Repositorie> listRepEvent = event.getListRepositories();
        List<RepositorieVO> listRepositories = new ArrayList<>();
        MapperRepositorieToRepositorieVO mapper = new MapperRepositorieToRepositorieVO();

        for (Repositorie rep : listRepEvent) {
            listRepositories.add(mapper.map(rep));
        }
        if(view!=null){
            view.hideLoader();
            view.displayRespositories(listRepositories);
        }
    }

    @Subscribe
    public void onRepositoriesFailed(final RepositorieFailEvent event){
        view.hideLoader();
        view.showMessage(event.getMessage());
    }

}

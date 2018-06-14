package com.example.kbl.githubappcopy.presenter;

import android.util.Log;

import com.example.kbl.githubappcopy.contract.DetailContract;
import com.example.kbl.githubappcopy.controller.RepositorieController;
import com.example.kbl.githubappcopy.controller.event.RepositorieDetailEvent;
import com.example.kbl.githubappcopy.controller.event.RepositorieFailEvent;
import com.example.kbl.githubappcopy.model.Repositorie;
import com.example.kbl.githubappcopy.model.mapper.MapperRepositorieToDetailRepositorieVO;
import com.example.kbl.githubappcopy.presenter.VO.DetailRepositorieVO;
import com.example.kbl.githubappcopy.presenter.VO.RepositorieVO;
import com.squareup.otto.Subscribe;

/**
 * presenter of the DetailActivity
 */
public class DetailPresenter extends AbstractPresenter<DetailContract.View> implements DetailContract.Presenter {
    public static final String TAG = DetailPresenter.class.getSimpleName();

    private DetailRepositorieVO repositorieVO;
    private MapperRepositorieToDetailRepositorieVO mapper;

    public DetailPresenter(DetailContract.View view) {
        super(view);
    }

    ///////////////////////////////////////////////////////////////////////////
    // DetailContract.Presenter
    ///////////////////////////////////////////////////////////////////////////
    @Override
    public void getRepositorie(RepositorieVO repositorieVO) {
        view.displayRepositorie(repositorieVO);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Bus events
    ///////////////////////////////////////////////////////////////////////////
//    @Subscribe
//    public void onRepositoriesLoaded(final RepositorieDetailEvent event) {
//        Log.d(TAG, "onRepositoriesLoaded");
//        Repositorie repEvent = event.getRepositorie();
//        mapper = new MapperRepositorieToDetailRepositorieVO();
//
//        DetailRepositorieVO detailRepositorieVO = mapper.map(repEvent);
//        if (view != null) {
//            view.hideLoader();
//            view.displayRepositorie(detailRepositorieVO);
//        }
//    }
//
//    @Subscribe
//    public void onRepositoriesFailed(final RepositorieFailEvent event) {
//        Log.d(TAG, "onRepositoriesLoaded");
//        if (view != null) {
//            view.hideLoader();
//            view.showMessage("erreur dans le chargement du repertoire");
//        }
//    }
}

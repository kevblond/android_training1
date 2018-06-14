package com.example.kbl.githubappcopy.controller;

import android.util.Log;

import com.example.kbl.githubappcopy.R;
import com.example.kbl.githubappcopy.controller.event.BusProvider;
import com.example.kbl.githubappcopy.controller.event.ListRepositoriesEvent;
import com.example.kbl.githubappcopy.controller.event.RepositorieFailEvent;
import com.example.kbl.githubappcopy.model.Repositorie;
import com.example.kbl.githubappcopy.model.dao.Criteria;
import com.example.kbl.githubappcopy.model.dao.RepositorieDAO;
import com.example.kbl.githubappcopy.service.IRepositoriesService;
import com.example.kbl.githubappcopy.service.RepositoriesServiceFactory;
import com.example.kbl.githubappcopy.service.ServiceCallBack;
import com.example.kbl.githubappcopy.service.enumError.ErrorService;
import com.example.kbl.githubappcopy.utils.RessourceUtils;

import java.util.List;

public class RepositorieController implements IRepositorieController {

    private static final String TAG = RepositorieController.class.getSimpleName();

    /**
     * private constructor
     */
    private RepositorieController() {
    }

    public static RepositorieController getInstance() {
        return SingletonHolder.instance;
    }

    /**
     * return the user's list of repositories, onSuccess if the list exist, onError else
     *
     * @param userName name of the user
     */
    @Override
    public void retrieveRepositories(String userName,boolean forceUpdate) {
        Log.d(TAG, "retrieveRepositories");
        final RepositorieDAO repositorieDAO = new RepositorieDAO();
        final ListRepositoriesEvent event = new ListRepositoriesEvent();
        final List<Repositorie> listRecupFromBase;
        //rechercher dans base
        Criteria<String> criteria = new Criteria<>();
        criteria.setField("owner.login");
        criteria.setValue(userName);
        listRecupFromBase = repositorieDAO.find(criteria);
        if(forceUpdate){
            downloadNetAndUploadBase(event,repositorieDAO,userName,listRecupFromBase);
        } else {
            if (listRecupFromBase == null || listRecupFromBase.size() == 0) {
                downloadNetAndUploadBase(event,repositorieDAO, userName,listRecupFromBase);
            } else {
                Log.d(TAG, "downloadBase");
                event.setListRepositories(listRecupFromBase);
                BusProvider.getInstance().post(event);
            }
        }

    }

    /**
     * download from net the information of repositories, and upload them on our base
     *
     * @param repositorieDAO class DAO used for instruction to the base
     * @param userName       owner's name of the repositories used to find his list of repositories
     */
    private void downloadNetAndUploadBase(final ListRepositoriesEvent event,final RepositorieDAO repositorieDAO, String userName,final List<Repositorie> listRecupFromBase) {
        Log.d(TAG, "downloadNet");
        IRepositoriesService service = RepositoriesServiceFactory.getRepositoriesService();
        service.retrieveListRepositories(userName, new ServiceCallBack<List<Repositorie>>() {
            @Override
            public void onSuccess(List<Repositorie> values) {
                Log.d(TAG, "retrieveRepo on Success");
                //supprime de la base les anciens repositories
                if(listRecupFromBase!=null){
                    for(Repositorie repoBase : listRecupFromBase){
                        if(!values.contains(repoBase)){
                            repositorieDAO.delete(repoBase.getId());
                        }
                    }
                }
                //ajouter à la base
                for (Repositorie repositorie : values) {
                    repositorieDAO.insertOrUpdate(repositorie);
                }
                event.setListRepositories(values);
                BusProvider.getInstance().post(event);
            }

            @Override
            public void onError(ErrorService errorService) {
                Log.d(TAG, "retrieveRepo on Error");
                RepositorieFailEvent event = new RepositorieFailEvent();
                switch (errorService) {
                    case ERROR_NETWORK:
                        event.setMessage(RessourceUtils.getResources().getString(R.string.error_network));
                        break;
                    case ERROR_USER:
                        event.setMessage(RessourceUtils.getResources().getString(R.string.error_login));
                        break;
                    case ERROR_LOADER:
                        event.setMessage(RessourceUtils.getResources().getString(R.string.error_load_data));
                        break;
                    default:
                        break;
                }
                BusProvider.post(event);
            }
        });
    }

    private static class SingletonHolder {
        private final static RepositorieController instance = new RepositorieController();
    }
}

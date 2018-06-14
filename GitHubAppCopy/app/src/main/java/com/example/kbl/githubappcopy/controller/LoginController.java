package com.example.kbl.githubappcopy.controller;

import android.util.Log;

import com.example.kbl.githubappcopy.R;
import com.example.kbl.githubappcopy.controller.event.BusProvider;
import com.example.kbl.githubappcopy.controller.event.LoginFailedEvent;
import com.example.kbl.githubappcopy.controller.event.LoginSucceededEvent;
import com.example.kbl.githubappcopy.model.Repositorie;
import com.example.kbl.githubappcopy.model.dao.Criteria;
import com.example.kbl.githubappcopy.model.dao.RepositorieDAO;
import com.example.kbl.githubappcopy.service.ILoginService;
import com.example.kbl.githubappcopy.service.LoginServiceFactory;
import com.example.kbl.githubappcopy.service.ServiceCallBack;
import com.example.kbl.githubappcopy.service.enumError.ErrorService;
import com.example.kbl.githubappcopy.utils.RessourceUtils;

import java.util.List;

public class LoginController implements ILoginController {

    private static final String TAG = LoginController.class.getSimpleName();

    private LoginController() {

    }

    /**
     * Singleton instance
     *
     * @return instance of LoginController
     */
    public static LoginController getInstance() {
        return SingletonHolder.instance;
    }

    /**
     * called for checking the entered user login, onSuccess if the user existe, onError else
     *
     * @param userName user login entered
     */
    @Override
    public void checkUser(final String userName) {
        Log.d(TAG, "retrieveRepositories");
        final RepositorieDAO repositorieDAO = new RepositorieDAO();
        LoginSucceededEvent event = new LoginSucceededEvent();
        List<Repositorie> listRecupBase;
        //rechercher dans base
        Criteria<String> criteria = new Criteria<>();
        criteria.setField("owner.login");
        criteria.setValue(userName);
        listRecupBase = repositorieDAO.find(criteria);
        if (listRecupBase == null || listRecupBase.size() == 0) {
            checkUserOnline(userName);
        } else {
            Log.d(TAG, "downloadBase");
            event.setUserName(userName);
            BusProvider.post(event);
        }
        /////////////////////////////////////////////////////////
    }

    private void checkUserOnline(String userName) {
        Log.d(TAG, "check User Online");
        ILoginService service = LoginServiceFactory.getLoginService();
        service.checkUser(userName, new ServiceCallBack<String>() {
            @Override
            public void onSuccess(String userName) {
                Log.d(TAG, "check User on Success");
                LoginSucceededEvent event = new LoginSucceededEvent();
                event.setUserName(userName);
                BusProvider.post(event);
            }

            @Override
            public void onError(ErrorService errorService) {
                Log.d(TAG, "check User on Error");
                LoginFailedEvent event = new LoginFailedEvent();
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
                    case ERROR_EMPTY:
                        event.setMessage(RessourceUtils.getResources().getString(R.string.error_empty));
                        break;
                    case ERROR_REQUEST:
                        event.setMessage(RessourceUtils.getResources().getString(R.string.error_request));
                        break;
                    case ERROR:
                        event.setMessage(RessourceUtils.getResources().getString(R.string.error));
                        break;
                    default:
                        break;
                }
                BusProvider.post(event);
            }
        });
    }


    private static class SingletonHolder {
        private final static LoginController instance = new LoginController();
    }
}

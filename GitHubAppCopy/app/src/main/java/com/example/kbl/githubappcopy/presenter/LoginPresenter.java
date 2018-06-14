package com.example.kbl.githubappcopy.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.kbl.githubappcopy.contract.LoginContract;
import com.example.kbl.githubappcopy.controller.ILoginController;
import com.example.kbl.githubappcopy.controller.LoginController;
import com.example.kbl.githubappcopy.controller.event.LoginFailedEvent;
import com.example.kbl.githubappcopy.controller.event.LoginSucceededEvent;
import com.squareup.otto.Subscribe;

/**
 * presenter of the LoginActivity
 */
public class LoginPresenter extends AbstractPresenter<LoginContract.View> implements LoginContract.Presenter {
    public static final String TAG = LoginPresenter.class.getSimpleName();


    public LoginPresenter(@NonNull LoginContract.View view) {
        super(view);
    }

    ///////////////////////////////////////////////////////////////////////////
    // LoginContract.Presenter
    ///////////////////////////////////////////////////////////////////////////
    @Override
    public void checkUser(String userName) {
        Log.d(TAG,"checkUser " + userName);
        if(view!=null){
            view.showLoader();
        }
        ILoginController loginController = LoginController.getInstance();
        loginController.checkUser(userName);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Bus event
    ///////////////////////////////////////////////////////////////////////////


    @Subscribe
    public void onUserInfosSucceededEventReceived(LoginSucceededEvent event) {
        Log.d(TAG,"onuserinfosucceeded");
        if (view != null) {
            view.hideLoader();
            view.goListScreen(event.getUserName());
        }
    }

    @Subscribe
    public void onUserInfosFailedEventReceived(LoginFailedEvent event) {
        Log.d(TAG,"onuserinfofailed");
        if (view != null) {
            view.hideLoader();
            view.showMessage(event.getMessage());
        }
    }
}

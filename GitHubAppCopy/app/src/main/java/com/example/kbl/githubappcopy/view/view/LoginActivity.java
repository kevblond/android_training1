package com.example.kbl.githubappcopy.view.view;

import android.content.Intent;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Button;

import com.example.kbl.githubappcopy.R;
import com.example.kbl.githubappcopy.contract.LoginContract;
import com.example.kbl.githubappcopy.presenter.LoginPresenter;

import butterknife.BindView;

public class LoginActivity extends AbstractActivity<LoginContract.Presenter> implements LoginContract.View {


    ///////////////////////////////////////////////////////////////////////////
    // Initialization
    ///////////////////////////////////////////////////////////////////////////
    @BindView(R.id.button_validate)
    Button buttonValidate;
    @BindView(R.id.user_name)
    SearchView searchView;

    @Override
    protected int getContentView() {
        return R.layout.login_activity;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected LoginContract.Presenter newPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected void willAppear() {
        //show most recent user login
        Intent intent = getIntent();
        //activer le champ de recherche
        searchView.setActivated(true);
        searchView.onActionViewExpanded();
        //ajouter un titre de recherche
        searchView.setQueryHint(getString(R.string.edit_user_name));
        //ajouter le dernier utilisateur recherché si present
        if (intent.hasExtra(Intent.EXTRA_TEXT)) {
            searchView.setQuery(intent.getStringExtra(Intent.EXTRA_TEXT),false);
        }

        //bouton rechercher
        buttonValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                supprime les possible requete avec des espaces seulement
                String query = searchView.getQuery().toString().trim();
                if(!query.isEmpty())
                {
                    getPresenter().checkUser(query);
                }
            }
        });
        //listener de la touche entrer et du changement le texte
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                getPresenter().checkUser(searchView.getQuery().toString());
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    ///////////////////////////////////////////////////////////////////////////
    // LoginContract.View
    ///////////////////////////////////////////////////////////////////////////
    public void goListScreen(String userName) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, userName);
        startActivity(intent);
    }
}

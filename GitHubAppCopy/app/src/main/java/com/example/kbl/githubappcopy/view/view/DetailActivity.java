package com.example.kbl.githubappcopy.view.view;

import android.util.Log;
import android.view.MenuItem;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kbl.githubappcopy.R;
import com.example.kbl.githubappcopy.contract.DetailContract;
import com.example.kbl.githubappcopy.presenter.DetailPresenter;
import com.example.kbl.githubappcopy.presenter.VO.RepositorieVO;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import butterknife.BindView;

public class DetailActivity extends AbstractActivity<DetailContract.Presenter> implements DetailContract.View {

    private static final String TAG = DetailActivity.class.getSimpleName();

    ///////////////////////////////////////////////////////////////////////////
    // Initialization
    ///////////////////////////////////////////////////////////////////////////
    @BindView(R.id.avatar_url)
    ImageView imageView;
    @BindView(R.id.description_text)
    TextView textView;

    @Override
    protected int getContentView() {
        return R.layout.detail_activity;
    }

    @Override
    protected void initView() {
        super.initView();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected DetailContract.Presenter newPresenter() {
        return new DetailPresenter(this);
    }

    @Override
    protected void willAppear() {
        Log.d(TAG, "willApear");
        RepositorieVO repositorieVO = (RepositorieVO) getIntent().getExtras().get("RepositorieVO");
        getPresenter().getRepositorie(repositorieVO);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Application's Return
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        this.finish();
    }

    ///////////////////////////////////////////////////////////////////////////
    // DetailContract.View
    ///////////////////////////////////////////////////////////////////////////
    @Override
    public void displayRepositorie(RepositorieVO repositorieVO) {
        Log.d(TAG, "displayRepositorie");
        setTitle(repositorieVO.getFullName());
        //recherche de l'image et binding
        RequestCreator requestCreator = Picasso.get().load(repositorieVO.getAvatarUrl());
        requestCreator.into(imageView);
        ViewParent viewParent = imageView.getParent();
        imageView.setAdjustViewBounds(true);
        textView.setText(repositorieVO.getDescription());
    }


}

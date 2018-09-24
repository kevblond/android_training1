package com.example.kbl.githubappcopy.view.view;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.MenuItem;

import com.example.kbl.githubappcopy.R;
import com.example.kbl.githubappcopy.contract.MainContract;
import com.example.kbl.githubappcopy.presenter.MainPresenter;
import com.example.kbl.githubappcopy.presenter.VO.RepositorieVO;
import com.example.kbl.githubappcopy.view.adapter.CellAdapter;
import com.example.kbl.githubappcopy.view.clickDelegate.OnClickItemDelegate;
import com.example.kbl.githubappcopy.view.divider.DividerFinal;
import com.example.kbl.githubappcopy.view.viewHolder.GitViewHolder;

import java.util.List;

import butterknife.BindView;

public class MainActivity extends AbstractActivity<MainContract.Presenter> implements MainContract.View, OnClickItemDelegate {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.swipe_container)
    SwipeRefreshLayout swipeRefreshLayout;

    RecyclerView.LayoutManager mLayoutManager;

    String userName;

    CellAdapter adapter;


    ///////////////////////////////////////////////////////////////////////////
    // Initialization
    ///////////////////////////////////////////////////////////////////////////

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //titre
        userName = getIntent().getStringExtra(Intent.EXTRA_TEXT);
        setTitle(userName);

        //initialization recyclerView
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        DividerFinal itemDecoration = new DividerFinal(Color.BLACK,20);
        recyclerView.addItemDecoration(itemDecoration);

//        recyclerView.setItemAnimator(new SlideInLeftAnimator());

        adapter = new CellAdapter(this);
        adapter.setOnClickItemDelegate(this);

        //set clickItemDelegate adapter to RecyclerView
        recyclerView.setAdapter(adapter);
        //adapter for each element
        createSwipeAndDelete(adapter);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().getListRepositories(userName,true);
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        swipeRefreshLayout.setColorSchemeColors(Color.BLACK);
    }

    @Override
    protected MainContract.Presenter newPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void willAppear() {
        //list call to presenter
        getPresenter().getListRepositories(userName,false);
    }

    ///////////////////////////////////////////////////////////////////////////
    // MainContract.View
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public void displayRespositories(@NonNull final List<RepositorieVO> listRepositories) {
        adapter.setCells(listRepositories);
    }

    private void createSwipeAndDelete(final CellAdapter adapter) {
        ItemTouchHelper.SimpleCallback itemTouchHelperCallBack = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }


            //swipe and delete
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                if (viewHolder instanceof GitViewHolder) {
                    adapter.removeItem(viewHolder.getAdapterPosition());
                }
            }
        };
        //attach swipe and delete adapter to RecyclerView
        new ItemTouchHelper(itemTouchHelperCallBack).attachToRecyclerView(recyclerView);
    }

    ///////////////////////////////////////////////////////////////////////////
    // OnClickItemDelegate
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public void onClickItem(RepositorieVO item) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        item.setWatchers(item.getWatchers() + 1);
        intent.putExtra("RepositorieVO", item);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return false;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Application's Return
    ///////////////////////////////////////////////////////////////////////////
    @Override
    public void onBackPressed() {
        //conservation of recent user
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, userName);
        startActivity(intent);
    }

}

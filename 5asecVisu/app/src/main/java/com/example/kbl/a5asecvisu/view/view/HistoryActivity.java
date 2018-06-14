package com.example.kbl.a5asecvisu.view.view;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.kbl.a5asecvisu.R;
import com.example.kbl.a5asecvisu.contract.HistoryContract;
import com.example.kbl.a5asecvisu.presenter.HistoryPresenter;
import com.example.kbl.a5asecvisu.presenter.VO.HistoryVO;
import com.example.kbl.a5asecvisu.presenter.VO.HomeVO;
import com.example.kbl.a5asecvisu.utils.RessourceUtils;
import com.example.kbl.a5asecvisu.view.adapter.HistoryAdapter;
import com.example.kbl.a5asecvisu.view.adapter.HistoryViewPagerAdapter;
import com.example.kbl.a5asecvisu.view.fragment.HistoryFragment;
import com.example.kbl.a5asecvisu.view.fragment.ListPriceFragment;

import java.util.List;

import butterknife.BindView;

public class HistoryActivity extends AbstractActivity<HistoryContract.Presenter> implements HistoryContract.View {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.home_balance_value)
    TextView balanceValue;
    @BindView(R.id.home_balance_country)
    TextView balanceContry;
    @BindView(R.id.home_balance_date)
    TextView balanceDate;
//    @BindView(R.id.history_bottom_contact)
//    TextView historyContact;
    @BindView(R.id.history_viewpager)
    ViewPager viewPager;
    @BindView(R.id.history_title)
    TabLayout titlePager;

    @Override
    protected void initView() {
        super.initView();

        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        getSupportActionBar().setLogo(R.drawable.toolbar_title);

//        historyContact.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                launchNextActivity();
//            }
//        });


        HistoryViewPagerAdapter adapter = new HistoryViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new HistoryFragment(), RessourceUtils.getString(R.string.history_recycler_histories_title));
        adapter.addFrag(new ListPriceFragment(), RessourceUtils.getString(R.string.history_recycler_price_title));
        viewPager.setAdapter(adapter);

        titlePager.setupWithViewPager(viewPager);

    }

    @Override
    protected void willAppear() {
        getPresenter().loadHistory();
    }

    @Override
    public void displayHistory(HomeVO homeVO, List<HistoryVO> listHistoryVO) {
        balanceValue.setText(homeVO.getBalanceSolde());
        balanceContry.setText(homeVO.getBalanceCountry());
        balanceDate.setText(homeVO.getBalanceDate());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_history,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        launchNextActivity();
        return true;
    }

    @Override
    protected HistoryContract.Presenter newPresenter() {
        return new HistoryPresenter(this);
    }

    @Override
    protected int getContentView() {
        return R.layout.history_activity;
    }

    private void launchNextActivity() {
        Intent intent = new Intent(HistoryActivity.this,MainActivity.class);
        startActivity(intent);
    }
}

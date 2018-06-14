package com.example.kbl.a5asecvisu.view.fragment;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.kbl.a5asecvisu.R;
import com.example.kbl.a5asecvisu.contract.HistoryPriceFragmentContract;
import com.example.kbl.a5asecvisu.presenter.HistoryPriceFragmentPresenter;
import com.example.kbl.a5asecvisu.presenter.VO.HistoryDetailVO;
import com.example.kbl.a5asecvisu.view.adapter.HistoryDetailAdapter;
import com.example.kbl.a5asecvisu.view.view.divider.DividerAlerte;

import java.util.List;

import butterknife.BindView;

public class ListPriceFragment extends AbstractFragment<HistoryPriceFragmentContract.Presenter> implements HistoryPriceFragmentContract.View  {


    @BindView(R.id.history_price_recyclerview)
    RecyclerView recyclerView;

    private RecyclerView.LayoutManager layoutManager;
    private HistoryDetailAdapter historyDetailAdapter;


    @Override
    protected HistoryPriceFragmentContract.Presenter newPresenter() {
        return new HistoryPriceFragmentPresenter(this);
    }

    @Override
    protected void initView(View rootView) {
        super.initView(rootView);
        recyclerView.addItemDecoration(new DividerAlerte(Color.BLACK,1,false,false));
        recyclerView.setNestedScrollingEnabled(false);

        layoutManager = new LinearLayoutManager(rootView.getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        historyDetailAdapter = new HistoryDetailAdapter();
        recyclerView.setAdapter(historyDetailAdapter);
    }

    @Override
    protected void willAppear() {
        getPresenter().loadHistory();
    }

    @Override
    protected int getContentView() {
        return R.layout.history_price_fragment;
    }

    @Override
    public void displayHistory(List<HistoryDetailVO> historyDetailVO) {
        historyDetailAdapter.setData(historyDetailVO);
    }
}

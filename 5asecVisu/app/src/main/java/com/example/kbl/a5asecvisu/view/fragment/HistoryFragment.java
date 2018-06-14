package com.example.kbl.a5asecvisu.view.fragment;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.kbl.a5asecvisu.R;
import com.example.kbl.a5asecvisu.contract.HistoryFragmentContract;
import com.example.kbl.a5asecvisu.presenter.HistoryFragmentPresenter;
import com.example.kbl.a5asecvisu.presenter.VO.HistoryVO;
import com.example.kbl.a5asecvisu.view.adapter.HistoryAdapter;
import com.example.kbl.a5asecvisu.view.view.divider.DividerAlerte;

import java.util.List;

import butterknife.BindView;

public class HistoryFragment extends AbstractFragment<HistoryFragmentContract.Presenter> implements HistoryFragmentContract.View {

    @BindView(R.id.history_recyclerview)
    RecyclerView recyclerView;

    private RecyclerView.LayoutManager layoutManager;
    private HistoryAdapter historyAdapter;

    @Override
    protected HistoryFragmentContract.Presenter newPresenter() {
        return new HistoryFragmentPresenter(this);
    }

    @Override
    protected void initView(View rootView) {
        super.initView(rootView);
        recyclerView.addItemDecoration(new DividerAlerte(Color.BLACK,1,false,false));
        recyclerView.setNestedScrollingEnabled(false);

        layoutManager = new LinearLayoutManager(rootView.getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        historyAdapter = new HistoryAdapter();
        recyclerView.setAdapter(historyAdapter);
    }

    @Override
    protected void willAppear() {
        getPresenter().loadHistory();
    }

    @Override
    protected int getContentView() {
        return R.layout.history_fragment;
    }

    @Override
    public void displayHistory(List<HistoryVO> historyVO) {
        historyAdapter.setData(historyVO);
    }

}

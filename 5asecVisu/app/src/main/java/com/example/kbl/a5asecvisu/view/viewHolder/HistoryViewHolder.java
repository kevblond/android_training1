package com.example.kbl.a5asecvisu.view.viewHolder;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kbl.a5asecvisu.R;
import com.example.kbl.a5asecvisu.presenter.VO.HistoryVO;
import com.example.kbl.a5asecvisu.utils.RessourceUtils;
import com.example.kbl.a5asecvisu.view.adapter.HistoryDetailAdapter;
import com.example.kbl.a5asecvisu.view.view.divider.DividerAlerte;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.history_item_date)
    TextView historyDate;
    @BindView(R.id.history_item_location)
    TextView historyLocation;
    @BindView(R.id.history_item_solde)
    TextView historySolde;
    @BindView(R.id.history_item_country)
    TextView historyCountry;
    @BindView(R.id.history_item_open_detail)
    ImageView imageView;
    @BindView(R.id.history_item_detail)
    CardView detailLayout;
    @BindView(R.id.history_item_detail_ticket)
    TextView detailTicket;
    @BindView(R.id.history_item_detail_shop)
    TextView detailShop;
    @BindView(R.id.history_item_recyclerview)
    RecyclerView recyclerViewDetail;

    private RecyclerView.LayoutManager layoutManager;
    private HistoryDetailAdapter historyDetailAdapter;
    private Context context;


    public HistoryViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        context = itemView.getContext();
    }

    public void bindItem(final HistoryVO item){
        //first recycler visible
        historyDate.setText(item.getDate());
        historyLocation.setText(item.getLocation());
        historySolde.setText(item.getSolde());
        historyCountry.setText(item.getCountry());

        //second recycler invisible firstly
        String concatDetailTicket = RessourceUtils.getString(R.string.history_item_detail_ticket) + " " + item.getNumberTicket();
        detailTicket.setText(concatDetailTicket);
        String concatDetailShop = RessourceUtils.getString(R.string.history_item_detail_shop) + item.getNumberShop();
        detailShop.setText(concatDetailShop);

        //adapter and layoutmanager for second recyclerview
        recyclerViewDetail.addItemDecoration(new DividerItemDecoration(context,DividerItemDecoration.VERTICAL));
        recyclerViewDetail.setNestedScrollingEnabled(true);

        layoutManager = new LinearLayoutManager(recyclerViewDetail.getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerViewDetail.setLayoutManager(layoutManager);

        historyDetailAdapter = new HistoryDetailAdapter();
        recyclerViewDetail.setAdapter(historyDetailAdapter);
        historyDetailAdapter.setData(item.getListDetail());

        //open/close detail
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(detailLayout.getVisibility() == View.GONE){
                    imageView.animate().rotation(180).start();
                    detailLayout.setVisibility(View.VISIBLE);
                } else {
                    imageView.animate().rotation(0).start();
                    detailLayout.setVisibility(View.GONE);
                }
            }
        });
    }
}

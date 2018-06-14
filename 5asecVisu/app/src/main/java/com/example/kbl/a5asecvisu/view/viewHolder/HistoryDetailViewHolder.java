package com.example.kbl.a5asecvisu.view.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.kbl.a5asecvisu.R;
import com.example.kbl.a5asecvisu.presenter.VO.HistoryDetailVO;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryDetailViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.history_item_detail_name)
    TextView itemDetailName;
    @BindView(R.id.history_item_detail_solde)
    TextView itemDetailSolde;
    @BindView(R.id.history_item_detail_country)
    TextView itemDetailCountry;


    public HistoryDetailViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void bindItem(final HistoryDetailVO item){
        itemDetailName.setText(item.getName());
        itemDetailSolde.setText(item.getSolde());
        itemDetailCountry.setText(item.getCountry());
    }
}

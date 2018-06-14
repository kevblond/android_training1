package com.example.kbl.a5asecvisu.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kbl.a5asecvisu.R;
import com.example.kbl.a5asecvisu.presenter.VO.HistoryDetailVO;
import com.example.kbl.a5asecvisu.view.viewHolder.HistoryDetailViewHolder;

import java.util.ArrayList;
import java.util.List;

public class HistoryDetailAdapter extends RecyclerView.Adapter<HistoryDetailViewHolder>{

    private List<HistoryDetailVO> data;

    public HistoryDetailAdapter() {
        this.data = new ArrayList<>();
    }

    public void setData(List<HistoryDetailVO> historyVOList) {
        this.data = historyVOList;
        notifyDataSetChanged();
    }

    public List<HistoryDetailVO> getData() {
        return data;
    }

    @NonNull
    @Override
    public HistoryDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_detail_item, parent, false);
        return new HistoryDetailViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryDetailViewHolder holder, int position) {
        HistoryDetailVO historyVO = data.get(position);
        holder.bindItem(historyVO);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

package com.example.kbl.a5asecvisu.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kbl.a5asecvisu.R;
import com.example.kbl.a5asecvisu.presenter.VO.HistoryVO;
import com.example.kbl.a5asecvisu.view.viewHolder.HistoryViewHolder;

import java.util.ArrayList;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryViewHolder>{

    private List<HistoryVO> data;

    public HistoryAdapter() {
        this.data = new ArrayList<>();
    }

    public void setData(List<HistoryVO> historyVOList) {
        this.data = historyVOList;
        notifyDataSetChanged();
    }

    public List<HistoryVO> getData() {
        return data;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item, parent, false);
        return new HistoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        HistoryVO historyVO = data.get(position);
        holder.bindItem(historyVO);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

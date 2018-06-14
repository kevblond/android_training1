package com.example.kbl.a5asecvisu.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kbl.a5asecvisu.R;
import com.example.kbl.a5asecvisu.presenter.VO.AlertVO;
import com.example.kbl.a5asecvisu.view.viewHolder.AlerteViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ProfilAlerteAdapter extends RecyclerView.Adapter<AlerteViewHolder> {

    private List<AlertVO> data;

    public ProfilAlerteAdapter() {
        this.data = new ArrayList<>();
    }

    public void setData(List<AlertVO> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public List<AlertVO> getData() {
        return data;
    }

    @NonNull
    @Override
    public AlerteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.profil_alerte, parent, false);
        return new AlerteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AlerteViewHolder holder, int position) {
        AlertVO alerteVO = data.get(position);
        holder.bindItem(alerteVO);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void uncheckAllData() {
        for(AlertVO alerteVO : data){
            alerteVO.setCheckbox(false);
        }
        notifyDataSetChanged();
    }
    public void checkAllData() {
        for(AlertVO alerteVO : data){
            alerteVO.setCheckbox(true);
        }
        notifyDataSetChanged();
    }
}

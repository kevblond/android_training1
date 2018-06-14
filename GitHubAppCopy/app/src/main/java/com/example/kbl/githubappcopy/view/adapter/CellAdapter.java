package com.example.kbl.githubappcopy.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kbl.githubappcopy.R;
import com.example.kbl.githubappcopy.presenter.VO.RepositorieVO;
import com.example.kbl.githubappcopy.view.clickDelegate.OnClickItemDelegate;
import com.example.kbl.githubappcopy.view.viewHolder.GitViewHolder;

import java.util.ArrayList;
import java.util.List;

public class CellAdapter extends RecyclerView.Adapter<GitViewHolder> {

    public void setCells(List<RepositorieVO> cells) {
        this.cells = cells;
        notifyDataSetChanged();
    }

    private List<RepositorieVO> cells = new ArrayList<>();
    private OnClickItemDelegate onClickItemDelegate;

    public CellAdapter(OnClickItemDelegate onClickItemDelegate) {
        this.onClickItemDelegate = onClickItemDelegate;
    }

    ///////////////////////////////////////////////////////////////////////////
    // getter & setter
    ///////////////////////////////////////////////////////////////////////////
    public OnClickItemDelegate getOnClickItemDelegate() {
        return onClickItemDelegate;
    }

    public void setOnClickItemDelegate(OnClickItemDelegate delegate) {
        this.onClickItemDelegate = delegate;
    }

    ///////////////////////////////////////////////////////////////////////////
    // RecyclerView method Override
    ///////////////////////////////////////////////////////////////////////////

    @NonNull
    @Override
    public GitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_git, parent, false);
        return new GitViewHolder(v, onClickItemDelegate);
    }

    @Override
    public void onBindViewHolder(@NonNull GitViewHolder holder, int position) {
        RepositorieVO itemVO = cells.get(position);
        holder.bindItem(itemVO);
    }

    @Override
    public int getItemCount() {
        return cells.size();
    }

    ///////////////////////////////////////////////////////////////////////////
    // Swipe and Delete
    ///////////////////////////////////////////////////////////////////////////
    public void removeItem(int position) {
        cells.remove(position);
        notifyItemRemoved(position);
    }
}
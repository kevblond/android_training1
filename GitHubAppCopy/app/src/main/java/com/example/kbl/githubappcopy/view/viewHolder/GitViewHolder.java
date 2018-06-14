package com.example.kbl.githubappcopy.view.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.kbl.githubappcopy.R;
import com.example.kbl.githubappcopy.presenter.VO.RepositorieVO;
import com.example.kbl.githubappcopy.view.clickDelegate.OnClickItemDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GitViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.path)
    TextView fullName;
    @BindView(R.id.watchers)
    TextView watchers;
    @BindView(R.id.language)
    TextView language;
    private RepositorieVO item;

    //set onClickListener on the item, recuperation of the 4 View of a row
    public GitViewHolder(final View itemView, final OnClickItemDelegate delegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (delegate != null) {
                    delegate.onClickItem(item);
                }
            }
        });
    }

    //binding text on each 4 View
    public void bindItem(final RepositorieVO itemVO) {
        this.item = itemVO;
        name.setText(itemVO.getName());
        fullName.setText(itemVO.getFullName());
        watchers.setText(String.valueOf(itemVO.getWatchers()));
        language.setText(itemVO.getLanguage());
    }
}
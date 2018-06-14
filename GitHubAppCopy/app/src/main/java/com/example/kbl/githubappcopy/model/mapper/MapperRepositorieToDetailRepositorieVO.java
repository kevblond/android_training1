package com.example.kbl.githubappcopy.model.mapper;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.kbl.githubappcopy.model.Repositorie;
import com.example.kbl.githubappcopy.presenter.VO.DetailRepositorieVO;

/**
 * Mapper for transform an object type Repositorie to an object type DetailRepositorieVO
 */
public class MapperRepositorieToDetailRepositorieVO implements Mapper<Repositorie, DetailRepositorieVO> {
    public static final String TAG = MapperRepositorieToRepositorieVO.class.getSimpleName();

    @NonNull
    @Override
    public DetailRepositorieVO map(@NonNull Repositorie repositorie) {
        Log.d(TAG, "map DetailRepositorie");
        return new DetailRepositorieVO(repositorie.getFull_name(), repositorie.getAvatarUrl(), repositorie.getDescription());
    }
}

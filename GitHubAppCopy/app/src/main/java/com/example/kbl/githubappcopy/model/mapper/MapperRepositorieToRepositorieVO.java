package com.example.kbl.githubappcopy.model.mapper;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.kbl.githubappcopy.model.Repositorie;
import com.example.kbl.githubappcopy.presenter.VO.RepositorieVO;
/**
 * Mapper for transform an object type Repositorie to an object type RepositorieVO
 */
public class MapperRepositorieToRepositorieVO implements Mapper<Repositorie, RepositorieVO> {
    public static final String TAG = MapperRepositorieToRepositorieVO.class.getSimpleName();


    @NonNull
    @Override
    public RepositorieVO map(@NonNull Repositorie repositorie) {
        Log.d(TAG, "map Repositorie");
        return new RepositorieVO(repositorie.getId(),repositorie.getName(),repositorie.getFull_name(),repositorie.getWatchers(),repositorie.getLanguage(),repositorie.getDescription(),repositorie.getAvatarUrl());
    }
}

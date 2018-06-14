package com.example.kbl.githubappcopy.model.mapper;

import android.support.annotation.NonNull;

import com.example.kbl.githubappcopy.model.exception.MappingException;

public interface Mapper<From, To> {
    @NonNull
    To map(@NonNull From from) throws MappingException;
}

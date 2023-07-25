package com.tzp.dagger;

import com.tzp.dagger.di.RetroServiceInterface;

import javax.inject.Inject;

public class RemoteDataSource {

    @Inject
    public RetroServiceInterface serviceInterface;

    @Inject
    public RemoteDataSource(RetroServiceInterface serviceInterface) {
        this.serviceInterface = serviceInterface;
    }

}

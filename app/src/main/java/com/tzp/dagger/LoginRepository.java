package com.tzp.dagger;

import com.tzp.dagger.data.DivisionResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;

@Module
public class LoginRepository {


    public LocalDataSource localDataSource;
    public RemoteDataSource remoteDataSource;


    @Inject
    public LoginRepository(LocalDataSource localDataSource, RemoteDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }


    @Singleton
    @Provides
    public Observable<DivisionResponse> getDivision() {
        return remoteDataSource.serviceInterface.getDivision();
    }

}

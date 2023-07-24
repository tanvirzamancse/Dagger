package com.tzp.dagger;

import androidx.lifecycle.LiveData;

import com.tzp.dagger.data.DivisionResponse;
import com.tzp.dagger.di.RetroServiceInterface;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;

@Module
public class LoginRepository {

    @Inject
    public RetroServiceInterface serviceInterface;

    @Inject
    public LoginRepository(RetroServiceInterface serviceInterface) {
        this.serviceInterface = serviceInterface;
    }

    @Singleton
    @Provides
    public Observable<DivisionResponse> getDivision() {
        return serviceInterface.getDivision();
    }
}

package com.tzp.dagger.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetroModule {

    @Singleton
    @Provides
    public Retrofit getRetrofit() {

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("https://artificialsoft.xyz/courierdemo/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;

    }

    @Singleton
    @Provides
    public RetroServiceInterface getRetroServiceInterface(Retrofit retrofit) {
        return retrofit.create(RetroServiceInterface.class);
    }

}

package com.tzp.dagger;

import android.app.Application;

import com.tzp.dagger.di.DaggerRetroComponent;
import com.tzp.dagger.di.RetroComponent;
import com.tzp.dagger.di.RetroModule;

import javax.inject.Inject;
import javax.inject.Singleton;

public class MyApplication extends Application {

    RetroComponent retroComponent;
    @Override
    public void onCreate() {
        super.onCreate();
       retroComponent = DaggerRetroComponent.builder()
               .retroModule(new RetroModule())
                .build();
    }

    public RetroComponent getRetroComponent() {
        return retroComponent;
    }


}

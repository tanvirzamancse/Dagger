package com.tzp.dagger.di;

import com.tzp.dagger.LoginViewModel;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Provides;

@Singleton
@Component(modules = {RetroModule.class})
public interface RetroComponent {

   public void inject(LoginViewModel loginViewModel);
}

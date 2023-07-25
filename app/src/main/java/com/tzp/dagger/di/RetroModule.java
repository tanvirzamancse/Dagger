package com.tzp.dagger.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetroModule {

    private static Retrofit retrofit;

    @Singleton
    @Provides
    public RetroServiceInterface getRetroServiceInterface() {

        if (retrofit == null) {

            retrofit = new Retrofit
                    .Builder()
                    .client(getOkHttpClient())
                    .baseUrl("https://artificialsoft.xyz/courierdemo/")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(getGson()))
                    .build();
        }

        return retrofit.create(RetroServiceInterface.class);
    }

    @Singleton
    @Provides
    public OkHttpClient getOkHttpClient() {

        return new OkHttpClient()
                .newBuilder()
                .readTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(getHttpLoginInterceptor())
                .build();
    }

    @Singleton
    @Provides
    public Interceptor getHttpLoginInterceptor() {
        return new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor
                        .Level
                        .BODY);
    }

    @Singleton
    @Provides
    public Gson getGson() {
        return new GsonBuilder().setLenient().create();
    }
}

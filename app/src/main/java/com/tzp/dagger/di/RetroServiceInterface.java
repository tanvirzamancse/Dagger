package com.tzp.dagger.di;

import com.tzp.dagger.data.DivisionResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RetroServiceInterface {
    @GET("api/divisions")
    Observable<DivisionResponse> getDivision();
}

package com.tzp.dagger.di;

import com.tzp.dagger.data.DivisionResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetroServiceInterface {
    @GET("api/divisions")
    Call<DivisionResponse> getDivision();
}

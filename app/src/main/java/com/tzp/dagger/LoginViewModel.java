package com.tzp.dagger;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.tzp.dagger.data.DivisionResponse;
import com.tzp.dagger.di.RetroModule;
import com.tzp.dagger.di.RetroServiceInterface;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends AndroidViewModel {
    @Inject
    public RetroServiceInterface retroServiceInterface;
    public MutableLiveData<DivisionResponse> mutableLiveData;
    public LoginViewModel(@NonNull Application application) {
        super(application);
        ((MyApplication) application).getRetroComponent().inject(LoginViewModel.this);
        mutableLiveData = new MutableLiveData<>();
    }
    public LiveData<DivisionResponse> getDivision() {

        retroServiceInterface.getDivision().enqueue(new Callback<DivisionResponse>() {
            @Override
            public void onResponse(Call<DivisionResponse> call, Response<DivisionResponse> response) {
                if (response.isSuccessful()) {
                    DivisionResponse divisionResponse = response.body();
                    mutableLiveData.postValue(divisionResponse);
                } else {
                    mutableLiveData.postValue(null);
                }
            }
            @Override
            public void onFailure(Call<DivisionResponse> call, Throwable t) {
                mutableLiveData.postValue(null);
            }
        });
        return mutableLiveData;
    }


}

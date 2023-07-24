package com.tzp.dagger;
import android.app.Application;
import android.util.AndroidRuntimeException;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.tzp.dagger.data.DivisionResponse;
import com.tzp.dagger.di.RetroModule;
import com.tzp.dagger.di.RetroServiceInterface;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Provides;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class LoginViewModel extends AndroidViewModel {
    @Inject
    public LoginRepository loginRepository;
    public MutableLiveData<DivisionResponse> mutableLiveData;
    public LoginViewModel(@NonNull Application application) {
        super(application);
        ((MyApplication) application).getRetroComponent().inject(LoginViewModel.this);
        mutableLiveData = new MutableLiveData<>();
    }
    @Singleton
    public LiveData<DivisionResponse> getDivision() {

        loginRepository.getDivision()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DivisionResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        getDisposable().add(d);
                    }
                    @Override
                    public void onNext(DivisionResponse divisionResponse) {
                        mutableLiveData.postValue(divisionResponse);
                    }
                    @Override
                    public void onError(Throwable e) {
                        mutableLiveData.postValue(null);
                    }
                    @Override
                    public void onComplete() {

                    }
                });
        return mutableLiveData;
    }
    @Singleton
    public CompositeDisposable getDisposable() {
        return new CompositeDisposable();
    }
}

package com.ff.adapter;

import com.ff.adapter.retrofit.ApiService;
import com.ff.adapter.retrofit.Model;
import com.ff.adapter.retrofit.RxJavaCallAdapterFactory;
import com.ff.adapter.retrofit.library.Call;
import com.ff.adapter.retrofit.library.Callback;
import com.ff.adapter.retrofit.library.Retrofit;

import org.junit.Test;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;


public class DeveloperUnitTest {

    // 使用RX方式进行
    private static final boolean isRX = true;

    @Test
    public void retrofit() {

        Retrofit.Builder builder = new Retrofit.Builder();
        if (isRX) {
            builder.addCallAdapterFactory(new RxJavaCallAdapterFactory());
        }
        Retrofit retrofit = builder.build();

        ApiService apiService = retrofit.create(ApiService.class);

        if (isRX) {
            Observable<Model> modelObservable = apiService.rxRequestData();
            modelObservable.subscribe(new Observer<Model>() {

                @Override
                public void onSubscribe(@NonNull Disposable d) {
                    System.out.println("onSubscribe");
                }

                @Override
                public void onNext(@NonNull Model model) {
                    System.out.println("onNext");
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    System.out.println("onError");
                }

                @Override
                public void onComplete() {
                    System.out.println("onComplete");
                }
            });
        } else {
            Call<Model> modelCall = apiService.requestData();
            modelCall.enqueue(new Callback<Model>() {
                @Override
                public void onResponse(Call<Model> var1, Response<Model> var2) {
                    System.out.println("onResponse");
                }

                @Override
                public void onFailure(Call<Model> var1, Throwable var2) {
                    System.out.println("onFailure");
                }
            });
        }
    }
}

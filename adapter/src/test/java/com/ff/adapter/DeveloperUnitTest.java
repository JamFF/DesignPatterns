package com.ff.adapter;

import com.ff.adapter.retrofit.ApiService;
import com.ff.adapter.retrofit.Model;
import com.ff.adapter.retrofit.RxJavaCallAdapterFactory;
import com.ff.adapter.retrofit.library.Call;
import com.ff.adapter.retrofit.library.Callback;
import com.ff.adapter.retrofit.library.Retrofit;

import org.junit.Test;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
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
            Single<Model> modelObservable = apiService.rxRequestData();
            modelObservable.subscribe(new SingleObserver<Model>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {
                    System.out.println("onSubscribe");
                }

                @Override
                public void onSuccess(@NonNull Model model) {
                    System.out.println("onSuccess");
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    System.out.println("onError");
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

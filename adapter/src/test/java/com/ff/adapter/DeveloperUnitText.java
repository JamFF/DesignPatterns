package com.ff.adapter;

import com.ff.adapter.retrofit.ApiService;
import com.ff.adapter.retrofit.Model;
import com.ff.adapter.retrofit.RxJavaCallAdapterFactory;
import com.ff.adapter.retrofit.library.Call;
import com.ff.adapter.retrofit.library.Callback;
import com.ff.adapter.retrofit.library.Retrofit;

import org.junit.Test;

import rx.Observable;
import rx.Observer;

public class DeveloperUnitText {

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
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(Model model) {

                }
            });
        } else {
            Call<Model> modelCall = apiService.requestData();
            modelCall.enqueue(new Callback<Model>() {
                @Override
                public void onResponse(Call<Model> var1, Response<Model> var2) {

                }

                @Override
                public void onFailure(Call<Model> var1, Throwable var2) {

                }
            });
        }
    }
}

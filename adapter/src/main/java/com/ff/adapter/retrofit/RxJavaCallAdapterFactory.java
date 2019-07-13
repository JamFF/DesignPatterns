package com.ff.adapter.retrofit;

import com.ff.adapter.retrofit.library.Call;
import com.ff.adapter.retrofit.library.CallAdapter;

import rx.Observable;

public class RxJavaCallAdapterFactory extends CallAdapter.Factory {

    @Override
    public CallAdapter<?, ?> get() {
        return new CallAdapter<Object, Observable<?>>() {

            @Override
            public Observable<?> adapt(Call<Object> call) {

                System.out.println("Observable >>> ");
                Observable.OnSubscribe func = new Observable.OnSubscribe() {
                    @Override
                    public void call(Object o) {
                        System.out.println("RxJavaCallAdapterFactory 发起网络请求");
                    }
                };
                return Observable.unsafeCreate(func);
            }
        };
    }
}

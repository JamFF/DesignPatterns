package com.ff.adapter.retrofit;

import com.ff.adapter.retrofit.library.Call;
import com.ff.adapter.retrofit.library.CallAdapter;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;

/**
 * description: 开发者自定义的CallAdapter.Factory
 * author: FF
 * time: 2019-07-11 15:38
 */
public class RxJavaCallAdapterFactory extends CallAdapter.Factory {

    @Override
    public CallAdapter<?, ?> get() {
        // 创建CallAdapter
        // 将网络请求后返回的Object转换为的使用者定义的Model数据类型
        return new CallAdapter<Object, Observable<?>>() {
            @Override
            public Observable<?> adapt(Call<Object> call) {

                System.out.println("Observable >>> ");
                ObservableOnSubscribe<Object> func = new ObservableOnSubscribe<Object>() {
                    @Override
                    public void subscribe(@NonNull ObservableEmitter<Object> emitter) throws Throwable {
                        System.out.println("RxJavaCallAdapterFactory 发起网络请求");
                        emitter.onNext(new Model());
                        emitter.onComplete();
                    }
                };
                return Observable.create(func);
            }
        };
    }
}

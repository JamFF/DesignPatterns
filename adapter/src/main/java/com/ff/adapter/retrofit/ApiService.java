package com.ff.adapter.retrofit;

import com.ff.adapter.retrofit.library.Call;

import io.reactivex.rxjava3.core.Observable;

/**
 * description:
 * author: FF
 * time: 2019-07-11 23:34
 */
public interface ApiService {

    /**
     * 请求接口
     */
    Call<Model> requestData();

    Observable<Model> rxRequestData();
}

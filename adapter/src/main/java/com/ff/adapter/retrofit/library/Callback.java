package com.ff.adapter.retrofit.library;

/**
 * description: 网络请求回调，简单模拟
 * author: FF
 * time: 2019-07-11 22:58
 */
public interface Callback<T> {

    void onResponse(Call<T> var1, Response<T> var2);

    void onFailure(Call<T> var1, Throwable var2);

    class Response<T> {
    }
}


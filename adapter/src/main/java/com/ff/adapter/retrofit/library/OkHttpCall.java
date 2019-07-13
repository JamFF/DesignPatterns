package com.ff.adapter.retrofit.library;

/**
 * description: 真正网络请求
 * author: FF
 * time: 2019-07-11 15:20
 */
class OkHttpCall<T> implements Call<T> {

    @Override
    public void enqueue(Callback<T> callback) {
        System.out.println("OkHttpCall enqueue");
    }
}

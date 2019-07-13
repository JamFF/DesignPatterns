package com.ff.adapter.retrofit.library;

/**
 * description: 发起网络请求的接口
 * author: FF
 * time: 2019-07-11 15:19
 */
public interface Call<T> {

    /**
     * 真正执行网络请求
     * 这里为了简单，不设置回调，参数省略了Callback<T> callback
     */
    void enqueue(Callback<T> callback);
}

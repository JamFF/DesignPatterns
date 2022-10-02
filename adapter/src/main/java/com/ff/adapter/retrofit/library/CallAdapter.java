package com.ff.adapter.retrofit.library;

/**
 * description: 适配器，将R类型，适配为T类型
 * author: FF
 * time: 2019-07-11 15:21
 */
public interface CallAdapter<R, T> {

    T adapt(Call<R> call);

    /**
     * description: 对外使用的都是这个工厂
     * author: FF
     * time: 2019-07-11 22:16
     */
    abstract class Factory {

        /**
         * 获取子类各自的CallAdapter
         */
        public abstract CallAdapter<?, ?> get();
    }
}

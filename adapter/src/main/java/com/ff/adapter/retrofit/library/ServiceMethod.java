package com.ff.adapter.retrofit.library;

/**
 * description:
 * author: FF
 * time: 2019-07-11 15:43
 */
public class ServiceMethod<R, T> {

    private CallAdapter<R, T> callAdapter;

    private ServiceMethod(Builder<R, T> builder) {
        // 从建造者中拿到CallAdapter
        callAdapter = builder.callAdapter;
    }

    /**
     * 通过CallAdapter将R类型适配为T类型
     */
    T adapt(Call<R> call) {
        return callAdapter.adapt(call);
    }

    /**
     * description: 使用建造者模式
     * author: FF
     * time: 2019-07-11 23:11
     */
    static final class Builder<R, T> {

        Retrofit retrofit;
        CallAdapter<R, T> callAdapter;

        Builder(Retrofit retrofit) {
            // 传入的目的是要获取retrofit配置信息，比如CallAdapter等
            this.retrofit = retrofit;
        }

        public ServiceMethod build() {
            callAdapter = createCallAdapter();
            // 实例化并返回对象ServiceMethod
            return new ServiceMethod<>(this);
        }


        @SuppressWarnings("unchecked")
        private CallAdapter<R, T> createCallAdapter() {
            // 通过retrofit获取CallAdapter
            return (CallAdapter<R, T>) retrofit.callAdapter();
        }
    }
}

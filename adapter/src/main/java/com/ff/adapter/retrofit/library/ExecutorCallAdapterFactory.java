package com.ff.adapter.retrofit.library;

/**
 * description: 默认的CallAdapter
 * author: FF
 * time: 2019-07-11 15:34
 */
public class ExecutorCallAdapterFactory extends CallAdapter.Factory {

    @Override
    public CallAdapter<?, ?> get() {
        // 创建CallAdapter
        // 将网络请求后返回的Object转换为的使用者定义的Model数据类型
        return new CallAdapter<Object, Call<?>>() {
            @Override
            public Call<?> adapt(Call<Object> call) {
                System.out.println("Default >>>");
                // call为真正做网络请求的OkHttpCall对象
                return new ExecutorCallbackCall<>();
            }
        };
    }

    /**
     * description:
     * author: FF
     * time: 2019-07-11 22:30
     */
    static final class ExecutorCallbackCall<T> implements Call<T> {

        @Override
        public void enqueue(Callback<T> callback) {
            // 不关心请求过程，只关心适配器模式
            System.out.println("ExecutorCallAdapterFactory 发起网络请求");
        }
    }
}

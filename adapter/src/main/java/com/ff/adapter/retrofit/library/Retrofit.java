package com.ff.adapter.retrofit.library;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * description:
 * author: FF
 * time: 2019-07-11 15:43
 */
public class Retrofit {

    private final CallAdapter.Factory factory;

    private Retrofit(CallAdapter.Factory factory) {
        this.factory = factory;
    }

    /**
     * 通过默认的Factory或者自定义的Factory，创建CallAdapter
     */
    public CallAdapter<?, ?> callAdapter() {
        return factory.get();
    }

    @SuppressWarnings("unchecked")
    public <T> T create(final Class<T> service) {
        return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class<?>[]{service},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args)
                            throws Throwable {
                        ServiceMethod serviceMethod = new ServiceMethod
                                .Builder<>(Retrofit.this)
                                .build();
                        OkHttpCall<Object> okHttpCall = new OkHttpCall<>();
                        // 通过CallAdapter，将OkHttpCall的Object适配为目标Model
                        return serviceMethod.adapt(okHttpCall);
                    }
                });
    }

    /**
     * description: 通过建造者模式，配置CallAdapter
     * author: FF
     * time: 2019-07-11 15:54
     */
    public static final class Builder {

        CallAdapter.Factory factory;

        public Builder addCallAdapterFactory(CallAdapter.Factory factory) {
            // 自定义CallAdapter
            this.factory = factory;
            return this;
        }

        public Retrofit build() {
            if (factory == null) {
                // 未设置，使用默认CallAdapter
                factory = new ExecutorCallAdapterFactory();
            }
            return new Retrofit(factory);
        }
    }
}

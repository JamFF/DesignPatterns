package com.ff.factory;

import com.ff.factory.Api;
import com.ff.factory.impl.ApiImpl;

/**
 * description: 简单工厂模式
 * author: FF
 * time: 2019-07-09 21:50
 */
public class SampleFactory {

    public static Api createApi() {
        return new ApiImpl();
    }
}

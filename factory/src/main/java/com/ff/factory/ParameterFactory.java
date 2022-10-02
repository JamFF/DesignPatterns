package com.ff.factory;

import com.ff.factory.impl.ApiImpl_A;
import com.ff.factory.impl.ApiImpl_B;

/**
 * description: 读取参数的工厂
 * author: FF
 * time: 2019-07-09 22:12
 */
public class ParameterFactory {

    public static Api createApi(int parameter) {
        switch (parameter) {
            case 1:
                return new ApiImpl_A();

            case 2:
                return new ApiImpl_B();

            default:
                throw new RuntimeException("the parameter requested is not supported");
        }
    }
}

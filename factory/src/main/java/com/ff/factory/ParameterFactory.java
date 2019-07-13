package com.ff.factory;

import com.ff.factory.Api;
import com.ff.factory.impl.ApiImpl_A;
import com.ff.factory.impl.ApiImpl_B;

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

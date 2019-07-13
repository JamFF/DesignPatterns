package com.ff.factory.impl;

import com.ff.factory.Api;
import com.ff.factory.bean.UserInfo;

public class ApiImpl_A implements Api {

    @Override
    public UserInfo createUser() {
        return new UserInfo("A", 20);
    }
}

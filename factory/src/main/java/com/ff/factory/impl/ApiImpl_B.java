package com.ff.factory.impl;

import com.ff.factory.Api;
import com.ff.factory.bean.UserInfo;

public class ApiImpl_B implements Api {

    @Override
    public UserInfo createUser() {
        return new UserInfo("B", 24);
    }
}

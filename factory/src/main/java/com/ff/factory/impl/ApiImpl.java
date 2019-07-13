package com.ff.factory.impl;

import com.ff.factory.Api;
import com.ff.factory.bean.UserInfo;

public class ApiImpl implements Api {

    @Override
    public UserInfo createUser() {
        return new UserInfo("FF", 18);
    }
}

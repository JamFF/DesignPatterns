package com.ff.mvp.http_lib;

import android.support.annotation.NonNull;

import com.ff.mvp.bean.UserBean;
import com.ff.mvp.login.LoginPresenter;

/**
 * description: 登录模块的请求
 * author: FF
 * time: 2019-07-14 21:52
 */
public class LoginHttpEngine {

    @NonNull
    private LoginPresenter p;

    public LoginHttpEngine(@NonNull LoginPresenter p) {
        this.p = p;
    }

    public void post(String name, String pwd) {
        if ("FF".equals(name) && "123".equals(pwd)) {
            p.getContract().responseResult(new UserBean("FF", 18));
        } else {
            p.getContract().responseResult(null);
        }
    }
}

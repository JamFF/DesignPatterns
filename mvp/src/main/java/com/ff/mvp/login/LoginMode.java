package com.ff.mvp.login;

import androidx.annotation.NonNull;

import com.ff.mvp.base.BaseModel;
import com.ff.mvp.bean.UserBean;

public class LoginMode extends BaseModel<LoginPresenter, LoginContract.Model> {

    public LoginMode(@NonNull LoginPresenter loginPresenter) {
        super(loginPresenter);
    }

    @NonNull
    @Override
    public LoginContract.Model getContract() {
        return new LoginContract.Model() {
            @Override
            public void executeLogin(String name, String pwd) {
                if ("FF".equals(name) && "123".equals(pwd)) {
                    p.getContract().responseResult(new UserBean("FF", 18));
                } else {
                    p.getContract().responseResult(null);
                }
            }
        };
    }
}

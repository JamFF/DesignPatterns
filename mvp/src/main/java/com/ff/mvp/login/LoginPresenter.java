package com.ff.mvp.login;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ff.mvp.LoginActivity;
import com.ff.mvp.base.BasePresenter;
import com.ff.mvp.bean.UserBean;

public class LoginPresenter extends BasePresenter<LoginActivity, LoginMode, LoginContract.Presenter> {

    @NonNull
    @Override
    public LoginContract.Presenter getContract() {
        // 既要履行View给它的需求，又要分配工作给Model去完成这个需求
        return new LoginContract.Presenter() {
            @Override
            public void requestLogin(String name, String pwd) {
                // 三种风格

                // 第一种，P层不做事，转发给Model
                m.getContract().executeLogin(name, pwd);

                // 第二种，让功能模块去工作（Library：下载、请求、图片加载）
//                LoginHttpEngine engine = new LoginHttpEngine(LoginPresenter.this);
//                engine.post(name, pwd);

                // 第三种，P层自己处理（谷歌例子）
//                if ("FF".equals(name) && "123".equals(pwd)) {
//                    responseResult(new UserBean("FF", 18));
//                } else {
//                    responseResult(null);
//                }

                // 内存泄露测试
                /*new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SystemClock.sleep(50000);
                    }
                }).start();*/
            }

            @Override
            public void responseResult(@Nullable UserBean userBean) {
                // 不管谁完成需求，有结果就告知View层
                if (getView() != null) {
                    getView().getContract().handlerResult(userBean);
                }
            }
        };
    }

    @NonNull
    @Override
    public LoginMode getModel() {
        return new LoginMode(this);
    }
}

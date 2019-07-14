package com.ff.mvvm.vm;

import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.ff.mvvm.databinding.ActivityMainBinding;
import com.ff.mvvm.model.UserBean;

/**
 * description: VM层
 * author: FF
 * time: 2019-07-14 23:12
 */
public class LoginViewModel {

    private static final String TAG = "LoginViewModel";

    // 切记：必须是public修饰符，因为要在layout中使用loginViewModel.userInfo.xxx
    public UserBean mUserBean;

    public LoginViewModel(ActivityMainBinding binding) {
        mUserBean = new UserBean();
        // 将ViewModel和View进行绑定，通过DataBinding工具
        binding.setLoginViewModel(this);
    }

    public TextWatcher nameInputListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // View层接收到用户的输入，改变Model层的javabean属性
            mUserBean.name.set(String.valueOf(s));
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public TextWatcher pwdInputListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // View层接收到用户的输入，改变Model层的javabean属性
            mUserBean.pwd.set(String.valueOf(s));
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public View.OnClickListener loginClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // 模拟网络请求
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // Model层属性的变更，改变View层的显示
                    mUserBean.name.set("JamFF");
                    SystemClock.sleep(2000);

                    if ("FF".equals(mUserBean.name.get()) && "123".equals(mUserBean.pwd.get())) {
                        Log.e(TAG, "登录成功!");
                    } else {
                        Log.e(TAG, "登录失败!");
                    }
                }
            }).start();
        }
    };
}

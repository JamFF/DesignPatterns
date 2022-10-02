package com.ff.mvp;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ff.mvp.base.BaseActivity;
import com.ff.mvp.bean.UserBean;
import com.ff.mvp.login.LoginContract;
import com.ff.mvp.login.LoginPresenter;

public class LoginActivity extends BaseActivity<LoginPresenter, LoginContract.View> implements View.OnClickListener {

    private EditText et_name;
    private EditText et_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        et_name = findViewById(R.id.et_name);
        et_pwd = findViewById(R.id.et_pwd);
        findViewById(R.id.bt_login).setOnClickListener(this);
    }

    @NonNull
    @Override
    public LoginContract.View getContract() {
        return new LoginContract.View() {
            @Override
            public void handlerResult(@Nullable UserBean userBean) {
                if (userBean != null) {
                    Toast.makeText(LoginActivity.this, userBean.toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "登录失败！", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }

    @NonNull
    @Override
    public LoginPresenter getPresenter() {
        return new LoginPresenter();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_login) {
            String name = et_name.getText().toString();
            String pwd = et_pwd.getText().toString();
            // 发起需求，让Presenter处理
            p.getContract().requestLogin(name, pwd);
        }
    }
}

package com.ff.mvp.base;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

/**
 * description: View层基类
 * author: FF
 * time: 2019-07-14 20:33
 */
public abstract class BaseActivity<P extends BasePresenter, CONTRACT> extends AppCompatActivity {

    protected P p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 弱引用
        p = getPresenter();
        // 绑定
        p.bindView(this);
    }

    /**
     * 获取子类具体契约
     *
     * @return 契约类中子类的View
     */
    @NonNull
    public abstract CONTRACT getContract();

    @NonNull
    public abstract P getPresenter();

    // 如果P层出现了异常，需要告知View层
    public void error(Exception e) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 解除绑定
        p.unBindView();
    }
}

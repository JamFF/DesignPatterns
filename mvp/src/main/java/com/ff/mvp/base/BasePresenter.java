package com.ff.mvp.base;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

/**
 * description: Presenter层基类
 * author: FF
 * time: 2019-07-14 20:34
 */
public abstract class BasePresenter<V extends BaseActivity, M extends BaseModel, CONTRACT> {

    @NonNull
    protected M m;

    // 绑定View层弱引用
    private WeakReference<V> mReference;

    public BasePresenter() {
        m = getModel();
    }

    public void bindView(V v) {
        mReference = new WeakReference<>(v);
    }

    public void unBindView() {
        if (mReference != null) {
            mReference.clear();
            mReference = null;
            System.gc();
        }
    }

    @NonNull
    public abstract M getModel();

    @Nullable
    public V getView() {
        if (mReference != null) {
            return mReference.get();
        }
        return null;
    }

    /**
     * 获取子类具体契约
     *
     * @return 契约类中子类的Presenter
     */
    @NonNull
    public abstract CONTRACT getContract();
}

package com.ff.mvp.base;

import androidx.annotation.NonNull;

/**
 * description: Model层基类
 * author: FF
 * time: 2019-07-14 20:32
 */
public abstract class BaseModel<P extends BasePresenter, CONTRACT> {

    @NonNull
    protected P p;

    public BaseModel(@NonNull P p) {
        this.p = p;
    }

    /**
     * 获取子类具体契约
     *
     * @return 契约类中子类的Model
     */
    @NonNull
    public abstract CONTRACT getContract();
}

package com.ff.mvvm.model;

import androidx.databinding.ObservableField;

/**
 * description: M层
 * author: FF
 * time: 2019-07-14 23:11
 */
public class UserBean {

    // 被观察的属性（切记：必须是public修饰符，因为是DataBinding的规范）
    public ObservableField<String> name = new ObservableField<>();

    public ObservableField<String> pwd = new ObservableField<>();
}

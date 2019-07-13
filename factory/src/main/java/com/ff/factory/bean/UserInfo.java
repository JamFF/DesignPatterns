package com.ff.factory.bean;

import android.support.annotation.NonNull;

/**
 * description:
 * author: FF
 * time: 2019-07-09 17:11
 */
public class UserInfo {

    private String name;
    private int age;

    public UserInfo() {
    }

    public UserInfo(String name) {
        this.name = name;
    }

    public UserInfo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @NonNull
    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


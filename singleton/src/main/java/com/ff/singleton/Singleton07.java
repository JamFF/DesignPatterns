package com.ff.singleton;

/**
 * Description: 懒汉式，静态内部类，JVM保证线程安全（推荐）
 * 加载外部类时不会加载内部类，实现懒汉式
 * Author: 傅健
 * CreateDate: 2022/9/30 13:45
 */
public class Singleton07 {

    private Singleton07() {}

    private static class Holder {
        private static final Singleton07 INSTANCE = new Singleton07();
    }

    public static Singleton07 getInstance() {
        return Holder.INSTANCE;
    }

}

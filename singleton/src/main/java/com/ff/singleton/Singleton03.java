package com.ff.singleton;

/**
 * Description: 懒汉式，线程不安全（不可用）
 * Author: 傅健
 * CreateDate: 2022/9/30 13:45
 */
public class Singleton03 {

    private static Singleton03 INSTANCE;

    private Singleton03() {}

    public static Singleton03 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Singleton03();
        }
        return INSTANCE;
    }

}

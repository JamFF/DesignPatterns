package com.ff.singleton;

/**
 * Description: 懒汉式，同步代码块线程不安全（不可用）
 * Author: 傅健
 * CreateDate: 2022/9/30 13:45
 */
public class Singleton05 {

    private static Singleton05 INSTANCE;

    private Singleton05() {}

    public static Singleton05 getInstance() {
        if (INSTANCE == null) {
            // 通过减小同步代码块，提高性能，但是线程不安全
            synchronized (Singleton05.class) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Singleton05();
            }
        }
        return INSTANCE;
    }

}

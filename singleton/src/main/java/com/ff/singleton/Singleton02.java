package com.ff.singleton;

/**
 * Description: 饿汉式-静态代码块，JVM保证线程安全（可用）
 * 类装载时，就完成实例化，例如：Class.forName("Singleton01");时就会被实例化
 * Author: 傅健
 * CreateDate: 2022/9/30 13:45
 */
public class Singleton02 {

    private static final Singleton02 INSTANCE;

    static {
        INSTANCE = new Singleton02();
    }

    private Singleton02() {}

    public static Singleton02 getInstance() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return INSTANCE;
    }

}

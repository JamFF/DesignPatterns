package com.ff.singleton;

/**
 * Description: 懒汉式，同步方法保证线程安全，但是效率低（不推荐）
 * Author: 傅健
 * CreateDate: 2022/9/30 13:45
 */
public class Singleton04 {

    private static Singleton04 INSTANCE;

    private Singleton04() {}

    public static synchronized Singleton04 getInstance() {
        // synchronized，原子性，可见性，有序性
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Singleton04();
        }
        return INSTANCE;
    }

}

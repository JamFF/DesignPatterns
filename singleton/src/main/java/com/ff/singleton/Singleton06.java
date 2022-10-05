package com.ff.singleton;

/**
 * Description: 懒汉式，双重检查锁（Double-checked locking），保证线程安全（推荐）
 * Author: 傅健
 * CreateDate: 2022/9/30 13:45
 */
public class Singleton06 {

    // 为了保证不被反射破坏单例增加的字段
    private static boolean isInit = false;

    // volatile，可以保证可见性和有序性（禁止指令重排序），无法保证原子性
    private static volatile Singleton06 INSTANCE;

    private Singleton06() {
        synchronized (Singleton07.class) {
            if (isInit) {
                throw new RuntimeException("禁止使用反射");
            } else {
                isInit = true;
            }
        }
    }

    public static Singleton06 getInstance() {
        // 如果不使用volatile，这里可能会出现INSTANCE不为null，直接返回INSTANCE，但内存资源还没有分配对象的问题
        if (INSTANCE == null) {
            // synchronized只能保证块与块之间的原子性，可见性，有序性
            synchronized (Singleton06.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 对象的实例化是一个非原子性操作，会出现指令重排
                    INSTANCE = new Singleton06();
                }
            }
        }
        return INSTANCE;
    }

}

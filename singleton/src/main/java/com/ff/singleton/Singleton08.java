package com.ff.singleton;

/**
 * Description: 懒汉式，枚举（最推荐）
 * 枚举的属性是静态的，所以由JVM保证线程安全
 * 枚举自身保证序列化和反射不被破坏
 * Author: 傅健
 * CreateDate: 2022/9/30 13:45
 */
public enum Singleton08 {
    INSTANCE
}

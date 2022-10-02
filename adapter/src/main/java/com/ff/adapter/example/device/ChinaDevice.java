package com.ff.adapter.example.device;

/**
 * description: 中国电器
 * author: FF
 * time: 2019-07-10 14:49
 */
public class ChinaDevice implements Device {

    @Override
    public void use(int voltage) {
        System.out.println("输入电压" + voltage + "V");
        if (voltage == 220) {
            System.out.println("中国电器正常运行");
        } else {
            System.out.println("中国电器烧毁");
        }
        System.out.println();
    }
}

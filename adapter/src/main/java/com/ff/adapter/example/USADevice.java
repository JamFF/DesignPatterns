package com.ff.adapter.example;

import com.ff.adapter.example.device.Device;

/**
 * description: 美国电器
 * author: FF
 * time: 2019-07-10 14:49
 */
public class USADevice implements Device {

    @Override
    public void use(int voltage) {
        System.out.println("输入电压" + voltage + "V");
        if (voltage == 110) {
            System.out.println("美国电器正常运行");
        } else {
            System.out.println("美国电器烧毁");
        }
        System.out.println();
    }
}

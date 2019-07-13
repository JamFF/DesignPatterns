package com.ff.adapter.example;

import com.ff.adapter.example.device.Device;

/**
 * description: 中国220V电源
 * author: FF
 * time: 2019-07-10 18:01
 */
public class ChinaPower {
    public void run(Device device) {
        device.use(220);
    }
}

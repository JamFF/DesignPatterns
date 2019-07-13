package com.ff.adapter;

import com.ff.adapter.example.ChinaDevice;
import com.ff.adapter.example.ChinaPower;
import com.ff.adapter.example.USADevice;
import com.ff.adapter.example.device.ChinaAdapter;
import com.ff.adapter.example.device.Device;

import org.junit.Test;

/**
 * description: 需要一个电源适配器同时使用两种
 * author: FF
 * time: 2019-07-10 14:52
 */
public class DeviceUnitTest {

    @Test
    public void test() {

        // 普通方式

        // 创建220V电源
        ChinaPower chinaPower = new ChinaPower();

        Device device = new ChinaDevice();

        // 运行中国电器
        chinaPower.run(device);


        // 运行美国电器
        // power.run(new USADevice());// 电压匹配，不能运行


        // 适配器模式
        device = new ChinaAdapter();
        chinaPower.run(device);

        // 只要修改一下构造，就可以完美适配
        device = new ChinaAdapter(new USADevice());
        chinaPower.run(device);
    }
}

package com.ff.adapter;

import com.ff.adapter.example.device.ChinaDevice;
import com.ff.adapter.example.ChinaPower;
import com.ff.adapter.example.device.USADevice;
import com.ff.adapter.example.device.ChinaAdapter;
import com.ff.adapter.example.device.Device;

import org.junit.Test;

/**
 * description: 需要一个电源适配器同时使用两种国家的电器
 * author: FF
 * time: 2019-07-10 14:52
 */
public class DeviceUnitTest {

    @Test
    public void test() {

        // region 普通方式
        // 创建中国220V电源
        ChinaPower chinaPower = new ChinaPower();

        // 运行中国电器，没问题
        chinaPower.run(new ChinaDevice());

        // 运行美国电器，电压匹配，不能运行
        chinaPower.run(new USADevice());
        // endregion

        // region 适配器模式
        // 默认构造，就是支持220V的中国电器
        chinaPower.run(new ChinaAdapter());

        // 只要修改一下构造，就可以完美适配
        chinaPower.run(new ChinaAdapter(new USADevice()));
        // endregion
    }
}

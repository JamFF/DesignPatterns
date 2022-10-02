package com.ff.adapter.example.device;

/**
 * description: 电源适配器，同时支持中国、美国电器
 * author: FF
 * time: 2019-07-10 14:43
 */
public class ChinaAdapter implements Device {

    private final Device mDevice;

    /**
     * 默认中国电器
     */
    public ChinaAdapter() {
        mDevice = new ChinaDevice();
    }

    /**
     * 适配各国电器
     */
    public ChinaAdapter(Device device) {
        this.mDevice = device;
    }

    @Override
    public void use(int voltage) {
        System.out.println("输入电压" + voltage + "V");
        if (mDevice instanceof ChinaDevice) {// 默认中国电器
            if (voltage == 220) {
                System.out.println("中国电器正常运行");
            } else {
                System.out.println("中国电器烧毁");
            }
        } else if (mDevice instanceof USADevice) {// 适配美国电器
            if (voltage == 110) {
                System.out.println("美国电器正常运行");
            } else {
                System.out.println("适配器工作...进行变压");
                System.out.println("美国电器在" + voltage + "V正常运行");
            }
        } else {
            throw new IllegalArgumentException(mDevice + "未知电器");
        }
        System.out.println();
    }
}

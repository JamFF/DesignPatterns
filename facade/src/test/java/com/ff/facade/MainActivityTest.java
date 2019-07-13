package com.ff.facade;

import org.junit.Test;

/**
 * description: 模拟图片加载
 * author: FF
 * time: 2019-07-09 23:13
 */
public class MainActivityTest {

    private final static String URL = "http://www.baidu.com";

    @Test
    public void onCreate() {
        // 常规的写法：
        /*MemoryCache memoryCache = new MemoryCacheImpl();
        Bitmap byMemory = memoryCache.findByMemory(URL);
        if (byMemory == null) {
            DiskCache diskCache = new DiskCacheImpl();
            Bitmap byDisk = diskCache.findByDisk(URL);
            if (byDisk == null) {
                NetWorkLoader netWorkLoader = new NetWorkLoaderImpl();
                netWorkLoader.loaderImageFromNet(URL);
            }
        }*/

        // 外观模式
        Facade facade = new Facade(URL);
        facade.loader();
    }
}
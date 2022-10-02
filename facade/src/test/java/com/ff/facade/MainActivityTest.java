package com.ff.facade;

import android.graphics.Bitmap;

import com.ff.facade.impl.DiskCacheImpl;
import com.ff.facade.impl.MemoryCacheImpl;
import com.ff.facade.impl.NetWorkLoaderImpl;
import com.ff.facade.thing.DiskCache;
import com.ff.facade.thing.MemoryCache;
import com.ff.facade.thing.NetWorkLoader;

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
        MemoryCache memoryCache = new MemoryCacheImpl();
        Bitmap result = memoryCache.findByMemory(URL);
        if (result == null) {
            DiskCache diskCache = new DiskCacheImpl();
            result = diskCache.findByDisk(URL);
            if (result == null) {
                NetWorkLoader netWorkLoader = new NetWorkLoaderImpl();
                result = netWorkLoader.loaderImageFromNet(URL);
            }
        }
        System.out.println(result);

        // 外观模式：
        ImageLoader facade = new ImageLoader(URL);
        Bitmap bitmap = facade.loader();
        System.out.println(bitmap);
    }
}
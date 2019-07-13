package com.ff.facade;

import android.graphics.Bitmap;

import com.ff.facade.impl.DiskCacheImpl;
import com.ff.facade.impl.MemoryCacheImpl;
import com.ff.facade.impl.NetWorkLoaderImpl;
import com.ff.facade.thing.DiskCache;
import com.ff.facade.thing.MemoryCache;
import com.ff.facade.thing.NetWorkLoader;

/**
 * description: 外观模式
 * author: FF
 * time: 2019-07-09 23:17
 */
public class Facade {

    private String url;
    private MemoryCache memoryCache;
    private DiskCache diskCache;
    private NetWorkLoader netWorkLoader;

    public Facade(String url) {
        this.url = url;
        memoryCache = new MemoryCacheImpl();
        diskCache = new DiskCacheImpl();
        netWorkLoader = new NetWorkLoaderImpl();
    }

    void loader() {
        Bitmap byMemory = memoryCache.findByMemory(url);
        if (byMemory == null) {
            Bitmap byDisk = diskCache.findByDisk(url);
            if (byDisk == null) {
                netWorkLoader.loaderImageFromNet(url);
            }
        }
    }
}

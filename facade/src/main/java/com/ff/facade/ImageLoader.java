package com.ff.facade;

import android.graphics.Bitmap;

import com.ff.facade.impl.DiskCacheImpl;
import com.ff.facade.impl.MemoryCacheImpl;
import com.ff.facade.impl.NetWorkLoaderImpl;
import com.ff.facade.thing.DiskCache;
import com.ff.facade.thing.MemoryCache;
import com.ff.facade.thing.NetWorkLoader;

/**
 * description: 图片获取的外观模式
 * author: FF
 * time: 2019-07-09 23:17
 */
public class ImageLoader {

    private final String url;
    private final MemoryCache memoryCache;
    private final DiskCache diskCache;
    private final NetWorkLoader netWorkLoader;

    public ImageLoader(String url) {
        this.url = url;
        memoryCache = new MemoryCacheImpl();
        diskCache = new DiskCacheImpl();
        netWorkLoader = new NetWorkLoaderImpl();
    }

    Bitmap loader() {
        Bitmap result = memoryCache.findByMemory(url);
        if (result == null) {
            result = diskCache.findByDisk(url);
            if (result == null) {
                result = netWorkLoader.loaderImageFromNet(url);
            }
        }
        return result;
    }
}

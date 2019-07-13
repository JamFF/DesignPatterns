package com.ff.facade.thing;

import android.graphics.Bitmap;

/**
 * description: 内存缓存
 * author: FF
 * time: 2019-07-09 23:05
 */
public interface MemoryCache {

    // 从内存中寻找缓存图片
    Bitmap findByMemory(String url);
}

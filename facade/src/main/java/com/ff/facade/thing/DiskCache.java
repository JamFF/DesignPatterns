package com.ff.facade.thing;

import android.graphics.Bitmap;

/**
 * description: 磁盘缓存
 * author: FF
 * time: 2019-07-09 23:06
 */
public interface DiskCache {

    // 内存中没有找到，从本地文件中寻找缓存图片
    Bitmap findByDisk(String url);
}

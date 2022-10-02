package com.ff.facade.thing;

import android.graphics.Bitmap;

/**
 * description: 网络获取
 * author: FF
 * time: 2019-07-09 23:07
 */
public interface NetWorkLoader {

    // 内存中没找到，本地文件中没找到，开始从网络加载图片
    Bitmap loaderImageFromNet(String url);
}

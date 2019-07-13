package com.ff.facade.impl;

import android.graphics.Bitmap;

import com.ff.facade.thing.DiskCache;

/**
 * description:
 * author: FF
 * time: 2019-07-09 23:10
 */
public class DiskCacheImpl implements DiskCache {

    @Override
    public Bitmap findByDisk(String url) {
        System.out.println("findByDisk: ");
        return null;
    }
}

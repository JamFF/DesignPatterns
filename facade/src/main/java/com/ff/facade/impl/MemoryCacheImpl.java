package com.ff.facade.impl;

import android.graphics.Bitmap;

import com.ff.facade.thing.MemoryCache;

/**
 * description:
 * author: FF
 * time: 2019-07-09 23:08
 */
public class MemoryCacheImpl implements MemoryCache {

    @Override
    public Bitmap findByMemory(String url) {
        System.out.println("findByMemory: ");
        return null;
    }
}

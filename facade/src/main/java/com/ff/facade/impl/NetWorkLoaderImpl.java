package com.ff.facade.impl;

import com.ff.facade.thing.NetWorkLoader;

import java.io.InputStream;

/**
 * description:
 * author: FF
 * time: 2019-07-09 23:11
 */
public class NetWorkLoaderImpl implements NetWorkLoader {

    @Override
    public InputStream loaderImageFromNet(String url) {
        System.out.println("loaderImageFromNet: ");
        return null;
    }
}

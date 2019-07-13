package com.ff.adapter.example;

import com.ff.adapter.example.reader.ISReader;

import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * description:
 * author: FF
 * time: 2019-07-10 22:14
 */
public class ISReaderImpl implements ISReader {

    private InputStream is;

    public ISReaderImpl(InputStream is) {
        this.is = is;
    }

    @Override
    public InputStreamReader getISReader() {
        return new InputStreamReader(is);
    }
}

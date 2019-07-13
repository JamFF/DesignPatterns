package com.ff.adapter.example.reader;

import java.io.BufferedReader;

/**
 * description:
 * author: FF
 * time: 2019-07-10 22:12
 */
public class ReaderAdapter implements BReader {

    private ISReader mISReader;

    public ReaderAdapter(ISReader isReader){
        mISReader = isReader;
    }

    @Override
    public BufferedReader getBReader() {
        return new BufferedReader(mISReader.getISReader());
    }
}

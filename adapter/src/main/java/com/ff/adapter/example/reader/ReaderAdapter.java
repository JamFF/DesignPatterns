package com.ff.adapter.example.reader;

import java.io.BufferedReader;

/**
 * description: 适配器，将ISReader接口转换为BReader接口，将InputStreamReader转换为BufferedReader
 * author: FF
 * time: 2019-07-10 22:12
 */
public class ReaderAdapter implements BReader {

    private final ISReader mISReader;

    public ReaderAdapter(ISReader isReader){
        mISReader = isReader;
    }

    @Override
    public BufferedReader getBReader() {
        return new BufferedReader(mISReader.getISReader());
    }
}

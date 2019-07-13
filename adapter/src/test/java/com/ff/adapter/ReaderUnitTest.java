package com.ff.adapter;

import com.ff.adapter.example.ISReaderImpl;
import com.ff.adapter.example.reader.BReader;
import com.ff.adapter.example.reader.ReaderAdapter;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReaderUnitTest {

    /*@Test
    public BufferedReader getReader(File file) throws IOException {
        // 文件字节流
        FileInputStream fis = new FileInputStream(file);

        // 字节读取流
        InputStreamReader isr = new InputStreamReader(fis);

        // 缓冲字节流
        return new BufferedReader(isr);
    }*/

    @Test
    public void reader() throws IOException {
        FileInputStream fis = new FileInputStream(new File("/Users/ff/text.txt"));
        BReader bReader = new ReaderAdapter(new ISReaderImpl(fis));

        BufferedReader reader = bReader.getBReader();
        System.out.println(reader.readLine());
    }
}

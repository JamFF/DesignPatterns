package com.ff.adapter;

import com.ff.adapter.example.reader.BReader;
import com.ff.adapter.example.reader.ISReader;
import com.ff.adapter.example.reader.ReaderAdapter;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderUnitTest {

    /**
     * 传统写法
     */
    @Test
    public void getReader() throws IOException {
        // 文件字节流
        FileInputStream fis = new FileInputStream("README.md");

        // 字节读取流
        InputStreamReader isr = new InputStreamReader(fis);

        // 缓冲字节流
        BufferedReader reader = new BufferedReader(isr);
        System.out.println(reader.readLine());
    }

    /**
     * 适配器写法
     */
    @Test
    public void reader() throws IOException {
        // 文件字节流
        FileInputStream fis = new FileInputStream("README.md");

        // 创建适配器，将ISReader接口转换为BReader接口
        BReader adapter = new ReaderAdapter(new ISReader() {
            @Override
            public InputStreamReader getISReader() {
                return new InputStreamReader(fis);
            }
        });

        // 从适配器中获取缓冲字节流
        BufferedReader reader = adapter.getBReader();
        System.out.println(reader.readLine());
    }
}

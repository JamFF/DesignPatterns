package com.ff.facade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * description: 外观模式（门面模式）
 * 隐藏了系统的复杂性，为子系统中的一组接口提供了一个统一的访问接口，高内聚、低耦合
 * 把一系列复杂的功能，封装成一个接口提供给开发者使用
 * <p>
 * 模拟场景：在单元测试中图片加载，使用外观模式
 * author: FF
 * time: 2019-07-09 22:50
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

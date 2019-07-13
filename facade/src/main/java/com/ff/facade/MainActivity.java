package com.ff.facade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * description: 外观模式（门面模式）
 * 隐藏了系统的复杂性，为子系统中的一组接口提供了一个统一的访问接口，高内聚、低耦合
 * 在单元测试中模拟图片加载，使用外观模式
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

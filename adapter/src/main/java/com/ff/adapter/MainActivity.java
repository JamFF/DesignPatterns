package com.ff.adapter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

/**
 * description: 适配器模式：将一个类的接口转换成开发者希望的另一个接口。适配器模式让那些接口不兼容的类可以在一起工作
 * author: FF
 * time: 2019-07-10 14:30
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

package com.ff.factory;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import com.ff.factory.impl.ApiImpl;

/**
 * description: 工厂模式
 * 核心：提供一个创建对象的功能，不需要关心具体实现
 * author: FF
 * time: 2019-07-09 17:08
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 常规编码
//        Api api = new ApiImpl();
//        api.createUser();

        // 简单工厂：降低了模块间的耦合度
        Api api = SampleFactory.createApi();
        Log.d(TAG, "SampleFactory: " + api.createUser());

        // 拓展：根据参数产生不同的实现
        api = ParameterFactory.createApi(1);
        Log.d(TAG, "ParameterFactory 1: " + api.createUser());

        api = ParameterFactory.createApi(2);
        Log.d(TAG, "ParameterFactory 2: " + api.createUser());


        try {
            // 根据配置文件产生不同的实现
            api = PropertiesFactory.createApi(this);
            Log.d(TAG, "PropertiesFactory: " + api.createUser());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

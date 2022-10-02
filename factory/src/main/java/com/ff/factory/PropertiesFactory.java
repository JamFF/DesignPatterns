package com.ff.factory;

import android.content.Context;

import java.io.InputStream;
import java.util.Properties;

/**
 * description: 读取配置文件的工厂
 * author: FF
 * time: 2019-07-09 22:28
 */
public class PropertiesFactory {

    public static Api createApi(Context context) throws Exception {
        // 加载配置文件
        Properties props = new Properties();
        // 如果放入了 app/src/main/assets文件中
        InputStream inputStream = context.getAssets().open("config.properties");

        // 如果放入了 app/src/main/res/raw 文件中
        // InputStream inputStream = context.getResources().openRawResource("config.properties");

        // Java的写法
        // InputStream inputStream = PropertiesFactory.class.getResourceAsStream("assets/config.properties");
        props.load(inputStream);

        Class<?> clazz = Class.forName(props.getProperty("create_a"));
        return (Api) clazz.newInstance();
    }
}

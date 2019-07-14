package com.ff.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ff.mvvm.databinding.ActivityMainBinding;
import com.ff.mvvm.vm.LoginViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 1、必须先ReBuilder，2、书写代码绑定
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        new LoginViewModel(binding);
    }
}

package com.tcsl.databindingtest.bindingadapter;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tcsl.databindingtest.R;
import com.tcsl.databindingtest.databinding.ActivityMain2Binding;

public class Main2Activity extends AppCompatActivity {

    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2);
        binding.setUser(new User("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488884001&di=738446e200e3c6e4742273f45eef5fab&imgtype=jpg&er=1&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F14%2F63%2F20%2F86M58PICKVm_1024.jpg", R.mipmap.ic_launcher));
    }
}

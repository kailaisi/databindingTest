package com.tcsl.dagger;

import android.app.Application;

import com.tcsl.dagger.component.BaseComponent;
import com.tcsl.dagger.component.DaggerBaseComponent;
import com.tcsl.dagger.module.BaseModule;

/**
 * 描述:
 * <p/>作者：wjx
 * <p/>创建时间: 2017/4/24 17:39
 */
public class MyApplication extends Application {
    public static MyApplication instance;
    private BaseComponent baseComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        baseComponent = DaggerBaseComponent.builder().baseModule(new BaseModule()).build();
    }

    public BaseComponent getBaseComponent() {
        return baseComponent;
    }

    public static MyApplication getInstance() {
        return instance;
    }
}

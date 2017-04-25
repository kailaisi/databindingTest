package com.tcsl.dagger.component;

import com.tcsl.dagger.Main2Activity;
import com.tcsl.dagger.module.SecondModule;
import com.tcsl.dagger.interfaces.PerActivity;

import dagger.Component;

/**
 * 描述:
 * <p/>作者：wjx
 * <p/>创建时间: 2017/4/24 16:03
 */
@PerActivity
@Component(modules = SecondModule.class,dependencies = BaseComponent.class)
public interface SecondComponent {
    void inject(Main2Activity activity);
}

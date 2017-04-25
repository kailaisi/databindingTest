package com.tcsl.dagger.component;

import com.tcsl.dagger.ClothHandler;
import com.tcsl.dagger.module.BaseModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 描述:
 * <p/>作者：wjx
 * <p/>创建时间: 2017/4/24 16:30
 */
@Singleton
@Component(modules = BaseModule.class)
public interface BaseComponent {
    ClothHandler getHandler();
}

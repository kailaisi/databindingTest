package com.tcsl.dagger.module;

import com.tcsl.dagger.ClothHandler;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 描述:
 * <p/>作者：wjx
 * <p/>创建时间: 2017/4/24 16:31
 */
@Module
public class BaseModule {
    @Singleton
    @Provides
    public ClothHandler getClothHandler() {
        return new ClothHandler();
    }
}

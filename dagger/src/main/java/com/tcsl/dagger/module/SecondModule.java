package com.tcsl.dagger.module;

import com.tcsl.dagger.ClothHandler;
import com.tcsl.dagger.bean.Cloth;
import com.tcsl.dagger.interfaces.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * 描述:
 * <p/>作者：wjx
 * <p/>创建时间: 2017/4/24 16:03
 */
@Module
public class SecondModule {

    @Provides
    @PerActivity
    public Cloth getCloth() {
        Cloth cloth = new Cloth();
        cloth.setColor("蓝色");
        return cloth;
    }
}

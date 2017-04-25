package com.tcsl.dagger.module;

import com.tcsl.dagger.ClothHandler;
import com.tcsl.dagger.MainContract;
import com.tcsl.dagger.bean.Cloth;
import com.tcsl.dagger.bean.Clothes;
import com.tcsl.dagger.interfaces.PerActivity;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    private final MainContract.View mView;

    public MainModule(MainContract.View view) {
        mView = view;
    }

    @Provides
    public MainContract.View provideMainView() {
        return mView;
    }

    @PerActivity

    @Provides
    public Cloth getRedCloth() {
        Cloth cloth = new Cloth();
        cloth.setColor("红色");
        return cloth;
    }

    @Provides
    public Clothes getClothes(Cloth cloth) {
        return new Clothes(cloth);
    }
}

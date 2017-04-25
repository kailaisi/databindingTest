package com.tcsl.dagger.component;

import com.tcsl.dagger.DaggerActivity;
import com.tcsl.dagger.module.MainModule;
import com.tcsl.dagger.interfaces.PerActivity;

import dagger.Component;

@PerActivity

@Component(modules = MainModule.class, dependencies = BaseComponent.class)
public interface MainComponent {
    void inject(DaggerActivity activity);
}

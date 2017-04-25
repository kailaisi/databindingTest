package com.tcsl.databindingtest.dragger;

import dagger.Component;

@Component(modules = MainModule.class)
public interface MainComponent {
    void inject(DraggerActivity activity);
}

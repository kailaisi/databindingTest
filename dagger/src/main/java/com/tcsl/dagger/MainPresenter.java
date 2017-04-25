package com.tcsl.dagger;

import javax.inject.Inject;

import dagger.Component;

public class MainPresenter {
    //MainContract是个接口，View是他的内部接口，这里看做View接口即可
    private MainContract.View mView;

    @Inject
    MainPresenter(MainContract.View view) {
        mView = view;
    }

    public void loadData() {
        //回调方法成功时
        mView.updateUI();
    }

}

package com.tcsl.databindingtest.dragger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tcsl.databindingtest.R;

import javax.inject.Inject;

public class DraggerActivity extends AppCompatActivity implements MainContract.View {
    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dragger);

        DaggerMainComponent.builder()
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
        //调用Presenter方法加载数据
        mainPresenter.loadData();
    }

    @Override
    public void updateUI() {

    }
}



package com.tcsl.dagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.tcsl.dagger.bean.Cloth;
import com.tcsl.dagger.component.DaggerSecondComponent;
import com.tcsl.dagger.module.SecondModule;

import javax.inject.Inject;

public class Main2Activity extends AppCompatActivity {

    @Inject
    Cloth blueCloth;
    @Inject
    ClothHandler mHandler;
    private TextView mTvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        DaggerSecondComponent.builder()
                .secondModule(new SecondModule())
                .baseComponent(MyApplication.getInstance().getBaseComponent())
                .build()
                .inject(this);
        setInfo();
    }

    private void setInfo() {
        mTvInfo.setText(blueCloth + "加工后，变味了" + mHandler.handler(blueCloth) + "handler 地址:" + mHandler);
    }

    private void initView() {
        mTvInfo = (TextView) findViewById(R.id.tv_info);
    }
}

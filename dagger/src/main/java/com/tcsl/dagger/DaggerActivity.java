package com.tcsl.dagger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tcsl.dagger.bean.Cloth;
import com.tcsl.dagger.bean.Clothes;
import com.tcsl.dagger.bean.Shoe;
import com.tcsl.dagger.component.DaggerMainComponent;
import com.tcsl.dagger.module.MainModule;

import javax.inject.Inject;

public class DaggerActivity extends AppCompatActivity implements MainContract.View, View.OnClickListener {
    @Inject
    MainPresenter mainPresenter;
    @Inject
    Cloth redCloth;
    @Inject
    Shoe shoe;
    @Inject
    Clothes clothes;
    @Inject
    ClothHandler mHandler;
    private TextView mTv;
    private Button mBtnMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dragger);
        initView();

        DaggerMainComponent.builder()
                .mainModule(new MainModule(this))
                .baseComponent(MyApplication.getInstance().getBaseComponent())
                .build()
                .inject(this);
        //调用Presenter方法加载数据
        mainPresenter.loadData();
    }

    @Override
    public void updateUI() {
        String str = "我有" + clothes + shoe;
        mTv.setText(redCloth + "加工后，变味了" + mHandler.handler(redCloth) + "handler 地址:" + mHandler);
    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
        mTv.setOnClickListener(this);
        mBtnMove = (Button) findViewById(R.id.btn_move);
        mBtnMove.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_move:
                startActivity(new Intent(this,Main2Activity.class));
                break;
        }
    }
}



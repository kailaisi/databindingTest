package com.tcsl.databindingtest.simple;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tcsl.databindingtest.R;
import com.tcsl.databindingtest.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private ArrayList<String> mList;
    private UserInfo userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initValues();
    }

    private void initValues() {
        mList = new ArrayList<>();
        mList.add("welcome");
        userInfo = new UserInfo("hello", "", mList, "");
        mBinding.setItem(userInfo);
        mBinding.setPresenter(new MainPresenter(userInfo));
    }
}

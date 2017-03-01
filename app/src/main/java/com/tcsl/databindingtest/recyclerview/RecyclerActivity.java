package com.tcsl.databindingtest.recyclerview;

import android.databinding.*;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

import com.tcsl.databindingtest.R;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView rvData;
    private RelativeLayout activityRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        initView();
        ArrayList<User> mInfo = new ArrayList<>();
        for (int i=0;i<200;i++) {
            mInfo.add(new User("ceshi"+i));
        }
       // DataBindingAdapter madpater = new DataBindingAdapter(mInfo);
        MyBindingAdapter madpater=new MyBindingAdapter(this,mInfo);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvData.setLayoutManager(manager);
        rvData.setItemAnimator(new DefaultItemAnimator());
        rvData.setAdapter(madpater);
    }

    private void initView() {
        rvData = (RecyclerView) findViewById(R.id.rv_data);
        activityRecycler = (RelativeLayout) findViewById(R.id.activity_recycler);
    }
}

package com.tcsl.databindingtest.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.tcsl.databindingtest.R;
import com.tcsl.databindingtest.lib.recycler.OnItemClickListener;
import com.tcsl.databindingtest.recyclerview.bean.result;

import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView rvData;
    private RelativeLayout activityRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        initView();
        initValues();
    }

    private void initValues() {
        DataModel model=new DataModel();
        List<result.ResultsBean> mInfo = model.initDatas();
        MyBindingAdapter madpater=new MyBindingAdapter(this,mInfo);
        madpater.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View root, int position) {
                Toast.makeText(RecyclerActivity.this, "position:" + position, Toast.LENGTH_SHORT).show();
            }
        });
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

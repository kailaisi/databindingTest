package com.tcsl.databindingtest.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.tcsl.databindingtest.R;
import com.tcsl.databindingtest.lib.httpLoader.HttpUtils;
import com.tcsl.databindingtest.lib.httpLoader.ResultCallback;
import com.tcsl.databindingtest.lib.recycler.OnItemClickListener;
import com.tcsl.databindingtest.recyclerview.bean.result;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView rvData;
    private RelativeLayout activityRecycler;
    private MyBindingAdapter madpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        initView();
        initValues();
    }

    private void initValues() {
        DataModel model = new DataModel();
        final List<result.ResultsBean> mInfo = new ArrayList<>();
        HttpUtils.with(this)
                .url("http://gank.io/api/data/福利/10/2")
                .execute(new ResultCallback<result>() {
                    @Override
                    public void onSccessed(result result) {
                        mInfo.addAll(result.getResults());
                        madpater.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Request request, Exception e) {
                        Log.d("RecyclerActivity", e.getMessage());
                    }
                });
        madpater = new MyBindingAdapter(this, mInfo);
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

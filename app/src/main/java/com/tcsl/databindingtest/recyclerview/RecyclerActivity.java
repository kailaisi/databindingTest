package com.tcsl.databindingtest.recyclerview;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
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

public class RecyclerActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, RequestLoadMoreListener {

    private RecyclerView rvData;
    private RelativeLayout activityRecycler;
    private MyBindingAdapter madpater;
    private SwipeRefreshLayout mSrLy;
    private List<result.ResultsBean> mInfo;
    private String baseUrl = "http://gank.io/api/data/福利/10/";
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        initView();
        initValues();
    }

    private void initValues() {
        mInfo = new ArrayList<>();
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
        mSrLy.setOnRefreshListener(this);
        madpater.setLoadMoreListener(this);
        HttpUtils.with(this)
                .url(baseUrl + index)
                .execute(new ResultCallback<result>() {
                    @Override
                    public void onSuccess(result result) {
                        mInfo.addAll(result.getResults());
                        madpater.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Request request, Exception e) {
                        Log.d("RecyclerActivity", e.getMessage());
                    }
                });
    }

    private void initView() {
        rvData = (RecyclerView) findViewById(R.id.rv_data);
        activityRecycler = (RelativeLayout) findViewById(R.id.activity_recycler);
        mSrLy = (SwipeRefreshLayout) findViewById(R.id.sr_ly);
    }

    @Override
    public void onRefresh() {
        madpater.setEnableLoadMore(false);
        index = 0;
        HttpUtils.with(this).url(baseUrl + index).execute(new ResultCallback<result>() {

            @Override
            public void onSuccess(result result) {
                mInfo.clear();
                mInfo.addAll(result.getResults());
                madpater.notifyDataSetChanged();
                mSrLy.setRefreshing(false);
                madpater.setEnableLoadMore(true);
            }

            @Override
            public void onError(Request request, Exception e) {
                madpater.setEnableLoadMore(false);
            }
        });
    }

    @Override
    public void onLoadMoreRequest() {
        mSrLy.setEnabled(false);
        index++;
        HttpUtils.with(this).url(baseUrl + index).execute(new ResultCallback<result>() {
            @Override
            public void onSuccess(final result result) {
                mInfo.addAll(result.getResults());
                madpater.notifyDataSetChanged();
                mSrLy.setEnabled(true);
                if (result.getResults().size() < 30) {
                    madpater.loadMoreEnd(true);
                } else {
                    madpater.loadMoreComplete();
                }
            }

            @Override
            public void onError(Request request, Exception e) {
                mSrLy.setEnabled(true);
                madpater.loadMoreFail();
            }
        });

    }
}

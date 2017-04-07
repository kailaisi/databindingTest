package com.tcsl.databindingtest.recyclerview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.view.View;
import android.widget.Toast;

import com.tcsl.databindingtest.R;
import com.tcsl.databindingtest.databinding.ActivityRecyclerBinding;
import com.tcsl.databindingtest.lib.httpLoader.ResultCallback;
import com.tcsl.databindingtest.lib.recycler.OnItemClickListener;
import com.tcsl.databindingtest.recyclerview.bean.result;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

public class RecyclerActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, RequestLoadMoreListener {
    /**
     * 每页请求的数据
     */
    private static final int PAGER_SIZE = 10;
    private MyBindingAdapter madpater;
    private List<result.ResultsBean> mInfo;
    private ActivityRecyclerBinding bind;
    private JuejinViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_recycler);
        model = new JuejinViewModel(this);
        bind.setModel(model);
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
        bind.rvData.setItemAnimator(new DefaultItemAnimator());
        bind.rvData.setAdapter(madpater);
        bind.srLy.setOnRefreshListener(this);
        madpater.setLoadMoreListener(this);
        model.initData();
    }

    @Override
    public void onRefresh() {
        madpater.setEnableLoadMore(false);
        model.refresh(new ResultCallback<result>() {
            @Override
            public void onSuccess(result result) {
                madpater.setNewData(result.getResults());
                bind.srLy.setRefreshing(false);
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
        model.refreshEnable.set(false);
        model.loadmore(new ResultCallback<result>() {
            @Override
            public void onSuccess(final result result) {
                madpater.addData(result.getResults());
                model.refreshEnable.set(true);
                if (result.getResults().size() < PAGER_SIZE) {
                    madpater.loadMoreEnd(true);
                } else {
                    madpater.loadMoreComplete();
                }
            }

            @Override
            public void onError(Request request, Exception e) {
                model.refreshEnable.set(true);
                madpater.loadMoreFail();
            }
        });

    }
}

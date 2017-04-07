package com.tcsl.databindingtest.recyclerview;

import android.content.Context;
import android.databinding.ObservableBoolean;
import android.util.Log;
import android.view.View;

import com.tcsl.databindingtest.lib.httpLoader.HttpUtils;
import com.tcsl.databindingtest.lib.httpLoader.ResultCallback;
import com.tcsl.databindingtest.recyclerview.bean.result;

/**
 * 描述:
 * <p/>作者：wjx
 * <p/>创建时间: 2017/3/30 13:41
 */
public class JuejinViewModel {
    private static final String TAG = "JuejinViewModel";
    private String baseUrl = "http://gank.io/api/data/福利/10/";
    private int index = 1;
    private Context mContext;
    /**
     * 是否允许下拉刷新
     */
    public ObservableBoolean refreshEnable = new ObservableBoolean();

    public JuejinViewModel(Context context) {
        refreshEnable.set(true);
        mContext = context;
    }

    public void loadmore(ResultCallback<result> listener) {
        refreshEnable.set(false);
        index++;
        HttpUtils.with(mContext).url(baseUrl + index).execute(listener);
    }

    public void refresh(ResultCallback<result> resultCallback) {
        index = 1;
        HttpUtils.with(mContext).url(baseUrl + index).execute(resultCallback);
    }

    public void initData() {
    }

    public void onclick(View view){
        Log.i(TAG, "onclick: ");
    }
}

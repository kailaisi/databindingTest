package com.tcsl.databindingtest.simple;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;

/**
 * 描述:
 * <p/>作者：wjx
 * <p/>创建时间: 2017/2/21 13:58
 */
public class MainPresenter {
    private UserInfo mBean;

    public MainPresenter(UserInfo mBean) {
        this.mBean = mBean;
    }

    public void onSetListSize(View view) {
        Log.d("MainPresenter", "onSetListSize");
    }

    public void onTextChanged(CharSequence sequence, int start, int before, int count) {
        if (!TextUtils.isEmpty(sequence.toString())) {
            mBean.setUnit(null);
            mBean.setRental(sequence.toString());
        } else {
            mBean.setUnit("Hello DataBinding");
        }
    }

    public void onItemClick(UserInfo info) {
        Log.d("MainPresenter", "info.getList():" + info.getList());
    }

}

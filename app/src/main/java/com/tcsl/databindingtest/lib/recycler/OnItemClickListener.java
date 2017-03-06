package com.tcsl.databindingtest.lib.recycler;

import android.view.View;

/**
 * 描述:点击回调
 * <p/>作者：wjx
 * <p/>创建时间: 2017/2/5 11:28
 */
public interface OnItemClickListener {
    /**
     * @param root     点击的view
     * @param position 点击的位置
     */
    void onItemClick(View root, int position);
}

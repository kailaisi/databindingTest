package com.tcsl.databindingtest.recyclerview;

import android.databinding.BindingAdapter;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ImageView;

import com.tcsl.databindingtest.lib.imageLoader.ImageLoaderOptions;
import com.tcsl.databindingtest.lib.imageLoader.ImageLoaderStrategyManager;
import com.tcsl.databindingtest.lib.imageLoader.PicassoLoader;

/**
 * 描述:
 * <p/>作者：wjx
 * <p/>创建时间: 2017/2/28 17:28
 */
public class SwipeRefreshLayoutAttrAdapter {
    @BindingAdapter(value = {"refreshEnable"})
    public static void refreshEnable(SwipeRefreshLayout layout, Boolean enable) {
        layout.setEnabled(enable);
    }
}

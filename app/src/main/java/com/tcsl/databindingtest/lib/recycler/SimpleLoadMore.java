package com.tcsl.databindingtest.lib.recycler;

import com.tcsl.databindingtest.R;

/**
 * 描述:
 * <p/>作者：wjx
 * <p/>创建时间: 2017/3/21 11:45
 */
class SimpleLoadMore extends LoadMoreView {
    @Override
    public int getLayoutId() {
        return R.layout.quick_view_load_more;
    }

    @Override
    protected int getLoadingViewId() {
        return R.id.load_more_loading_view;
    }

    @Override
    protected int getLoadFailViewId() {
        return R.id.load_more_load_fail_view;
    }

    @Override
    protected int getLoadEndViewId() {
        return R.id.load_more_load_end_view;
    }
}

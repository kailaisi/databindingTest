package com.tcsl.databindingtest.lib.recycler;

/**
 * 描述:加载更多的View，包含加载中，加载完成，加载失败等得状态
 * <p/>作者：wjx
 * <p/>创建时间: 2017/3/20 16:50
 */
class LoadMoreView {
    public static final int STATUS_DEFAULT = 1;
    public static final int STATUS_LOADING = 2;
    public static final int STATUS_FAIL = 3;
    public static final int STATUS_END = 4;
    /**
     * 当前状态
     */
    private int mLoadMoreStatus = STATUS_DEFAULT;

    /**
     * 设置当前状态
     */
    public void setLoadMoreStatus(int loadMoreStatus) {
        mLoadMoreStatus = loadMoreStatus;
    }

    /**
     * 获取当前状态
     *
     * @return
     */
    public int getLoadMoreStatus() {
        return mLoadMoreStatus;
    }
}

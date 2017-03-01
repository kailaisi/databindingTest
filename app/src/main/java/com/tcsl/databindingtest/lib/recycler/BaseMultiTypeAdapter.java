package com.tcsl.databindingtest.lib.recycler;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.util.SparseArray;
import android.view.ViewGroup;

import java.util.List;

/**
 * 描述:多条目adapter
 * <p/>作者：wjx
 * <p/>创建时间: 2017/2/23 17:30
 */
public abstract class BaseMultiTypeAdapter<T extends MultiItemEntity, K extends BaseViewHolder> extends BaseRecyclerViewAdapter<T, K> {
    private SparseArray<Integer> layouts;

    public BaseMultiTypeAdapter(Context context, List<T> mDatas) {
        super(context, mDatas);
    }

    @Override
    protected int getDefaultItemViewType(int position) {
        T data = mDatas.get(position);
        if (data instanceof MultiItemEntity) {
            return data.getItemType();
        } else {
            throw new RuntimeException("item must be instanceof MultiItemEntity ");
        }
    }

    @Override
    protected K onCreateDefViewHolder(ViewGroup parent, int viewType) {
        int layout = layouts.get(viewType);
        return super.createBaseViewHolder(parent, layout);
    }

    /**
     * 增加item类型
     *
     * @param layoutResId
     */
    protected void addItemType(int type, @LayoutRes int layoutResId) {
        if (layouts == null) {
            layouts = new SparseArray<>();
        }
        layouts.put(type, layoutResId);
    }
}

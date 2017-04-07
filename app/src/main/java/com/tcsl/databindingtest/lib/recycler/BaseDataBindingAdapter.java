package com.tcsl.databindingtest.lib.recycler;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 描述:
 * <p/>作者：wjx
 * <p/>创建时间: 2017/2/24 13:49
 */
public abstract class BaseDataBindingAdapter<T, K extends BaseDataBindingViewHolder> extends BaseRecyclerViewAdapter<T, K> {

    public BaseDataBindingAdapter(Context context, List<T> mDatas) {
        super(context, mDatas);
    }

    @Override
    protected View getItemView( int layoutResId,ViewGroup parent) {
        ViewDataBinding binding = DataBindingUtil.inflate(mLayoutInflater, layoutResId, parent, false);
        if (binding == null) {
            return super.getItemView(layoutResId,parent);
        }
        View view = binding.getRoot();
        view.setTag(binding);
        return view;
    }


    @Override
    protected void convert(K viewHolder, T t) {
        ViewDataBinding binding = viewHolder.getBinding();
        bind(viewHolder,binding,t);
        binding.executePendingBindings();
    }

    protected abstract void bind(K viewHolder, ViewDataBinding binding, T t);

}

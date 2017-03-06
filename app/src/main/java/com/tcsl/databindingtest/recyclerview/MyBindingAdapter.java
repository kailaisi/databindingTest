package com.tcsl.databindingtest.recyclerview;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.view.View;

import com.tcsl.databindingtest.R;
import com.tcsl.databindingtest.databinding.ItemDataBindingBinding;
import com.tcsl.databindingtest.lib.recycler.BaseDataBindingAdapter;
import com.tcsl.databindingtest.lib.recycler.BaseDataBindingViewHolder;
import com.tcsl.databindingtest.recyclerview.bean.result;

import java.util.List;

/**
 * 描述:
 * <p/>作者：wjx
 * <p/>创建时间: 2017/2/24 16:10
 */
public class MyBindingAdapter extends BaseDataBindingAdapter<result.ResultsBean,BaseDataBindingViewHolder> {
    public MyBindingAdapter(Context context, List mDatas) {
        super(context, mDatas);
    }

    @Override
    public int getItemLayout() {
        return R.layout.item_data_binding;
    }

    @Override
    protected void bind(ViewDataBinding binding, result.ResultsBean resultsBean) {
        if(binding==null){
            return;
        }
        ItemDataBindingBinding bind= (ItemDataBindingBinding) binding;
        View root = bind.getRoot();
        bind.setIteminfo(resultsBean);
        bind.setAdapter(this);
    }
}

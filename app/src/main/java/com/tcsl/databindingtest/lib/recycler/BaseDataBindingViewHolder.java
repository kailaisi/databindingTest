package com.tcsl.databindingtest.lib.recycler;

import android.databinding.ViewDataBinding;
import android.view.View;

/**
 * 描述:
 * <p/>作者：wjx
 * <p/>创建时间: 2017/2/24 14:33
 */
public class BaseDataBindingViewHolder extends BaseViewHolder {
    ViewDataBinding binding;

    public BaseDataBindingViewHolder(View itemView) {
        super(itemView);
        binding = (ViewDataBinding) itemView.getTag();
        if (null == binding) {
            throw new IllegalArgumentException("adatper must be BaseDataBindingAdapter");
        }
    }

    public ViewDataBinding getBinding() {
        return binding;
    }
}


package com.tcsl.databindingtest.recyclerview;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tcsl.databindingtest.databinding.ItemDataBindingBinding;

import java.util.ArrayList;

/**
 * 描述:
 * <p/>作者：wjx
 * <p/>创建时间: 2017/2/22 11:41
 */
public class DataBindingAdapter extends RecyclerView.Adapter<DataBindingAdapter.ViewHolder> {

    private ArrayList<User> mInfo;

    public DataBindingAdapter(ArrayList<User> mInfo) {
        this.mInfo = mInfo;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = ViewHolder.create(LayoutInflater.from(parent.getContext()), parent);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindTo(mInfo.get(position));
    }

    @Override
    public int getItemCount() {
        return mInfo == null ? 0 : mInfo.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private View rootView;
        private TextView tvName;
        private ItemDataBindingBinding bind;
        public ViewHolder(ItemDataBindingBinding binding) {
            super(binding.getRoot());
            bind = binding;
        }

        static ViewHolder create(LayoutInflater inflater, ViewGroup parent) {
            ItemDataBindingBinding binding = ItemDataBindingBinding.inflate(inflater, parent, false);
            return new ViewHolder(binding);
        }

        public void bindTo(User user) {
            //bind.setIteminfo(user);
            //bind.executePendingBindings();
        }
    }
}

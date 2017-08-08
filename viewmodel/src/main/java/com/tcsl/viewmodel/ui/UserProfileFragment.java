package com.tcsl.viewmodel.ui;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tcsl.viewmodel.R;
import com.tcsl.viewmodel.bean.User;
import com.tcsl.viewmodel.viewmodel.UserProfileViewModel;

public class UserProfileFragment extends LifecycleFragment {
    private static final String UID_KEY = "uid";
    private UserProfileViewModel viewModel;
    private TextView mTvName;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String userId = "1";
        viewModel = ViewModelProviders.of(this).get(UserProfileViewModel.class);
        viewModel.init(userId);
        viewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                mTvName.setText(user.getName());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_profile, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mTvName = (TextView) view.findViewById(R.id.tv_name);
    }
}

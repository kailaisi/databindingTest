package com.tcsl.viewmodel.responsity;

import com.tcsl.viewmodel.viewmodel.UserProfileViewModel;

import dagger.Component;

/**
 * 描述:
 * <p/>作者：wjx
 * <p/>创建时间: 2017/8/7 14:56
 */
@Component
public interface UserComponents {
    void inject(UserProfileViewModel model);
}

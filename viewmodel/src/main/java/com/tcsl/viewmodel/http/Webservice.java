package com.tcsl.viewmodel.http;

import okhttp3.Call;

/**
 * 描述:
 * <p/>作者：wjx
 * <p/>创建时间: 2017/8/7 11:37
 */
public interface Webservice {
    Call getUser(int userId);
}

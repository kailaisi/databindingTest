package com.tcsl.databindingtest.lib.httpLoader;

import android.content.Context;

import java.util.Map;

/**
 * 描述:网络架构提供的接口
 * <p/>作者：wjx
 * <p/>创建时间: 2017/3/9 13:54
 */
public interface HttpEngine {
    // post 提交
    void post(Context context, String url, Map<String, Object> params, ResultCallback httpCallBack, boolean cache);

    // get 提交
    void get(Context context, String url, Map<String, Object> params, ResultCallback httpCallBack, HttpOption option);

    // 取消请求
    void cancelWithContext(Context context);//取消以context作为tag的请求

    void cancel();//取消某次请求
    // 下载文件
    // 上传文件
    // https添加安全证书
}

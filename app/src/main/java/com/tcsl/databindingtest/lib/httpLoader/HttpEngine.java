package com.tcsl.databindingtest.lib.httpLoader;

import java.util.Map;

/**
 * 描述:网络架构提供的接口
 * <p/>作者：wjx
 * <p/>创建时间: 2017/3/9 13:54
 */
public interface HttpEngine {
    // post 提交
    void post(Object tag, String url, Map<String, Object> params, ResultCallback httpCallBack, HttpOption option);

    // get 提交
    void get(Object tag, String url, Map<String, Object> params, ResultCallback httpCallBack, HttpOption option);

    // 取消请求
    void cancelWithTag(Object tag);//可以以context为参数，也可以设置固定的tag
    // 下载文件
    // 上传文件
    // https添加安全证书
}

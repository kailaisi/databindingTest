package com.tcsl.databindingtest.lib.httpLoader;

import android.content.Context;
import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:网络请求对外暴漏的接口
 * <p/>作者：wjx
 * <p/>创建时间: 2017/3/9 14:14
 */
public class HttpUtils {
    // 上下文
    private Context mContext;
    // 网络访问引擎
    private static HttpEngine mHttpEngine = new OkHttpEngine();
    // 接口地址
    private String mUrl;
    // 请求参数
    private Map<String, Object> mParams;
    // get请求标识
    private final int GET_REQUEST = 0x0011;
    // post请求标识
    private final int POST_REQUEST = 0x0022;
    // 请求的方式
    private int mRequestMethod = GET_REQUEST;

    // 是否缓存
    private boolean mCache = false;

    // 切换引擎
    public void exchangeEngine(HttpEngine httpEngine) {
        this.mHttpEngine = httpEngine;
    }

    // 可以在Application中配置HttpEngine
    public static void initEngine(HttpEngine httpEngine) {
       mHttpEngine = httpEngine;
    }

    private HttpUtils(Context context) {
        this.mContext = context;
        mParams = new HashMap<>();
    }

    public static HttpUtils with(Context context) {
        return new HttpUtils(context);
    }

    public HttpUtils url(String url) {
        mUrl = url;
        return this;
    }

    public HttpUtils cache(boolean mCache) {
        this.mCache = mCache;
        return this;
    }

    // 执行方法
    public void execute(ResultCallback httpCallBack) {
        if (TextUtils.isEmpty(mUrl)) {
            throw new NullPointerException("访问路径不能为空");
        }

        if (mRequestMethod == GET_REQUEST) {
            get(mUrl, mParams, httpCallBack);
        }

        if (mRequestMethod == POST_REQUEST) {
        }
    }

    public void cancel(Context context){
        mHttpEngine.cancelWithContext(context);
    }
    private void get(String mUrl, Map<String, Object> mParams, ResultCallback callback) {
        mHttpEngine.get(mContext, mUrl, mParams, callback,null);
    }


}

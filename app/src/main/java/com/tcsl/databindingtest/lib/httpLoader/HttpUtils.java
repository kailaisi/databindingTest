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
    // 网络访问引擎,设置为static变量，是为了可以在application中或其他位置设置一次即可，不需要每次网络请求都进行设置
    private static HttpEngine mHttpEngine = new OkHttpEngine();
    // 接口地址
    private String mUrl;
    // 请求参数
    private Map<String, Object> mParams;
    // get请求标识
    private final static int GET_REQUEST = 0x0011;
    // post请求标识
    private final static int POST_REQUEST = 0x0022;
    // 请求的方式
    private int mRequestMethod = GET_REQUEST;

    // 是否缓存
    private boolean mCache = false;
    private Object mTag;

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

    /**
     * 设置url
     *
     * @param url
     * @return
     */
    public HttpUtils url(String url) {
        mUrl = url;
        return this;
    }

    /**
     * 设置tag
     *
     * @param tag
     * @return
     */
    public HttpUtils tag(Object tag) {
        mTag = tag;
        return this;
    }

    /**
     * 设置是否进行缓存
     *
     * @param mCache
     * @return
     */
    public HttpUtils cache(boolean mCache) {
        this.mCache = mCache;
        return this;
    }

    /**
     * 设置为post请求方式
     *
     * @return
     */
    public HttpUtils post() {
        mRequestMethod = POST_REQUEST;
        return this;
    }

    /**
     * 设置为get请求
     *
     * @return
     */
    public HttpUtils get() {
        mRequestMethod = GET_REQUEST;
        return this;
    }

    /**
     * 设置参数
     *
     * @param str
     * @param obj
     * @return
     */
    public HttpUtils addParams(String str, Object obj) {
        if (mParams == null) {
            mParams = new HashMap<>();
        }
        mParams.put(str, obj);
        return this;
    }


    // 执行方法
    public void execute(ResultCallback httpCallBack) {
        if (TextUtils.isEmpty(mUrl)) {
            throw new NullPointerException("访问路径不能为空");
        }
        if (mRequestMethod == GET_REQUEST) {
            get(mUrl, mParams, httpCallBack);
        } else if (mRequestMethod == POST_REQUEST) {
            post(mUrl,mParams,httpCallBack);
        }
    }

    private void post(String mUrl, Map<String, Object> mParams, ResultCallback callback) {
        if (mTag != null) {
            mHttpEngine.post(mTag, mUrl, mParams, callback, null);
        } else if (mContext != null) {
            mHttpEngine.post(mContext, mUrl, mParams, callback, null);
        } else {
            mHttpEngine.post("", mUrl, mParams, callback, null);
        }
    }

    private void get(String mUrl, Map<String, Object> mParams, ResultCallback callback) {
        if (mTag != null) {
            mHttpEngine.get(mTag, mUrl, mParams, callback, null);
        } else if (mContext != null) {
            mHttpEngine.get(mContext, mUrl, mParams, callback, null);
        } else {
            mHttpEngine.get("", mUrl, mParams, callback, null);
        }
    }

    /**
     * 根据页面取消所有的网络请求
     *
     * @param context
     */
    public void cancel(Context context) {
        mHttpEngine.cancelWithTag(context);
    }

    /**
     * cancel request with tag
     *
     * @param tag
     */
    public void cancelWithTag(String tag) {
        mHttpEngine.cancelWithTag(tag);
    }

}

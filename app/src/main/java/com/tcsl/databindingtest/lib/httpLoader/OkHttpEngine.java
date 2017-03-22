package com.tcsl.databindingtest.lib.httpLoader;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * 描述:
 * <p/>作者：wjx
 * <p/>创建时间: 2017/3/9 14:15
 */
public class OkHttpEngine implements HttpEngine {
    private final String TAG = getClass().getSimpleName();
    private Handler mHandler;
    private Gson mGson;

    public OkHttpEngine() {
        mHandler = new Handler(Looper.getMainLooper());
        mGson = new Gson();
    }


    private static OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
            .connectTimeout(30000, TimeUnit.MILLISECONDS)
            .readTimeout(30000, TimeUnit.MILLISECONDS)
            .writeTimeout(30000, TimeUnit.MILLISECONDS)
            .build();
    Interceptor cacheInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Response originalResponse = chain.proceed(chain.request());
            return originalResponse.newBuilder()
                    .removeHeader("Pragma")//Pragma:no-cache。在HTTP/1.1协议中，它的含义和Cache-Control:no-cache相同。为了确保缓存生效
                    //          .header("Cache-Control", String.format("max-age=%d", maxCacheAge))//添加缓存请求头
                    .build();
        }
    };

    //client.setCache(new Cache(context.getCacheDir(),maxCacheSize));
    @Override
    public void post(Object tag, String url, Map<String, Object> params, ResultCallback callback, HttpOption option) {
        Request.Builder builder = new Request.Builder();
        MediaType parse = MediaType.parse("text/json;charset=utf-8");
        RequestBody body = RequestBody.create(parse, "str");
        builder.post(body);
        builder.url(url)
                .tag(tag);
        Request req = builder.build();
        deliveryResult(callback, req);
    }

    @Override
    public void get(Object tag, String url, Map<String, Object> params, ResultCallback callback, HttpOption option) {
        Request.Builder builder = new Request.Builder();
        builder.url(url)
                .get()
                .tag(tag);
        Request req = builder.build();
        deliveryResult(callback, req);
    }

    @Override
    public void cancelWithTag(Object tag) {
        if (tag == null) {
            return;
        }
        synchronized (mOkHttpClient.dispatcher().getClass()) {
            for (Call call : mOkHttpClient.dispatcher().queuedCalls()) {
                if (call.request().tag().equals(tag))
                    call.cancel();
            }
            for (Call call : mOkHttpClient.dispatcher().runningCalls()) {
                if (call.request().tag().equals(tag))
                    call.cancel();
            }
        }
    }

    /**
     * 发送网络请求，并进行回调
     *
     * @param callback
     * @param request
     */
    private void deliveryResult(final ResultCallback callback, final Request request) {
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                sendFailedStringCallback(request, e, callback);
            }

            @Override
            public void onResponse(final Call call, final Response response) throws IOException {
                try {
                    final String result = response.body().string();
                    Log.d("OkHttpEngine", result);
                    if (callback.mType == String.class) {
                        sendSuccessResultCallback(result, callback);
                    } else {
                        Object o = mGson.fromJson(result, callback.mType);
                        sendSuccessResultCallback(o, callback);
                    }
                } catch (IOException e) {
                    sendFailedStringCallback(response.request(), e, callback);
                }
            }
        });
    }

    /**
     * 发送失败信息，因为okhttp的返回是在io线程，因此，需要进行线程的转化
     *
     * @param request
     * @param e
     * @param callback
     */
    private void sendFailedStringCallback(final Request request, final Exception e, final ResultCallback callback) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if (callback != null)
                    callback.onError(request, e);
            }
        });
    }

    /**
     * 发送成功信息，因为okhttp的返回是在io线程，因此，需要进行线程的转化
     *
     * @param object
     * @param callback
     */
    private void sendSuccessResultCallback(final Object object, final ResultCallback callback) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if (callback != null) {
                    callback.onSuccess(object);
                }
            }
        });
    }

}

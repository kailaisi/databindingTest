package com.tcsl.viewmodel.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 描述:
 * <p/>作者：wjx
 * <p/>创建时间: 2017/8/7 13:22
 */
public class ApiConnector {
    private static final String BASE_URL = "";
    private Retrofit mRetrofit;
    private static ApiConnector mInstance;

    private ApiConnector() {
        init();
    }

    private void init() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new LoggerInterceptor());
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getApiCreator() {
        return mRetrofit;
    }

    /**
     * 获取网络请求单例
     *
     * @return
     */
    public static ApiConnector getInstance() {
        if (mInstance == null) {
            synchronized (ApiConnector.class) {
                if (mInstance == null) {
                    mInstance = new ApiConnector();
                }
            }
        }
        return mInstance;
    }
}

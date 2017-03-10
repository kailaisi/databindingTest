package com.tcsl.databindingtest.lib.httpLoader;

import android.test.AndroidTestCase;

import okhttp3.Request;

/**
 * 描述:
 * <p/>作者：wjx
 * <p/>创建时间: 2017/3/10 17:38
 */
public class HttpUtilsTest extends AndroidTestCase {
    private static final String TAG = "HttpUtilsTest";
    public void setUp() throws Exception {
        super.setUp();

    }

    public void testExchangeEngine() throws Exception {
    }

    public void testInitEngine() throws Exception {

    }

    public void testWith() throws Exception {

    }

    public void testUrl() throws Exception {

    }

    public void testCache() throws Exception {

    }

    public void testExecute() throws Exception {
        HttpUtils.with(getContext())
                .url("http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/2")
                .execute(new ResultCallback<String>() {

                    @Override
                    public void onSccessed(String result) {
                        System.out.println(result);
                        assertNull(result);
                    }

                    @Override
                    public void onError(Request request, Exception e) {
                        System.out.println(e.getMessage());
                        assertNull(request.body().toString());
                    }
                });
    }

    public void testCancel() throws Exception {

    }

}

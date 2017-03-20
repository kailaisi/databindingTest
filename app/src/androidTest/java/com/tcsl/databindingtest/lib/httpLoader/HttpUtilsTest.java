package com.tcsl.databindingtest.lib.httpLoader;

import android.test.AndroidTestCase;
import android.util.Log;

import com.google.gson.Gson;
import com.tcsl.databindingtest.httpwithiinfo.Result;
import com.tcsl.databindingtest.recyclerview.bean.result;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;

import java.util.List;

import okhttp3.Request;

import static android.content.ContentValues.TAG;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

/**
 * 描述:
 * <p/>作者：wjx
 * <p/>创建时间: 2017/3/18 15:48
 */
public class HttpUtilsTest extends AndroidTestCase {
    @Captor
    ArgumentCaptor<ResultCallback> captor;
    private static final String TAG = "HttpUtilsTest";
    ResultCallback<result> resultCallback;

    public void testExecute1() throws Exception {
String str="{\n" +
        "  \"error\": false, \n" +
        "  \"results\": [\n" +
        "    {\n" +
        "      \"_id\": \"58b88a2f421aa90efc4fb649\", \n" +
        "      \"createdAt\": \"2017-03-03T05:10:07.940Z\", \n" +
        "      \"desc\": \"3-3\", \n" +
        "      \"publishedAt\": \"2017-03-03T12:13:36.333Z\", \n" +
        "      \"source\": \"chrome\", \n" +
        "      \"type\": \"\\u798f\\u5229\", \n" +
        "      \"url\": \"http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-02-16906481_1495916493759925_5770648570629718016_n.jpg\", \n" +
        "      \"used\": true, \n" +
        "      \"who\": \"daimajia\"\n" +
        "    }, \n" +
        "    {\n" +
        "      \"_id\": \"58b76cb9421aa90f131785e4\", \n" +
        "      \"createdAt\": \"2017-03-02T08:52:09.811Z\", \n" +
        "      \"desc\": \"3-02\", \n" +
        "      \"publishedAt\": \"2017-03-02T11:51:29.672Z\", \n" +
        "      \"source\": \"chrome\", \n" +
        "      \"type\": \"\\u798f\\u5229\", \n" +
        "      \"url\": \"http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-02-17077393_314135475655975_7855162741030387712_n.jpg\", \n" +
        "      \"used\": true, \n" +
        "      \"who\": \"\\u4ee3\\u7801\\u5bb6\"\n" +
        "    }, \n" +
        "    {\n" +
        "      \"_id\": \"58b60881421aa90efc4fb627\", \n" +
        "      \"createdAt\": \"2017-03-01T07:32:17.106Z\", \n" +
        "      \"desc\": \"3-1\", \n" +
        "      \"publishedAt\": \"2017-03-01T12:03:57.461Z\", \n" +
        "      \"source\": \"chrome\", \n" +
        "      \"type\": \"\\u798f\\u5229\", \n" +
        "      \"url\": \"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-28-15057157_446684252387131_4267811446148038656_n.jpg\", \n" +
        "      \"used\": true, \n" +
        "      \"who\": \"daimajia\"\n" +
        "    }, \n" +
        "    {\n" +
        "      \"_id\": \"58b4b764421aa90efc4fb61b\", \n" +
        "      \"createdAt\": \"2017-02-28T07:33:56.976Z\", \n" +
        "      \"desc\": \"2-28\", \n" +
        "      \"publishedAt\": \"2017-02-28T11:45:44.815Z\", \n" +
        "      \"source\": \"chrome\", \n" +
        "      \"type\": \"\\u798f\\u5229\", \n" +
        "      \"url\": \"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-27-tumblr_om1aowIoKa1qbw5qso1_540.jpg\", \n" +
        "      \"used\": true, \n" +
        "      \"who\": \"daimajia\"\n" +
        "    }, \n" +
        "    {\n" +
        "      \"_id\": \"58b372a7421aa90f033450e0\", \n" +
        "      \"createdAt\": \"2017-02-27T08:28:23.976Z\", \n" +
        "      \"desc\": \"2-27\", \n" +
        "      \"publishedAt\": \"2017-02-27T11:31:40.141Z\", \n" +
        "      \"source\": \"chrome\", \n" +
        "      \"type\": \"\\u798f\\u5229\", \n" +
        "      \"url\": \"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-27-002809.jpg\", \n" +
        "      \"used\": true, \n" +
        "      \"who\": \"daimajia\"\n" +
        "    }, \n" +
        "    {\n" +
        "      \"_id\": \"58af7dca421aa957f9dd6dcc\", \n" +
        "      \"createdAt\": \"2017-02-24T08:26:50.512Z\", \n" +
        "      \"desc\": \"2-24\", \n" +
        "      \"publishedAt\": \"2017-02-24T11:47:11.416Z\", \n" +
        "      \"source\": \"chrome\", \n" +
        "      \"type\": \"\\u798f\\u5229\", \n" +
        "      \"url\": \"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-24-16906635_1749384985376684_7563808952991875072_n.jpg\", \n" +
        "      \"used\": true, \n" +
        "      \"who\": \"daimajia\"\n" +
        "    }, \n" +
        "    {\n" +
        "      \"_id\": \"58ae32e1421aa957f9dd6dbe\", \n" +
        "      \"createdAt\": \"2017-02-23T08:54:57.835Z\", \n" +
        "      \"desc\": \"2-23\", \n" +
        "      \"publishedAt\": \"2017-02-23T11:50:23.116Z\", \n" +
        "      \"source\": \"chrome\", \n" +
        "      \"type\": \"\\u798f\\u5229\", \n" +
        "      \"url\": \"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-23-16906361_1846962082218545_7116720067412230144_n.jpg\", \n" +
        "      \"used\": true, \n" +
        "      \"who\": \"daimajia\"\n" +
        "    }, \n" +
        "    {\n" +
        "      \"_id\": \"58acdc37421aa93d376f74fd\", \n" +
        "      \"createdAt\": \"2017-02-22T08:32:55.801Z\", \n" +
        "      \"desc\": \"2-22\", \n" +
        "      \"publishedAt\": \"2017-02-22T11:43:57.286Z\", \n" +
        "      \"source\": \"chrome\", \n" +
        "      \"type\": \"\\u798f\\u5229\", \n" +
        "      \"url\": \"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-22-16789541_749566998525174_1194252851069583360_n.jpg\", \n" +
        "      \"used\": true, \n" +
        "      \"who\": \"daimajia \"\n" +
        "    }, \n" +
        "    {\n" +
        "      \"_id\": \"58ab0187421aa93d3d15aa3b\", \n" +
        "      \"createdAt\": \"2017-02-20T22:47:35.276Z\", \n" +
        "      \"desc\": \"2-21\", \n" +
        "      \"publishedAt\": \"2017-02-21T11:14:09.564Z\", \n" +
        "      \"source\": \"chrome\", \n" +
        "      \"type\": \"\\u798f\\u5229\", \n" +
        "      \"url\": \"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-20-16788512_385322578500460_8844315265740046336_n.jpg\", \n" +
        "      \"used\": true, \n" +
        "      \"who\": \"daimajia\"\n" +
        "    }, \n" +
        "    {\n" +
        "      \"_id\": \"58a9752b421aa93d3d15aa31\", \n" +
        "      \"createdAt\": \"2017-02-19T18:36:27.16Z\", \n" +
        "      \"desc\": \"2-20\", \n" +
        "      \"publishedAt\": \"2017-02-20T11:56:22.616Z\", \n" +
        "      \"source\": \"chrome\", \n" +
        "      \"type\": \"\\u798f\\u5229\", \n" +
        "      \"url\": \"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-19-16789884_666922016823652_4719569931841044480_n.jpg\", \n" +
        "      \"used\": true, \n" +
        "      \"who\": \"daimajia\"\n" +
        "    }\n" +
        "  ]\n" +
        "}";
        Gson gson = new Gson();
        result result = gson.fromJson(str, result.class);
        List<com.tcsl.databindingtest.recyclerview.bean.result.ResultsBean> results = result.getResults();
        HttpUtils url = HttpUtils.with(getContext())
                .url("http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/2");
        url.execute(resultCallback);
        verify(url).execute(captor.capture());
        verify(resultCallback).onSccessed((com.tcsl.databindingtest.recyclerview.bean.result) results);
    }

}

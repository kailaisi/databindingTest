package com.tcsl.databindingtest.recyclerview;

import com.google.gson.Gson;
import com.tcsl.databindingtest.recyclerview.bean.result;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * <p/>作者：wjx
 * <p/>创建时间: 2017/3/3 11:54
 */
public class DataModel {
    public List<result.ResultsBean> initDatas() {
        Gson gson = new Gson();
        result result = gson.fromJson(getInfo(), result.class);
        List<result.ResultsBean> results = result.getResults();
        return results;
    }

    private String getInfo() {
        return "{\"error\":false,\"results\":[{\"_id\":\"58a504d1421aa966366d05ce\",\"createdAt\":\"2017-02-16T09:48:01.526Z\",\"desc\":\"2-16\",\"publishedAt\":\"2017-02-16T10:07:37.13Z\",\"source\":\"chrome\",\"type\":\"福利\",\"url\":\"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-16-16790004_607292222809583_5160406710837313536_n.jpg\",\"used\":true,\"who\":\"daimajia\"},{\"_id\":\"58a39d1c421aa966366d05c0\",\"createdAt\":\"2017-02-15T08:13:16.351Z\",\"desc\":\"2-15\",\"publishedAt\":\"2017-02-15T11:24:04.127Z\",\"source\":\"chrome\",\"type\":\"福利\",\"url\":\"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-15-16464434_414363458902323_3665858302006263808_n.jpg\",\"used\":true,\"who\":\"daimajia\"},{\"_id\":\"58a24ce0421aa901ef40579f\",\"createdAt\":\"2017-02-14T08:18:40.781Z\",\"desc\":\"2-14\",\"publishedAt\":\"2017-02-14T11:42:37.303Z\",\"source\":\"chrome\",\"type\":\"福利\",\"url\":\"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-14-16123260_755771577930478_8918176595718438912_n.jpg\",\"used\":true,\"who\":\"daimajia\"},{\"_id\":\"58a10619421aa901f7902c6a\",\"createdAt\":\"2017-02-13T09:04:25.996Z\",\"desc\":\"2-13\",\"publishedAt\":\"2017-02-13T11:54:17.922Z\",\"source\":\"chrome\",\"type\":\"福利\",\"url\":\"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-13-16464498_1247940031909047_2763412151866490880_n.jpg\",\"used\":true,\"who\":\"daimajia\"},{\"_id\":\"589d31a2421aa9270bc7332e\",\"createdAt\":\"2017-02-10T11:21:06.747Z\",\"desc\":\"2-10\",\"publishedAt\":\"2017-02-10T11:38:22.122Z\",\"source\":\"chrome\",\"type\":\"福利\",\"url\":\"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-10-16465759_171779496648995_128281069584646144_n.jpg\",\"used\":true,\"who\":\"代码家\"},{\"_id\":\"589bb252421aa92dc0dfd3bf\",\"createdAt\":\"2017-02-09T08:05:38.361Z\",\"desc\":\"2-9\",\"publishedAt\":\"2017-02-09T11:46:26.70Z\",\"source\":\"chrome\",\"type\":\"福利\",\"url\":\"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-09-16583339_172818256542563_353855393375453184_n.jpg\",\"used\":true,\"who\":\"daimajia\"},{\"_id\":\"589a7161421aa92db8a0041b\",\"createdAt\":\"2017-02-08T09:16:17.678Z\",\"desc\":\"2-8\",\"publishedAt\":\"2017-02-08T11:39:51.371Z\",\"source\":\"chrome\",\"type\":\"福利\",\"url\":\"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-08-16230686_191036801373876_4789664128824246272_n.jpg\",\"used\":true,\"who\":\"daimajia\"},{\"_id\":\"58993f2c421aa970b84523ab\",\"createdAt\":\"2017-02-07T11:29:48.689Z\",\"desc\":\"2-7\",\"publishedAt\":\"2017-02-07T11:37:03.683Z\",\"source\":\"chrome\",\"type\":\"福利\",\"url\":\"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-07-032924.jpg\",\"used\":true,\"who\":\"daimajia\"},{\"_id\":\"5897d9e9421aa970bb154891\",\"createdAt\":\"2017-02-06T10:05:29.443Z\",\"desc\":\"2-6\",\"publishedAt\":\"2017-02-06T11:36:12.36Z\",\"source\":\"chrome\",\"type\":\"福利\",\"url\":\"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-06-16464762_1304611439576933_4803269855073533952_n.jpg\",\"used\":true,\"who\":\"代码家\"},{\"_id\":\"58947b15421aa970bb154878\",\"createdAt\":\"2017-02-03T20:44:05.311Z\",\"desc\":\"2-4\",\"publishedAt\":\"2017-02-04T11:47:42.336Z\",\"source\":\"chrome\",\"type\":\"福利\",\"url\":\"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-03-123209.jpg\",\"used\":true,\"who\":\"代码家\"}," +
                "{\n" +
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
                "    },{\"_id\":\"58947b15421aa970bb154878\",\"createdAt\":\"2017-02-03T20:44:05.311Z\",\"desc\":\"2-4\",\"publishedAt\":\"2017-02-04T11:47:42.336Z\",\"source\":\"chrome\",\"type\":\"福利\",\"url\":\"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-03-123209.jpg\",\"used\":true,\"who\":\"代码家\"},{\"_id\":\"5893f544421aa90e69b17f8c\",\"createdAt\":\"2017-02-03T11:13:08.967Z\",\"desc\":\"2-3\",\"publishedAt\":\"2017-02-03T11:52:22.806Z\",\"source\":\"chrome\",\"type\":\"福利\",\"url\":\"http://7xi8d6.com1.z0.glb.clouddn.com/16123958_1630476787257847_7576387494862651392_n.jpg\",\"used\":true,\"who\":\"daimajia\"},{\"_id\":\"58857746421aa95eae2d92b3\",\"createdAt\":\"2017-01-23T11:23:50.64Z\",\"desc\":\"1-23\",\"publishedAt\":\"2017-01-23T11:35:32.450Z\",\"source\":\"chrome\",\"type\":\"福利\",\"url\":\"http://7xi8d6.com1.z0.glb.clouddn.com/16124047_121657248344062_4191645221970247680_n.jpg\",\"used\":true,\"who\":\"代码家\"},{\"_id\":\"58841c08421aa95ea9de7a0c\",\"createdAt\":\"2017-01-22T10:42:16.648Z\",\"desc\":\"1-22\",\"publishedAt\":\"2017-01-22T11:39:29.779Z\",\"source\":\"chrome\",\"type\":\"福利\",\"url\":\"http://7xi8d6.com1.z0.glb.clouddn.com/16229501_482786908558452_6858241750058663936_n.jpg\",\"used\":true,\"who\":\"daimajia\"},{\"_id\":\"58817e1e421aa9119735ac5f\",\"createdAt\":\"2017-01-20T11:03:58.727Z\",\"desc\":\"1-20\",\"publishedAt\":\"2017-01-20T11:50:52.750Z\",\"source\":\"chrome\",\"type\":\"福利\",\"url\":\"http://7xi8d6.com1.z0.glb.clouddn.com/2017-01-20-030332.jpg\",\"used\":true,\"who\":\"daimajia\"},{\"_id\":\"58802bea421aa9119a6ca6ab\",\"createdAt\":\"2017-01-19T11:00:58.838Z\",\"desc\":\"1-19\",\"publishedAt\":\"2017-01-19T11:40:09.118Z\",\"source\":\"chrome\",\"type\":\"福利\",\"url\":\"http://7xi8d6.com1.z0.glb.clouddn.com/16124351_1863111260639981_4361246625721483264_n.jpg\",\"used\":true,\"who\":\"daimajia\"},{\"_id\":\"587c6073421aa91194ca0e2c\",\"createdAt\":\"2017-01-16T13:56:03.417Z\",\"desc\":\"1-16\",\"publishedAt\":\"2017-01-16T14:12:18.71Z\",\"source\":\"chrome\",\"type\":\"福利\",\"url\":\"http://ww3.sinaimg.cn/large/610dc034gw1fbsfgssfrwj20u011h48y.jpg\",\"used\":true,\"who\":\"daimajia\"},{\"_id\":\"5878471d421aa9119735ac13\",\"createdAt\":\"2017-01-13T11:18:53.183Z\",\"desc\":\"1-13\",\"publishedAt\":\"2017-01-13T11:58:16.991Z\",\"source\":\"chrome\",\"type\":\"福利\",\"url\":\"http://ww3.sinaimg.cn/large/610dc034gw1fbou2xsqpaj20u00u0q4h.jpg\",\"used\":true,\"who\":\"daimajia\"},{\"_id\":\"5876e811421aa9315bfbe85f\",\"createdAt\":\"2017-01-12T10:21:05.74Z\",\"desc\":\"1-12\",\"publishedAt\":\"2017-01-12T11:30:59.369Z\",\"source\":\"chrome\",\"type\":\"福利\",\"url\":\"http://ww2.sinaimg.cn/large/0060lm7Tgw1fbnmsjogt9j30u00u0jvv.jpg\",\"used\":true,\"who\":\"daimajia\"},{\"_id\":\"58758a6e421aa9315bfbe854\",\"createdAt\":\"2017-01-11T09:29:18.702Z\",\"desc\":\"1-11\",\"publishedAt\":\"2017-01-11T12:05:20.787Z\",\"source\":\"chrome\",\"type\":\"福利\",\"url\":\"http://ww4.sinaimg.cn/large/0060lm7Tgw1fbmfo9is9hj30u00u0ai3.jpg\",\"used\":true,\"who\":\"daimajia\"}," +
                "{\"_id\":\"58745425421aa93161103dd7\",\"createdAt\":\"2017-01-10T11:25:25.871Z\",\"desc\":\"1-10\",\"publishedAt\":\"2017-01-10T11:33:19.525Z\",\"source\":\"chrome\",\"type\":\"福利\",\"url\":\"http://ww3.sinaimg.cn/large/610dc034gw1fbldexdog4j20u011h41b.jpg\",\"used\":true,\"who\":\"daimajia\"},{\"_id\":\"5872f7f2421aa9316407fb84\",\"createdAt\":\"2017-01-09T10:39:46.599Z\",\"desc\":\"1-9\",\"publishedAt\":\"2017-01-09T11:46:59.821Z\",\"source\":\"chrome\",\"type\":\"福利\",\"url\":\"http://ww1.sinaimg.cn/large/610dc034gw1fbk6h23k3ij20u00jymyw.jpg\",\"used\":true,\"who\":\"daunahu\"},{\"_id\":\"586e1aad421aa9315ea79905\",\"createdAt\":\"2017-01-05T18:06:37.810Z\",\"desc\":\"1-5\",\"publishedAt\":\"2017-01-06T13:20:19.591Z\",\"source\":\"chrome\",\"type\":\"福利\",\"url\":\"http://ww4.sinaimg.cn/large/610dc034gw1fbfwwsjh3zj20u00u00w1.jpg\",\"used\":true,\"who\":\"daimajia\"},{\"_id\":\"586d8f74421aa9316407fb56\",\"createdAt\":\"2017-01-05T08:12:36.360Z\",\"desc\":\"1-5\",\"publishedAt\":\"2017-01-05T13:18:10.185Z\",\"source\":\"chrome\",\"type\":\"福利\",\"url\":\"http://ww4.sinaimg.cn/large/610dc034jw1fbffqo6jjoj20u011hgpx.jpg\",\"used\":true,\"who\":\"daimajia \"},{\"_id\":\"586c63a6421aa94dc1ac0b02\",\"createdAt\":\"2017-01-04T10:53:26.957Z\",\"desc\":\"1-4\",\"publishedAt\":\"2017-01-04T11:39:01.326Z\",\"source\":\"chrome\",\"type\":\"福利\",\"url\":\"http://ww4.sinaimg.cn/large/610dc034jw1fbeerrs7aqj20u011htec.jpg\",\"used\":true,\"who\":\"daimajia\"},{\"_id\":\"586b0915421aa94dbbd82bcf\",\"createdAt\":\"2017-01-03T10:14:45.467Z\",\"desc\":\"1-3\",\"publishedAt\":\"2017-01-03T11:51:31.742Z\",\"source\":\"chrome\",\"type\":\"福利\",\"url\":\"http://ww3.sinaimg.cn/large/610dc034jw1fbd818kkwjj20u011hjup.jpg\",\"used\":true,\"who\":\"daimajia\"},{\"_id\":\"5865ad4e421aa94dbe2ccdb0\",\"createdAt\":\"2016-12-30T08:41:50.830Z\",\"desc\":\"12-30\",\"publishedAt\":\"2016-12-30T16:16:11.125Z\",\"source\":\"chrome\",\"type\":\"福利\",\"url\":\"http://ww4.sinaimg.cn/large/610dc034jw1fb8iv9u08ij20u00u0tc7.jpg\",\"used\":true,\"who\":\"daimajia\"},{\"_id\":\"58645be0421aa94dbbd82bac\",\"createdAt\":\"2016-12-29T08:42:08.389Z\",\"desc\":\"12-29\",\"publishedAt\":\"2016-12-29T11:56:56.946Z\",\"source\":\"chrome\",\"type\":\"福利\",\"url\":\"http://ww4.sinaimg.cn/large/610dc034gw1fb7d9am05gj20u011hq64.jpg\",\"used\":true,\"who\":\"daimajia\"},{\"_id\":\"58632374421aa9723d29b9ba\",\"createdAt\":\"2016-12-28T10:29:08.507Z\",\"desc\":\"12-28\",\"publishedAt\":\"2016-12-28T11:57:39.616Z\",\"source\":\"chrome\",\"type\":\"福利\",\"url\":\"http://ww1.sinaimg.cn/large/610dc034gw1fb6aqccs3nj20u00u0wk4.jpg\",\"used\":true,\"who\":\"daimajia\"},{\"_id\":\"5861d315421aa97240ef9f43\",\"createdAt\":\"2016-12-27T10:33:57.376Z\",\"desc\":\"12-27\",\"publishedAt\":\"2016-12-27T12:06:15.638Z\",\"source\":\"chrome\",\"type\":\"福利\",\"url\":\"http://ww3.sinaimg.cn/large/610dc034gw1fb558z2peqj20u00u00v9.jpg\",\"used\":true,\"who\":\"daimajia \"}]}";
    }
}

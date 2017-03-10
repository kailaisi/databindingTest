package com.tcsl.databindingtest.httpwithiinfo;

import java.util.List;

/**
 * 描述:网络请求返回的数据
 * <p/>作者：wjx
 * <p/>创建时间: 2017/3/9 15:33
 */
public class Result {

    /**
     * error : false
     * results : [{"_id":"58ae32e1421aa957f9dd6dbe","createdAt":"2017-02-23T08:54:57.835Z","desc":"2-23","publishedAt":"2017-02-23T11:50:23.116Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-23-16906361_1846962082218545_7116720067412230144_n.jpg","used":true,"who":"daimajia"},{"_id":"58acdc37421aa93d376f74fd","createdAt":"2017-02-22T08:32:55.801Z","desc":"2-22","publishedAt":"2017-02-22T11:43:57.286Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-22-16789541_749566998525174_1194252851069583360_n.jpg","used":true,"who":"daimajia "},{"_id":"58ab0187421aa93d3d15aa3b","createdAt":"2017-02-20T22:47:35.276Z","desc":"2-21","publishedAt":"2017-02-21T11:14:09.564Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-20-16788512_385322578500460_8844315265740046336_n.jpg","used":true,"who":"daimajia"},{"_id":"58a9752b421aa93d3d15aa31","createdAt":"2017-02-19T18:36:27.16Z","desc":"2-20","publishedAt":"2017-02-20T11:56:22.616Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-19-16789884_666922016823652_4719569931841044480_n.jpg","used":true,"who":"daimajia"},{"_id":"58a641a4421aa9662f429734","createdAt":"2017-02-17T08:19:48.413Z","desc":"2-17","publishedAt":"2017-02-17T11:31:19.996Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-17-16464474_721724277990542_654863958657728512_n.jpg","used":true,"who":"daimajia"},{"_id":"58a504d1421aa966366d05ce","createdAt":"2017-02-16T09:48:01.526Z","desc":"2-16","publishedAt":"2017-02-16T10:07:37.13Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-16-16790004_607292222809583_5160406710837313536_n.jpg","used":true,"who":"daimajia"},{"_id":"58a39d1c421aa966366d05c0","createdAt":"2017-02-15T08:13:16.351Z","desc":"2-15","publishedAt":"2017-02-15T11:24:04.127Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-15-16464434_414363458902323_3665858302006263808_n.jpg","used":true,"who":"daimajia"},{"_id":"58a24ce0421aa901ef40579f","createdAt":"2017-02-14T08:18:40.781Z","desc":"2-14","publishedAt":"2017-02-14T11:42:37.303Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-14-16123260_755771577930478_8918176595718438912_n.jpg","used":true,"who":"daimajia"},{"_id":"58a10619421aa901f7902c6a","createdAt":"2017-02-13T09:04:25.996Z","desc":"2-13","publishedAt":"2017-02-13T11:54:17.922Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-13-16464498_1247940031909047_2763412151866490880_n.jpg","used":true,"who":"daimajia"},{"_id":"589d31a2421aa9270bc7332e","createdAt":"2017-02-10T11:21:06.747Z","desc":"2-10","publishedAt":"2017-02-10T11:38:22.122Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-10-16465759_171779496648995_128281069584646144_n.jpg","used":true,"who":"代码家"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 58ae32e1421aa957f9dd6dbe
         * createdAt : 2017-02-23T08:54:57.835Z
         * desc : 2-23
         * publishedAt : 2017-02-23T11:50:23.116Z
         * source : chrome
         * type : 福利
         * url : http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-23-16906361_1846962082218545_7116720067412230144_n.jpg
         * used : true
         * who : daimajia
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }
    }
}

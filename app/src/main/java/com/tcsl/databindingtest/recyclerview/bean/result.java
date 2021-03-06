package com.tcsl.databindingtest.recyclerview.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableChar;

import java.util.List;

/**
 * 描述:
 * <p/>作者：wjx
 * <p/>创建时间: 2017/3/3 12:04
 */
public class result {

    /**
     * error : false
     * results : [{"_id":"58a504d1421aa966366d05ce","createdAt":"2017-02-16T09:48:01.526Z","desc":"2-16","publishedAt":"2017-02-16T10:07:37.13Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-16-16790004_607292222809583_5160406710837313536_n.jpg","used":true,"who":"daimajia"},{"_id":"58a39d1c421aa966366d05c0","createdAt":"2017-02-15T08:13:16.351Z","desc":"2-15","publishedAt":"2017-02-15T11:24:04.127Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-15-16464434_414363458902323_3665858302006263808_n.jpg","used":true,"who":"daimajia"},{"_id":"58a24ce0421aa901ef40579f","createdAt":"2017-02-14T08:18:40.781Z","desc":"2-14","publishedAt":"2017-02-14T11:42:37.303Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-14-16123260_755771577930478_8918176595718438912_n.jpg","used":true,"who":"daimajia"},{"_id":"58a10619421aa901f7902c6a","createdAt":"2017-02-13T09:04:25.996Z","desc":"2-13","publishedAt":"2017-02-13T11:54:17.922Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-13-16464498_1247940031909047_2763412151866490880_n.jpg","used":true,"who":"daimajia"},{"_id":"589d31a2421aa9270bc7332e","createdAt":"2017-02-10T11:21:06.747Z","desc":"2-10","publishedAt":"2017-02-10T11:38:22.122Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-10-16465759_171779496648995_128281069584646144_n.jpg","used":true,"who":"代码家"},{"_id":"589bb252421aa92dc0dfd3bf","createdAt":"2017-02-09T08:05:38.361Z","desc":"2-9","publishedAt":"2017-02-09T11:46:26.70Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-09-16583339_172818256542563_353855393375453184_n.jpg","used":true,"who":"daimajia"},{"_id":"589a7161421aa92db8a0041b","createdAt":"2017-02-08T09:16:17.678Z","desc":"2-8","publishedAt":"2017-02-08T11:39:51.371Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-08-16230686_191036801373876_4789664128824246272_n.jpg","used":true,"who":"daimajia"},{"_id":"58993f2c421aa970b84523ab","createdAt":"2017-02-07T11:29:48.689Z","desc":"2-7","publishedAt":"2017-02-07T11:37:03.683Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-07-032924.jpg","used":true,"who":"daimajia"},{"_id":"5897d9e9421aa970bb154891","createdAt":"2017-02-06T10:05:29.443Z","desc":"2-6","publishedAt":"2017-02-06T11:36:12.36Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-06-16464762_1304611439576933_4803269855073533952_n.jpg","used":true,"who":"代码家"},{"_id":"58947b15421aa970bb154878","createdAt":"2017-02-03T20:44:05.311Z","desc":"2-4","publishedAt":"2017-02-04T11:47:42.336Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-03-123209.jpg","used":true,"who":"代码家"}]
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

    public static class ResultsBean extends BaseObservable {
        /**
         * _id : 58a504d1421aa966366d05ce
         * createdAt : 2017-02-16T09:48:01.526Z
         * desc : 2-16
         * publishedAt : 2017-02-16T10:07:37.13Z
         * source : chrome
         * type : 福利
         * url : http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-16-16790004_607292222809583_5160406710837313536_n.jpg
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

        @Bindable
        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        @Bindable
        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        @Override
        public String toString() {
            return "ResultsBean{" +
                    "_id='" + _id + '\'' +
                    ", createdAt='" + createdAt + '\'' +
                    ", desc='" + desc + '\'' +
                    ", publishedAt='" + publishedAt + '\'' +
                    ", source='" + source + '\'' +
                    ", type='" + type + '\'' +
                    ", url='" + url + '\'' +
                    ", used=" + used +
                    ", who='" + who + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "result{" +
                "error=" + error +
                ", results=" + results +
                '}';
    }
}

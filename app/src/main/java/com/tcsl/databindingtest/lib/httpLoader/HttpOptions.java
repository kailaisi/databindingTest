package com.tcsl.databindingtest.lib.httpLoader;

/**
 * 描述:http的相关设置
 * <p/>作者：wjx
 * <p/>创建时间: 2017/3/9 15:32
 */
public class HttpOptions {
    boolean iscache;//是否进行缓存
    boolean iscookies;//是否支持cookies
    long readTimeout;
    long connetcTimeout;
    long writeTimeout;
int k;
    private HttpOptions(Builder builder) {
        iscache = builder.iscache;
        iscookies = builder.iscookies;
        readTimeout = builder.readTimeout;
        connetcTimeout = builder.connetcTimeout;
        writeTimeout = builder.writeTimeout;
    }


    public static Builder newBuilder(HttpOptions copy) {
        Builder builder = new Builder();
        builder.iscache = copy.iscache;
        builder.iscookies = copy.iscookies;
        builder.readTimeout = copy.readTimeout;
        builder.connetcTimeout = copy.connetcTimeout;
        builder.writeTimeout = copy.writeTimeout;
        return builder;
    }

    public static final class Builder {
        private boolean iscache;
        private boolean iscookies;
        private long readTimeout;
        private long connetcTimeout;
        private long writeTimeout;

        private Builder() {
        }

        public Builder iscache(boolean val) {
            iscache = val;
            return this;
        }

        public Builder iscookies(boolean val) {
            iscookies = val;
            return this;
        }

        public Builder readTimeout(long val) {
            readTimeout = val;
            return this;
        }

        public Builder connetcTimeout(long val) {
            connetcTimeout = val;
            return this;
        }

        public Builder writeTimeout(long val) {
            writeTimeout = val;
            return this;
        }

        public HttpOptions build() {
            return new HttpOptions(this);
        }
    }
}

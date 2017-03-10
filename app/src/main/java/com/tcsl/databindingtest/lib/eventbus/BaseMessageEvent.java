package com.tcsl.databindingtest.lib.eventbus;

/**
 * 描述:eventbus传递消息基类
 * <p/>作者：wjx
 * <p/>创建时间: 2017/3/6 16:14
 */
public class BaseMessageEvent<T> {
    /**
     * 信息码，不同的信息，具有不同的信息码
     */
    int code;
    /**
     * 信息类
     */
    T date;

    public BaseMessageEvent(int code, T date) {
        this.code = code;
        this.date = date;
    }

    public int getCode() {
        return code;
    }

    public T getT() {
        return date;
    }


}

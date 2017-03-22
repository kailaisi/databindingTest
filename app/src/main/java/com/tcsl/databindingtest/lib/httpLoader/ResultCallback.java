package com.tcsl.databindingtest.lib.httpLoader;

import com.google.gson.internal.$Gson$Types;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Request;

/**
 * 描述:
 * <p/>作者：wjx
 * <p/>创建时间: 2017/3/9 14:07
 */
public abstract class ResultCallback<T> {
    Type mType;

    public ResultCallback() {
        mType = getTypeParame(getClass());
    }

    public Type getTypeParame(Class<?> clazz) {
        Type superclass = clazz.getGenericSuperclass();
        if (superclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        ParameterizedType parameterized = (ParameterizedType) superclass;
        return $Gson$Types.canonicalize(parameterized.getActualTypeArguments()[0]);
    }

    public abstract void onSuccess(T result);

    public abstract void onError(Request request, Exception e);
}

package com.tcsl.dagger.interfaces;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * 描述:
 * <p/>作者：wjx
 * <p/>创建时间: 2017/4/24 15:53
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}

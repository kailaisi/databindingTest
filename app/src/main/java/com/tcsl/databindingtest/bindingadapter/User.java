package com.tcsl.databindingtest.bindingadapter;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.drawable.Drawable;


/**
 * 描述:
 * <p/>作者：wjx
 * <p/>创建时间: 2017/2/28 17:12
 */
public class User extends BaseObservable {
    private String image;
    private int error;

    public User(String image, int error) {
        this.image = image;
        this.error = error;
    }

    @Bindable
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Bindable
    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }
}

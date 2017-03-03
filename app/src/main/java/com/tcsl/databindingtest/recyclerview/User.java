package com.tcsl.databindingtest.recyclerview;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.tcsl.databindingtest.BR;


/**
 * 描述:
 * <p/>作者：wjx
 * <p/>创建时间: 2017/2/22 11:43
 */
public class User extends BaseObservable {
    private String name;
    private String image;
    private int error;

    public User(String name) {
        this.name = name;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
        notifyPropertyChanged(BR.image);
    }

    @Bindable
    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
        notifyPropertyChanged(BR.error);
    }
}

package com.tcsl.databindingtest.simple;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.tcsl.databindingtest.BR;

import java.util.List;

/**
 * 描述:
 * <p/>作者：wjx
 * <p/>创建时间: 2017/2/21 11:52
 */
public class UserInfo extends BaseObservable {
    private String unit;
    private String rental;
    private List<String> list;
    private String price;

    public UserInfo(String unit, String rental, List<String> list, String price) {
        this.unit = unit;
        this.rental = rental;
        this.list = list;
        this.price = price;
    }

    @Bindable
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
        notifyPropertyChanged(com.tcsl.databindingtest.BR.unit);
    }

    @Bindable
    public String getRental() {
        return rental;
    }

    public void setRental(String rental) {
        this.rental = rental;
  //      notifyPropertyChanged(BR.rental);
    }

    @Bindable
    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
        notifyPropertyChanged(BR.list);
    }

    @Bindable
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
        notifyPropertyChanged(BR.price);
    }
}

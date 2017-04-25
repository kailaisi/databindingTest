package com.tcsl.dagger.bean;

/**
 * 描述:布料类
 * <p/>作者：wjx
 * <p/>创建时间: 2017/4/21 15:41
 */
public class Cloth {
    private String color = "红色";

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return getColor() + "布料";
    }
}

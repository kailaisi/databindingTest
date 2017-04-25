package com.tcsl.dagger.bean;

/**
 * 描述:
 * <p/>作者：wjx
 * <p/>创建时间: 2017/4/21 15:50
 */
public class Clothes {
    Cloth cloth;

    public Clothes(Cloth cloth) {
        this.cloth = cloth;
    }

    @Override
    public String toString() {
        return cloth.getColor() + "的衣服";
    }

    public Cloth getCloth() {
        return cloth;
    }

    public void setCloth(Cloth cloth) {
        this.cloth = cloth;
    }
}

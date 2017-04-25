package com.tcsl.dagger;

import com.tcsl.dagger.bean.Cloth;
import com.tcsl.dagger.bean.Clothes;

/**
 * 描述:
 * <p/>作者：wjx
 * <p/>创建时间: 2017/4/24 16:02
 */
public class ClothHandler {
    public Clothes handler(Cloth cloth){
        return new Clothes(cloth);
    }
}

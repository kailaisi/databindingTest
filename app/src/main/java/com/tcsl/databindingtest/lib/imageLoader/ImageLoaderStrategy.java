package com.tcsl.databindingtest.lib.imageLoader;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

/**
 * 描述:
 * <p/>作者：wjx
 * <p/>创建时间: 2017/2/28 17:02
 */
public interface ImageLoaderStrategy{
    void showImage(View v, String url, ImageLoaderOptions options);
    void showImage(View v, int drawable,ImageLoaderOptions options);
}

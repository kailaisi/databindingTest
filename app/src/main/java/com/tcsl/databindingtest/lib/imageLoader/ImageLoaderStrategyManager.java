package com.tcsl.databindingtest.lib.imageLoader;

import android.view.View;

/**
 * 描述:图片加载封装管理类
 * 参考：https://gold.xitu.io/post/58b280b92f301e0068078669
 * <p/>作者：wjx
 * <p/>创建时间: 2017/2/28 17:47
 */
public class ImageLoaderStrategyManager implements ImageLoaderStrategy {
    public ImageLoaderStrategy getLoader() {
        return loader;
    }

    public void setLoader(ImageLoaderStrategy loader) {
        this.loader = loader;
    }

    private static ImageLoaderStrategy loader=new PicassoLoader();
    private static ImageLoaderStrategyManager ourInstance = new ImageLoaderStrategyManager();

    public static ImageLoaderStrategyManager getInstance() {
        return ourInstance;
    }

    private ImageLoaderStrategyManager() {
    }

    @Override
    public void showImage(View v, String url, ImageLoaderOptions options) {
        if (loader != null) {
            loader.showImage(v, url, options);
        }
    }

    @Override
    public void showImage(View v, int drawable, ImageLoaderOptions options) {
        if (loader != null) {
            loader.showImage(v, drawable, options);
        }
    }
}

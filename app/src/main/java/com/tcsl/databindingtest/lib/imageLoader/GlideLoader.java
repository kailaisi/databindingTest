package com.tcsl.databindingtest.lib.imageLoader;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;

/**
 * 描述:封装的Glide图片加载
 * 参考：http://blog.csdn.net/fancylovejava/article/details/44747759
 * <p/>作者：wjx
 * <p/>创建时间: 2017/3/1 18:06
 */
public class GlideLoader implements ImageLoaderStrategy {
    @Override
    public void showImage(View v, String url, ImageLoaderOptions options) {
        if (v instanceof ImageView) {
            ImageView view = (ImageView) v;
            DrawableTypeRequest load = Glide.with(v.getContext()).load(url);
            loadOption(load, options).into(view);
        }
    }

    @Override
    public void showImage(View v, int drawable, ImageLoaderOptions options) {
        if (v instanceof ImageView) {
            ImageView view = (ImageView) v;
            DrawableTypeRequest load = Glide.with(v.getContext()).load(drawable);
            loadOption(load, options).into(view);
        }
    }

    private DrawableTypeRequest loadOption(DrawableTypeRequest load, ImageLoaderOptions options) {
        if (options == null) {
            return load;
        }
        if (options.getPlaceHolder() != -1) {
            load.placeholder(options.getPlaceHolder());
        }
        if (options.getErrorDrawable() != -1) {
            load.error(options.getErrorDrawable());
        }
        if (options.isCrossFade()) {
            load.crossFade();
        }
        load.skipMemoryCache(options.isSkipMemoryCache());
        if (options.getSize() != null) {
            ImageLoaderOptions.ImageReSize size = options.getSize();
            load.override(size.reWidth, size.reHeight);
        }
        return load;
    }
}

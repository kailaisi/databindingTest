package com.tcsl.databindingtest.lib.imageLoader;

import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.tcsl.databindingtest.R;


/**
 * 描述:Picasso加载器
 * 参考：http://www.jianshu.com/p/8b1877443afd
 * <p/>作者：wjx
 * <p/>创建时间: 2017/2/28 17:39
 */
public class PicassoLoader implements ImageLoaderStrategy {
    @Override
    public void showImage(View v, String url, ImageLoaderOptions options) {
        if (v instanceof ImageView) {
            ImageView imageView = (ImageView) v;
            //装备参数
            RequestCreator load = Picasso.with(v.getContext()).load(url);
            loadOption(load, options).into(imageView);
        }
    }

    @Override
    public void showImage(View v, int drawable, ImageLoaderOptions options) {
        if (v instanceof ImageView) {
            ImageView imageView = (ImageView) v;
            RequestCreator load = Picasso.with(v.getContext()).load(drawable);
            loadOption(load, options).into(imageView);
        }
    }

    /**
     * 装载参数
     *
     * @param load
     * @param options
     * @return
     */
    private RequestCreator loadOption(RequestCreator load, ImageLoaderOptions options) {
        if (options == null) {
            return load;
        }
        if (options.getPlaceHolder() != -1) {
            load.placeholder(options.getPlaceHolder());
        }
        if (options.getErrorDrawable() != -1) {
            int errorDrawable = options.getErrorDrawable();
            load.error(errorDrawable);
        }
        if (options.isSkipMemoryCache()) {
            load.skipMemoryCache();
        }
        if (!options.isCrossFade()) {
            load.noFade();
        }
        if (options.getSize() != null) {
            ImageLoaderOptions.ImageReSize size = options.getSize();
            load.resize(size.reWidth, size.reHeight);
        }
        return load;
    }
}

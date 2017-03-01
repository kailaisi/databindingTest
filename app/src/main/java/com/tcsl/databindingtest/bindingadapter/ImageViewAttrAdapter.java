package com.tcsl.databindingtest.bindingadapter;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.tcsl.databindingtest.lib.imageLoader.ImageLoaderOptions;
import com.tcsl.databindingtest.lib.imageLoader.ImageLoaderStrategyManager;
import com.tcsl.databindingtest.lib.imageLoader.PicassoLoader;

/**
 * 描述:
 * <p/>作者：wjx
 * <p/>创建时间: 2017/2/28 17:28
 */
public class ImageViewAttrAdapter {
    @BindingAdapter(value = {"imageUrl", "error"}, requireAll = false)
    public static void setImageUrl(ImageView imageView, String url, int  error) {
        ImageLoaderStrategyManager manager = ImageLoaderStrategyManager.getInstance();
        manager.setLoader(new PicassoLoader());
        ImageLoaderOptions.Builder builder = new ImageLoaderOptions.Builder();
        if(error!=0){
            builder.errorDrawable(error);
        }
        ImageLoaderOptions options = builder.build();
        manager.showImage(imageView, url, options);
    }
}

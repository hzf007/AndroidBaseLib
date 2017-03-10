package com.aspsine.mobi.common.banner.loader;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by hzf on 2017/3/8 0008.
 */

public abstract class BannerImageLoader implements ImageLoaderInterface<ImageView>{

    @Override
    public ImageView createImageView(Context context) {
        ImageView view = new ImageView(context);
        return view;
    }
}

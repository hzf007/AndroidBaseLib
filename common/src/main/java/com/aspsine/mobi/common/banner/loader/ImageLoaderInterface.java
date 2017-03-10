package com.aspsine.mobi.common.banner.loader;

import android.content.Context;
import android.view.View;

import java.io.Serializable;

/**
 * Created by hzf on 2017/3/8 0008.
 */

public interface ImageLoaderInterface<T extends View> extends Serializable {

    void displayImage(Context context, Object path, T imageView);

    T createImageView(Context context);
}

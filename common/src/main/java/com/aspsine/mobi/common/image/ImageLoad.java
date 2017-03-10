package com.aspsine.mobi.common.image;

import android.content.Context;
import android.widget.ImageView;

import com.aspsine.mobi.common.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

/**
 * Created by hzf 2017/3/8 0008 on 下午 2:15.
 * description :图片加载工具
 */

public class ImageLoad {
    Context mContext;
    static ImageLoad mImageLoad;
    private static RequestManager requestManager;

    private ImageLoad(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * 获取单列
     *
     * @param mContext
     * @return
     */
    public static ImageLoad getImageLoad(Context mContext) {
        if (mImageLoad == null) {
            mImageLoad = new ImageLoad(mContext);
            requestManager = Glide.with(mContext);
        }
        return mImageLoad;
    }

    /**
     * 加载图片
     *
     * @param url       图片地址
     * @param imageView 图片
     */
    public void loadImg(String url, ImageView imageView) {
        requestManager.load(url).error(R.drawable.pic_default).placeholder(R.drawable.loding).into(imageView);
    }

    /**
     * 加载图片
     *
     * @param error       错误图片
     * @param placeholder 占位图片
     * @param url         图片地址
     * @param imageView   图片
     */
    public void loadImg(int error, int placeholder, String url, ImageView imageView) {
        requestManager.load(url).error(R.drawable.pic_default).placeholder(R.drawable.loding).into(imageView);
    }
}

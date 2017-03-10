package com.aspsine.mobi.common.loader;

import android.content.Context;
import android.widget.ImageView;

import com.aspsine.mobi.common.utils.JConfig;

import java.io.File;

/**
 * Created by hzf on 2017/3/8 0008.
 * 图片加载接口
 * @author: <a href="http://xiaoyaoyou1212.360doc.com">DAWI</a>
 */

public interface ILoader {
    void init(Context context);

    void loadNet(ImageView target, String url, Options options);

    void loadResource(ImageView target, int resId, Options options);

    void loadAssets(ImageView target, String assetName, Options options);

    void loadFile(ImageView target, File file, Options options);

    void clearMemoryCache(Context context);

    void clearDiskCache(Context context);

    class Options {

        public static final int RES_NONE = -1;
        public int loadingResId = RES_NONE;//加载中的资源id
        public int loadErrorResId = RES_NONE;//加载失败的资源id

        public static Options defaultOptions() {
            return new Options(JConfig.IL_LOADING_RES, JConfig.IL_ERROR_RES);
        }

        public Options(int loadingResId, int loadErrorResId) {
            this.loadingResId = loadingResId;
            this.loadErrorResId = loadErrorResId;
        }
    }
}

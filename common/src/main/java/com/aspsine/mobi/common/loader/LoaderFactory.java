package com.aspsine.mobi.common.loader;

/**
 * Created by hzf on 2017/3/8 0008.
 * @Description: 加载工厂，可定制图片加载框架
 */

public class LoaderFactory {
    private static ILoader loader;

    public static ILoader getLoader() {
        if (loader == null) {
            synchronized (LoaderFactory.class) {
                if (loader == null) {
                    loader = new GlideLoader();
                }
            }
        }
        return loader;
    }
}

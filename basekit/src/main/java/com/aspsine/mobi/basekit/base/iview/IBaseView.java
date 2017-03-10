package com.aspsine.mobi.basekit.base.iview;

/**
 * Created by hzf on 2017/3/7 0007.
 */

public interface IBaseView {
    /**
     * 展示加载条
     */
    void showLoading();

    /**
     * 隐藏加载条
     */
    void hideLoading();

    void showException(Throwable pe);
}

package com.aspsine.mobi.basekit.base.presenter;

import android.content.Context;

import com.trello.rxlifecycle.ActivityLifecycleProvider;

/**
 * Created by hzf on 2017/3/7 0007.
 */

public abstract class BasePresenter {
    protected Context mContext;

    public BasePresenter(Context context) {
        mContext = context;
    }

    public void doDestroy(){
        mContext = null;
        // TODO: 2017/3/7 do destroy
    }
    protected ActivityLifecycleProvider getActivityLifecycleProvider() {
        ActivityLifecycleProvider provider = null;
        if (null != mContext && mContext instanceof ActivityLifecycleProvider) {
            provider = (ActivityLifecycleProvider) mContext;
        }
        return provider;
    }
    /**
     * 业务异常处理
     * @param e
     * @return
     */
    public abstract Throwable doError(Throwable e);
}

package com.aspsine.mobi.common.net.callback;

import com.aspsine.mobi.common.net.exceptiom.ApiException;

/**
 * Created by hzf 2017/3/8 0008 on 下午 2:43.
 * description :API操作回调
 */

public abstract class ApiCallback<T> {
    public abstract void onStart();

    public abstract void onError(ApiException e);

    public abstract void onCompleted();

    public abstract void onNext(T t);
}

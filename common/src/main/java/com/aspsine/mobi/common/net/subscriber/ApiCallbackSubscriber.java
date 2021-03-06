package com.aspsine.mobi.common.net.subscriber;

import android.content.Context;

import com.aspsine.mobi.common.net.callback.ApiCallback;
import com.aspsine.mobi.common.net.exceptiom.ApiException;

/**
 * Created by hzf 2017/3/8 0008 on 下午 4:31.
 * description :包含回调的订阅者，如果订阅这个，上层在不使用订阅者的情况下可获得回调
 */

public class ApiCallbackSubscriber<T> extends ApiSubscriber<T> {
    protected ApiCallback<T> callBack;

    public ApiCallbackSubscriber(Context context, ApiCallback<T> callBack) {
        super(context);
        if (callBack == null) {
            throw new NullPointerException("this callback is null!");
        }
        this.callBack = callBack;
    }

    @Override
    public void onStart() {
        super.onStart();
        callBack.onStart();
    }

    @Override
    public void onError(ApiException e) {
        callBack.onError(e);
    }

    @Override
    public void onCompleted() {
        callBack.onCompleted();
    }

    @Override
    public void onNext(T t) {
        callBack.onNext(t);
    }
}

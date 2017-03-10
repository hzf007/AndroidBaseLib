package com.aspsine.mobi.common.net.func;

import com.aspsine.mobi.common.net.exceptiom.ApiException;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by hzf 2017/3/8 0008 on 下午 3:14.
 * description :Throwable转Observable<T>
 */

public class ApiErrFunc<T> implements Func1<Throwable, Observable<T>> {
    @Override
    public Observable<T> call(Throwable throwable) {
        return Observable.error(ApiException.handleException(throwable));
    }
}

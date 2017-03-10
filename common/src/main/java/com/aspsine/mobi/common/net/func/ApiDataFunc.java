package com.aspsine.mobi.common.net.func;

import com.aspsine.mobi.common.net.exceptiom.ApiException;
import com.aspsine.mobi.common.net.mode.ApiResult;

import rx.functions.Func1;

/**
 * Created by hzf 2017/3/8 0008 on 下午 3:12.
 * description :ApiResult<T>转T
 */

public class ApiDataFunc <T> implements Func1<ApiResult<T>, T> {
    public ApiDataFunc() {
   }

    @Override
    public T call(ApiResult<T> response) {
        if (ApiException.isSuccess(response)) {
            return response.getData();
        } else {
            return (T) new ApiException(new Throwable(response.getMsg()), response.getCode());
        }
    }

}

package com.aspsine.mobi.androidbaselib.model;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hzf 2017/3/8 0008 on 下午 6:39.
 * description :
 */

public interface GankApi {
    //请求服务，想到与service，也是返回Observable
    @GET("search")
    Observable<ResponseBody> Search(@Query("q") String content);
}

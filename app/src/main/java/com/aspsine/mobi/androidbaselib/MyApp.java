package com.aspsine.mobi.androidbaselib;

import com.aspsine.mobi.basekit.base.BaseKitApp;
import com.aspsine.mobi.common.net.api.ViseApi;
import com.aspsine.mobi.common.net.mode.CacheMode;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by hzf 2017/3/8 0008 on 下午 6:36.
 * description :
 */

public class MyApp extends BaseKitApp {
    private String baseUrl = "http://gank.io/";
    private Retrofit retrofit;
    private static MyApp myApp;
    private ViseApi viseApi;

    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;
        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();
        viseApi = new ViseApi.Builder(this)
                .callAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();

    }

    public static MyApp getMyApp() {
        return myApp;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public ViseApi getViseApi() {
        return viseApi;
    }
}

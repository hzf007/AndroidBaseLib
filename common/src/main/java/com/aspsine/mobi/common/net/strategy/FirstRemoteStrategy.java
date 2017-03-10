package com.aspsine.mobi.common.net.strategy;

import com.aspsine.mobi.common.net.core.ApiCache;
import com.aspsine.mobi.common.net.mode.CacheResult;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by hzf 2017/3/8 0008 on 下午 4:15.
 * description :缓存策略--优先网络
 */

public class FirstRemoteStrategy<T> extends CacheStrategy<T> {
    @Override
    public <T> Observable<CacheResult<T>> execute(ApiCache apiCache, String cacheKey, Observable<T> source, Class<T> clazz) {
        Observable<CacheResult<T>> cache = loadCache(apiCache,cacheKey,clazz);

        cache.onErrorReturn(new Func1<Throwable, CacheResult<T>>() {
            @Override
            public CacheResult<T> call(Throwable throwable) {
                return null;
            }
        });
        Observable<CacheResult<T>> remote = loadRemote(apiCache,cacheKey,source);

        return Observable.concat(remote,cache).firstOrDefault(null, new Func1<CacheResult<T>, Boolean>() {
            @Override
            public Boolean call(CacheResult<T> tCacheResult) {
                return tCacheResult != null && tCacheResult.getCacheData() != null;
            }
        });
    }
}

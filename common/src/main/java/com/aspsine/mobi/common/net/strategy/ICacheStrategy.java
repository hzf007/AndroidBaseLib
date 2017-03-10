package com.aspsine.mobi.common.net.strategy;

import com.aspsine.mobi.common.net.core.ApiCache;
import com.aspsine.mobi.common.net.mode.CacheResult;

import rx.Observable;

/**
 * Created by hzf 2017/3/8 0008 on 下午 3:42.
 * description :缓存策略接口
 */

public interface ICacheStrategy<T> {
    <T> Observable<CacheResult<T>> execute(ApiCache apiCache, String cacheKey, Observable<T> source, Class<T> clazz);
}

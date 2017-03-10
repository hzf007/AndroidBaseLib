package com.aspsine.mobi.common.event;

/**
 * Created by hzf on 2017/3/8 0008.
 * 事件总线接口
 */

public interface IBus {
    void register(Object object);

    void unregister(Object object);

    void post(IEvent event);

    void postSticky(IEvent event);
}

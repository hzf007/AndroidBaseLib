package com.aspsine.mobi.common.event;

import com.aspsine.mobi.common.event.inner.EventComposite;
import com.aspsine.mobi.common.event.inner.EventFind;
import com.aspsine.mobi.common.event.inner.EventHelper;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by hzf on 2017/3/8 0008.
 * @Description: RxBus事件管理
 *
 */

public class RxBusImpl extends EventHelper implements IBus {

    private ConcurrentMap<Object, EventComposite> mEventCompositeMap = new ConcurrentHashMap<>();

    @Override
    public void register(Object object) {
        if (object == null) {
            throw new NullPointerException("Object to register must not be null.");
        }
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        EventComposite subscriberMethods = EventFind.findAnnotatedSubscriberMethods(object, compositeSubscription);
        mEventCompositeMap.put(object, subscriberMethods);

        if (!STICKY_EVENT_MAP.isEmpty()) {
            subscriberMethods.subscriberSticky(STICKY_EVENT_MAP);
        }
    }

    @Override
    public void unregister(Object object) {
        if (object == null) {
            throw new NullPointerException("Object to register must not be null.");
        }
        EventComposite subscriberMethods = mEventCompositeMap.get(object);
        if (subscriberMethods != null) {
            subscriberMethods.getCompositeSubscription().unsubscribe();
        }
        mEventCompositeMap.remove(object);
    }

    @Override
    public void post(IEvent event) {
        SUBJECT.onNext(event);
    }

    @Override
    public void postSticky(IEvent event) {
        STICKY_EVENT_MAP.put(event.getClass(), event);
        post(event);
    }
}

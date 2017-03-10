package com.aspsine.mobi.common.event;

import com.aspsine.mobi.common.event.inner.EventThread;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by hzf on 2017/3/8 0008.
 * 接收事件注解，必须在接收事件地方定制该注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface EventSubscribe {
    EventThread thread() default EventThread.MAIN_THREAD;
}

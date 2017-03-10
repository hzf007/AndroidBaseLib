package com.aspsine.mobi.basekit.base.model;

import android.content.Context;

import com.trello.rxlifecycle.ActivityEvent;
import com.trello.rxlifecycle.ActivityLifecycleProvider;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hzf on 2017/3/7 0007.
 */

public class BaseModel {
    protected Context mContext;

    public BaseModel(Context context) {
        mContext = context;
    }

    protected ActivityLifecycleProvider getActivityLifecycleProvider() {
        ActivityLifecycleProvider provider = null;
        if (null != mContext && mContext instanceof ActivityLifecycleProvider) {
            provider = (ActivityLifecycleProvider) mContext;
        }
        return provider;
    }
    //返回被观察者，执行subscribe方法
    public Observable subscribe(Observable mObservable, Observer observer) {
        mObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(getActivityLifecycleProvider().bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(observer);
        return mObservable;
    }

}

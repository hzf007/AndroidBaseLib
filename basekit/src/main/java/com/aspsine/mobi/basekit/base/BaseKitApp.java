package com.aspsine.mobi.basekit.base;

import android.app.Application;

import com.aspsine.mobi.common.utils.CrashHandlerUtil;

/**
 * Created by hzf on 2017/3/7 0007.
 */

public class BaseKitApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //崩溃处理
        CrashHandlerUtil crashHandlerUtil = CrashHandlerUtil.getInstance();
        crashHandlerUtil.init(this);
        crashHandlerUtil.setCrashTip("很抱歉，程序出现异常，即将退出！");
    }
}

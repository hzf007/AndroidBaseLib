package com.aspsine.mobi.common.utils;

/**
 * Created by hzf 2017/3/8 0008 on 下午 4:52.
 * description :避免重复点击校验
 */

public class SingleClick {
    private static final int DEFAULT_TIME = 1000;
    private static long lastTime;

    public static boolean isSingle() {
        boolean isSingle;
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastTime <= DEFAULT_TIME) {
            isSingle = true;
        } else {
            isSingle = false;
        }
        lastTime = currentTime;

        return isSingle;
    }
}

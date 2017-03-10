package com.aspsine.mobi.common.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by hzf 2017/3/8 0008 on 下午 4:57.
 * description :吐司
 */

public class ToastUtils {
    private static Toast mToast;

    public static void showToast(Context context, int id) {
        if (mToast == null) {
            mToast = new Toast(context);
            mToast.setText(id);
        }
        mToast.show();
    }

    public static void showToast(Context context, String string) {
        if (mToast == null) {
            mToast = new Toast(context);
            mToast.setText(string);
        }
        mToast.show();
    }
}

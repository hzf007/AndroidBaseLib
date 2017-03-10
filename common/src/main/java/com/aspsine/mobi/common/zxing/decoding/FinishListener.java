package com.aspsine.mobi.common.zxing.decoding;

import android.app.Activity;
import android.content.DialogInterface;

/**
 * Created by hzf 2017/3/8 0008 on 下午 5:09.
 * description :
 */

public class FinishListener implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener, Runnable {

    private final Activity activityToFinish;

    public FinishListener(Activity activityToFinish) {
        this.activityToFinish = activityToFinish;
    }

    public void onCancel(DialogInterface dialogInterface) {
        run();
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        run();
    }

    public void run() {
        activityToFinish.finish();
    }

}

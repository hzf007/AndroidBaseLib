package com.aspsine.mobi.common.refresh.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.aspsine.mobi.common.R;
import com.aspsine.mobi.common.refresh.SwipeLoadMoreTrigger;
import com.aspsine.mobi.common.refresh.SwipeTrigger;
import com.aspsine.mobi.common.refresh.drawable.RingProgressDrawable;


/**
 * Created by Aspsine on 2015/11/5.
 * 只有圆圈的底部
 */
public class GoogleLoadMoreFooterView extends FrameLayout implements SwipeTrigger, SwipeLoadMoreTrigger {
    private ImageView ivLoadMore;

    private int mTriggerOffset;

    private RingProgressDrawable ringProgressDrawable;
    public GoogleLoadMoreFooterView(Context context) {
        this(context, null);
    }

    public GoogleLoadMoreFooterView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GoogleLoadMoreFooterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ringProgressDrawable = new RingProgressDrawable(context);
        Resources res = getResources();
        ringProgressDrawable.setColors(
                res.getColor(R.color.google_blue),
                res.getColor(R.color.google_red),
                res.getColor(R.color.google_yellow),
                res.getColor(R.color.google_green));
        mTriggerOffset = context.getResources().getDimensionPixelOffset(R.dimen.load_more_trigger_offset_google);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ivLoadMore = (ImageView) findViewById(R.id.ivLoadMore);
        ivLoadMore.setBackgroundDrawable(ringProgressDrawable);
    }

    @Override
    public void onLoadMore() {
        ringProgressDrawable.start();
    }

    @Override
    public void onPrepare() {

    }

    @Override
    public void onSwipe(int y, boolean isComplete) {
        if (!isComplete){
            ringProgressDrawable.setPercent(-y / (float) mTriggerOffset);
        }
    }



    @Override
    public void onRelease() {

    }

    @Override
    public void complete() {
        ringProgressDrawable.stop();
    }


    @Override
    public void onReset() {

    }
}
package com.aspsine.mobi.common.image;

import android.graphics.BitmapRegionDecoder;

import java.io.IOException;

/**
 * Created by hzf 2017/3/8 0008 on 下午 2:10.
 * description :
 */

public interface BitmapDecoderFactory {
    BitmapRegionDecoder made() throws IOException;
}

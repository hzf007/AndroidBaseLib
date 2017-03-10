package com.aspsine.mobi.common.image;

import android.graphics.BitmapRegionDecoder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by hzf 2017/3/8 0008 on 下午 2:18.
 * description :
 */

public class InputstreamBitmapDecoderFactory implements BitmapDecoderFactory {
    private InputStream inputStream;

    public InputstreamBitmapDecoderFactory(InputStream inputStream) {
        super();
        this.inputStream = inputStream;
    }

    @Override
    public BitmapRegionDecoder made() throws IOException {
        return BitmapRegionDecoder.newInstance(inputStream, false);
    }

}

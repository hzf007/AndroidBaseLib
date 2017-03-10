package com.aspsine.mobi.common.image;

import android.graphics.BitmapRegionDecoder;

import java.io.File;
import java.io.IOException;

/**
 * Created by hzf 2017/3/8 0008 on 下午 2:15.
 * description :
 */

public class FileBitmapDecoderFactory implements BitmapDecoderFactory {
    private String path;

    public FileBitmapDecoderFactory(String filePath) {
        super();
        this.path = filePath;
    }

    public FileBitmapDecoderFactory(File file) {
        super();
        this.path = file.getAbsolutePath();
    }

    @Override
    public BitmapRegionDecoder made() throws IOException {
        return BitmapRegionDecoder.newInstance(path, false);
    }
}

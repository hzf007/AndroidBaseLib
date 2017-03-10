package com.aspsine.mobi.common.net.convert;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by hzf 2017/3/8 0008 on 下午 3:04.
 * description : ResponseBody to T
 */

public class JsonResponseBodyConverter <T> implements Converter<ResponseBody, T> {
    JsonResponseBodyConverter() {
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        return (T) value.string();
    }
}

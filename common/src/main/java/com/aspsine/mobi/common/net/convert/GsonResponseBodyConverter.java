package com.aspsine.mobi.common.net.convert;

import com.aspsine.mobi.common.net.exceptiom.ApiException;
import com.aspsine.mobi.common.net.mode.ApiResult;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.net.UnknownServiceException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by hzf 2017/3/8 0008 on 下午 3:02.
 * description :  ResponseBody to T
 */

public class GsonResponseBodyConverter <T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    GsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        if (adapter != null && gson != null) {
            JsonReader jsonReader = gson.newJsonReader(value.charStream());
            try {
                T data = adapter.read(jsonReader);
                if (data == null) throw new UnknownServiceException("server back data is null");
                if (data instanceof ApiResult) {
                    ApiResult apiResult = (ApiResult) data;
                    if (!ApiException.isSuccess(apiResult)) {
                        throw new UnknownServiceException(apiResult.getMsg() == null ? "unknow error" : apiResult.getMsg());
                    }
                }
                return data;
            } finally {
                value.close();
            }
        } else {
            return null;
        }
    }
}

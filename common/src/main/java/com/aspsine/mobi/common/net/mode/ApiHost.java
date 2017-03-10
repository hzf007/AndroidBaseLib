package com.aspsine.mobi.common.net.mode;

import com.aspsine.mobi.common.utils.JConfig;

/**
 * Created by hzf 2017/3/8 0008 on 下午 2:47.
 * description :主机信息
 */

public class ApiHost {
    private static String host = JConfig.API_HOST;

    public static String getHost() {
        return host;
    }

    public static void setHost(String url) {
        setHostHttps(url);
    }

    public static void setHostHttp(String url) {
        if (url.startsWith("https://") || url.startsWith("http://")) {
            host = url;
            host = host.replaceAll("https://", "http://");
        } else {
            host = "http://" + url;
        }
    }

    public static void setHostHttps(String url) {
        if (url.startsWith("https://") || url.startsWith("http://")) {
            host = url;
            host = host.replaceAll("http://", "https://");
        } else {
            host = "https://" + url;
        }
    }

    public static String getHttp() {
        if (host.startsWith("https://") || host.startsWith("http://")) {
            host = host.replaceAll("https://", "http://");
        } else {
            host = "http://" + host;
        }
        return host;
    }

    public static String getHttps() {
        if (host.startsWith("https://") || host.startsWith("http://")) {
            host = host.replaceAll("http://", "https://");
        } else {
            host = "https://" + host;
        }
        return host;
    }
}

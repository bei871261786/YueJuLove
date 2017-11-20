package com.aladingtech.app.yueju.common.kits;

/**
 * Created by wanglei on 2016/12/9.
 */

public class UrlKit {
    public static final String API_BASE_URL = "http://101.132.108.63:8080/ganded/";
    public static final String API_BAIDU_URL = "http://www.baidu.com";

//    public static final String ACTION_DATA_RESULT = "data/{type}/{number}/{page}";

    public static String getUrl(String action) {
        return new StringBuilder(API_BASE_URL).append(action).toString();
    }
}

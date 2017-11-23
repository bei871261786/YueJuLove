package com.aladingtech.app.yueju.common.kits;

/**
 * Created by wanglei on 2016/12/9.
 */

public class UrlKit {
    private static boolean isTest = true;
    private static final String BASE_TEST_URL = "http://101.132.108.63:8080/ganded/";
    public static final String sendVerify = "user/sendVerify";//发送短信
    public static final String login = "user/login";// 登录

//    public static final String ACTION_DATA_RESULT = "data/{type}/{number}/{page}";


    public static String getApiBaseUrl() {
        if (isTest) {
            return BASE_TEST_URL;
        }
        else {
            return BASE_TEST_URL;
        }
    }


}

package com.aladingtech.app.yueju.common.net;

import com.aladingtech.app.yueju.common.kits.UrlKit;
import com.aladingtech.app.yueju.common.net.service.SearchService;

import cn.droidlover.xdroidmvp.net.NetError;
import cn.droidlover.xdroidmvp.net.NetProvider;
import cn.droidlover.xdroidmvp.net.RequestHandler;
import cn.droidlover.xdroidmvp.net.XApi;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/**
 * Created by hotBei on 2017/11/16,2017
 * Created on 17:01
 */

public class Api {

    private static SearchService mSearchService;

    public static SearchService getmSearchService() {
        if (mSearchService == null) {
            synchronized (Api.class) {
                if (mSearchService == null) {
                    mSearchService = XApi.getInstance().getRetrofit(UrlKit.API_BASE_URL, false).create(SearchService.class);
                }
            }
        }
        return mSearchService;
    }


}

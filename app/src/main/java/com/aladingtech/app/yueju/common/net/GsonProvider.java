package com.aladingtech.app.yueju.common.net;

import com.google.gson.Gson;

/**
 * Created by Hot on 2017/11/23,2017
 * Created on 13:47
 */

public class GsonProvider {
    private Gson gson;

    private static GsonProvider instance;

    private GsonProvider() {
        gson = new Gson();
    }

    public static GsonProvider getInstance() {
        if (instance == null) {
            synchronized (GsonProvider.class) {
                if (instance == null) {
                    instance = new GsonProvider();
                }
            }
        }
        return instance;
    }

    public Gson getGson() {
        return gson;
    }
}

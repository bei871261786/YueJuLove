package com.aladingtech.app.yueju.common.net;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.AbsCallback;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by hotBei on 2017/11/20,2017
 * Created on 16:50
 */

public class NetManager<T> {
    private String mMode = "";
    private String mUrl = "";
    private LinkedHashMap<String, String> mParams;

    public NetManager post(String url, LinkedHashMap<String, String> params) {
        mMode = "post";
        mParams = params;
        return this;
    }

    public NetManager get() {
        mMode = "get";
        return this;
    }

    public void start(AbsCallback<T> callback, Object tag) {
        if (mMode.equals("post")) {
            OkGo.post(mUrl).tag(tag).params(mParams).execute(callback);//开始 post 请求
        } else if (mMode.equals("get")) {
            OkGo.get(mUrl).tag(tag).execute(callback);//开始 post 请求
        }
    }
}

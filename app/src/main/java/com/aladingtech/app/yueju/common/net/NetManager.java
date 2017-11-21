package com.aladingtech.app.yueju.common.net;

import com.aladingtech.app.yueju.common.Configs;
import com.aladingtech.app.yueju.common.exception.MyException;
import com.aladingtech.app.yueju.common.interfaces.ParamsHelperInterface;
import com.aladingtech.app.yueju.common.kits.StorageKit;
import com.aladingtech.app.yueju.common.kits.UrlKit;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

import cn.droidlover.xdroidmvp.kit.Codec;
import cn.droidlover.xdroidmvp.log.XLog;

/**
 * Created by hotBei on 2017/11/20,2017
 * Created on 16:50
 */

public class NetManager<T> {
    private String mMode = "";
    private String mUrl = "";
    private LinkedHashMap<String, String> mParams;

    public NetManager post(String url, ParamsHelperInterface helper) {
        mMode = "post";
        mUrl = UrlKit.getApiBaseUrl()+url;
        mParams = getHeadParams(helper.getParamas());
        return this;
    }

    public NetManager get(String url) {
        mMode = "get";
        mUrl = UrlKit.getApiBaseUrl()+url;
        return this;
    }

    public void start(StringCallback callback, Object tag) {
        try {
            if (mMode.equals("post")) {
                OkGo.post(mUrl).tag(tag).params(mParams).execute(callback);//开始 post 请求
            } else if (mMode.equals("get")) {
                OkGo.get(mUrl).tag(tag).execute(callback);//开始 post 请求
            } else {
                throw new MyException.NetException();
            }
        } catch (MyException.NetException e) {
            e.printStackTrace();
        }
    }

    private LinkedHashMap<String, String> getHeadParams(LinkedHashMap<String, String> params) {
        StringBuilder sb = new StringBuilder();
        if (params != null) {
            Iterator<String> iterator = params.keySet().iterator();
            ArrayList<String> list = new ArrayList();
            while (iterator.hasNext()) {
                String key = iterator.next();
                list.add((String) params.get(key));
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                sb.append(list.get(i));
            }
        } else {
            params = new LinkedHashMap();
        }
        String sign = "";
        String secret = StorageKit.getSecret();
        sign = Codec.MD5.getStringMD5(secret + Configs.SIGNKEY + sb.toString());
        XLog.d("getHeadParams  params:" + sign + ":::" + sb.toString());
        params.put("sign", sign);
//        params.put("secret", secret);
        return params;
    }
}

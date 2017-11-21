package com.aladingtech.app.yueju.common.net;

import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.convert.StringConvert;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by hotBei on 2017/11/21,2017
 * Created on 14:18
 */

public abstract class StringModelCallback extends AbsCallback<String> {

    @Override
    public void onSuccess(String s, Call call, Response response) {

    }

    @Override
    public void onError(Call call, Response response, Exception e) {
        super.onError(call, response, e);
    }

    @Override
    public String convertSuccess(Response response) throws Exception {
        String s = StringConvert.create().convertSuccess(response);
        response.close();
        return s;
    }

    public abstract <B> void onSuccess(String s, B model, Response response);
}

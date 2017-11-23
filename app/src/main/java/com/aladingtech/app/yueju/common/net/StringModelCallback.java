package com.aladingtech.app.yueju.common.net;

import com.aladingtech.app.yueju.common.models.VertifyModel;
import com.google.gson.Gson;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.convert.StringConvert;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;

import cn.droidlover.xdroidmvp.log.XLog;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by hotBei on 2017/11/21,2017
 * Created on 14:18
 */

public abstract class StringModelCallback<T> extends StringCallback {
    private String s;
    private Call call;
    private Response response;
    private Class<T> modelClass;

    @Override
    public void onSuccess(String s, Call call, Response response) {
        this.call = call;
        this.s = s;
        this.response = response;
        Gson gson = new Gson();
        T model;
        VertifyModel bean;
        modelClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        if (modelClass == String.class) {
            model = (T) s;
        } else {
            model = GsonProvider.getInstance().getGson().fromJson(s, modelClass);
        }
        bean=GsonProvider.getInstance().getGson().fromJson(s, VertifyModel.class);
        XLog.i("StringModelCallback jsontoModel:"+modelClass+"::"+model+":::"+s);
        XLog.i("StringModelCallback jsontoBean:"+VertifyModel.class+"::"+bean+":::"+s);
        onSuccess(s, model, response);
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

    public abstract void onSuccess(String s, T model, Response response);


}

package com.aladingtech.app.yueju.common.activity;

import android.os.Bundle;

import com.aladingtech.app.yueju.R;
import com.aladingtech.app.yueju.common.interfaces.ParamsHelperInterface;
import com.aladingtech.app.yueju.common.kits.LogUtils;
import com.aladingtech.app.yueju.common.kits.UrlKit;
import com.aladingtech.app.yueju.common.net.NetManager;
import com.aladingtech.app.yueju.search.model.TestModel;
import com.lzy.okgo.callback.StringCallback;

import java.util.LinkedHashMap;

import cn.droidlover.xdroidmvp.mvp.XActivity;
import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends XActivity {

    @Override
    public void initData(Bundle savedInstanceState) {
        final String mobile = "15701656560";
        NetManager<TestModel> manager = new NetManager<>();
        manager.post(UrlKit.sendVerify, new ParamsHelperInterface() {
            @Override
            public LinkedHashMap<String, String> getParamas() {
                LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
                params.put("mobile", mobile);
                return params;
            }
        }).start(new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                LogUtils.i("onSuccess :"+s+":::"+response);
            }
        },this);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public Object newP() {
        return null;
    }


}

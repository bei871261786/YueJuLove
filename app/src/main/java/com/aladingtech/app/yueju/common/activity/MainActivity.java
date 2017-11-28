package com.aladingtech.app.yueju.common.activity;

import android.os.Bundle;

import com.aladingtech.app.yueju.R;
import com.aladingtech.app.yueju.common.kits.UrlKit;
import com.aladingtech.app.yueju.common.models.TestModel;
import com.aladingtech.app.yueju.common.net.NetManager;
import com.aladingtech.app.yueju.common.net.ParamsHelperInterface;
import com.aladingtech.app.yueju.common.net.StringModelCallback;

import java.util.LinkedHashMap;

import cn.droidlover.xdroidmvp.mvp.XActivity;
import okhttp3.Response;

public class MainActivity extends XActivity {

    @Override
    public void initData(Bundle savedInstanceState) {


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

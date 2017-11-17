package com.aladingtech.app.yueju;

import android.os.Bundle;

import cn.droidlover.xdroidmvp.mvp.XActivity;
import cn.droidlover.xdroidmvp.net.NetError;
import cn.droidlover.xdroidmvp.net.XApi;

import static android.R.attr.type;
import static android.nfc.tech.MifareUltralight.PAGE_SIZE;

public class MainActivity extends XActivity {

    String sendUrl="http://101.132.108.63:8080/ganded/user/sendVerify";

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

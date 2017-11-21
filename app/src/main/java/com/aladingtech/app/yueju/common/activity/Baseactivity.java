package com.aladingtech.app.yueju.common.activity;

import com.lzy.okgo.OkGo;

import cn.droidlover.xdroidmvp.mvp.IPresent;
import cn.droidlover.xdroidmvp.mvp.XActivity;

/**
 * Created by hotBei on 2017/11/21,2017
 * Created on 15:26
 */

public abstract class BaseActivity<T extends IPresent> extends XActivity<T> {


    //所有 activity 返回的时候,关闭当前页面进行的加载
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        OkGo.getInstance().cancelTag(this);
    }
}

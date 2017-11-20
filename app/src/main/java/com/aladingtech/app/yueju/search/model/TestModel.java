package com.aladingtech.app.yueju.search.model;

import cn.droidlover.xdroidmvp.net.IModel;

/**
 * Created by hotBei on 2017/11/20,2017
 * Created on 10:00
 */

public class TestModel implements IModel {

    /**
     * ret : false
     * code : 102
     * msg : 签名错误!
     */

    private boolean ret;
    private int code;
    private String msg;

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public boolean isAuthError() {
        return false;
    }

    @Override
    public boolean isBizError() {
        return false;
    }

    @Override
    public String getErrorMsg() {
        return null;
    }
}

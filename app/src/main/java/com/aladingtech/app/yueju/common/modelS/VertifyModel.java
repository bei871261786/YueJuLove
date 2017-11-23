package com.aladingtech.app.yueju.common.models;

import cn.droidlover.xdroidmvp.net.IModel;

/**
 * Created by hotBei on 2017/11/20,2017
 * Created on 10:00
 */

public class VertifyModel implements IModel {

    /**
     * ret : true
     * code : 000
     * data : {"mobile":17817280655,"validTime":1511405740422}
     * msg : success
     */


    private boolean ret;
    private String code;
    private DataBean data;
    private String msg;

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

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

//    public void setData(DataBean data) {
//        this.data = data;
//    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * mobile : 17817280655
         * validTime : 1511405740422
         */

        private long mobile;
        private long validTime;

        public long getMobile() {
            return mobile;
        }

        public void setMobile(long mobile) {
            this.mobile = mobile;
        }

        public long getValidTime() {
            return validTime;
        }

        public void setValidTime(long validTime) {
            this.validTime = validTime;
        }
    }
}

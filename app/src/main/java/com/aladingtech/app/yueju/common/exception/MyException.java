package com.aladingtech.app.yueju.common.exception;

/**
 * Created by hotBei on 2017/11/20,2017
 * Created on 17:02
 */

public class MyException {
    public static class NetException extends Exception {
        public NetException() {
            super("你还没有【post】或者【get】");
        }
    }

}

package com.aladingtech.app.yueju.common.kits;

import com.aladingtech.app.yueju.common.Configs;

/**
 * Created by hotBei on 2017/11/21,2017
 * Created on 13:34
 * 存储工具类,集合需要存取的方法,在此类中调用各个详细存取方法
 */

public class StorageKit {

    public static String getSecret() {
        return  SharedPrefreKit.getInstance().getString(Configs.SECRET, "");
    }

    public static void putSecret(String secret) {
        SharedPrefreKit.getInstance().putString(secret, "");
    }
}

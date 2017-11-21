package com.aladingtech.app.yueju.common.present;

import com.aladingtech.app.yueju.common.activity.MainActivity;
import com.aladingtech.app.yueju.common.activity.VertifyActivity;

import cn.droidlover.xdroidmvp.mvp.XPresent;
import cn.droidlover.xdroidmvp.router.Router;

/**
 * Created by hotBei on 2017/11/21,2017
 * Created on 15:29
 */

public class VertifyPresent extends XPresent<VertifyActivity> {

    public void lauchToMainActivity() {
        Router.newIntent(getV())		//context表示当前上下文
                .to(MainActivity.class)	//to()指定目标context
                .launch();
    }


}

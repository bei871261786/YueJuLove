package com.aladingtech.app.yueju.common.present;

import android.view.View;

import com.aladingtech.app.yueju.R;
import com.aladingtech.app.yueju.common.activity.LoginActivity;
import com.aladingtech.app.yueju.common.activity.VertifyActivity;

import cn.droidlover.xdroidmvp.mvp.XPresent;
import cn.droidlover.xdroidmvp.router.Router;

/**
 * Created by hotBei on 2017/11/21,2017
 * Created on 15:29
 */

public class LoginPresent extends XPresent<LoginActivity> {

    public void lauchToVerify() {
        Router.newIntent(getV())        //context表示当前上下文
                .to(VertifyActivity.class)    //to()指定目标context
                .launch();
    }

    public LoginListener getListener() {
        return new LoginListener();
    }

    public class LoginListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.login:
                    lauchToVerify();
                    break;
            }

        }
    }


}

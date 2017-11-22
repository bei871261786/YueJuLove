package com.aladingtech.app.yueju.common.present;

import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.EditText;

import com.aladingtech.app.yueju.R;
import com.aladingtech.app.yueju.common.activity.LoginActivity;
import com.aladingtech.app.yueju.common.activity.VertifyActivity;
import com.aladingtech.app.yueju.common.kits.RegexUtils;
import com.aladingtech.app.yueju.common.kits.UiKit;

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
                    //登录之前先检测输入手机号是否正确,不正确就提示重新输入,正确就进入下一步
                    TextInputLayout inputLayout = getV().genEditText();
                    EditText editText = inputLayout.getEditText();
                    String phone = editText.getText().toString();
                    if (!RegexUtils.checkPhone(phone)) {
                        inputLayout.setError(UiKit.getString(R.string.input_phone_error));
                    } else {
                        inputLayout.setErrorEnabled(false);
                        lauchToVerify();
                    }

                    break;
            }

        }


    }


}

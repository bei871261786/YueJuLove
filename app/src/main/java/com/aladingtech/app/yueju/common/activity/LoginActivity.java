package com.aladingtech.app.yueju.common.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.widget.Button;
import android.widget.LinearLayout;

import com.aladingtech.app.yueju.R;
import com.aladingtech.app.yueju.common.present.LoginPresent;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.droidlover.xdroidmvp.log.XLog;

public class LoginActivity extends BaseActivity<LoginPresent> {
    @BindView(R.id.login_inputPhone)
    TextInputLayout loginInputPhone;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.activity_login)
    LinearLayout activityLogin;
    private LoginPresent.LoginListener mListener;

    @Override
    public void initData(Bundle savedInstanceState) {
        mListener = getP().getListener();
        login.setOnClickListener(mListener);
    }

    @Override
    public int getLayoutId() {
        XLog.d("getLayoutId:" + R.layout.activity_login);
        return R.layout.activity_login;
    }

    @Override
    public LoginPresent newP() {
        return new LoginPresent();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mListener = getP().getListener();
        login.setOnClickListener(mListener);
    }
}

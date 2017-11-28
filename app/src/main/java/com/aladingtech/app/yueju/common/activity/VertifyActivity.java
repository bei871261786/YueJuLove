package com.aladingtech.app.yueju.common.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aladingtech.app.yueju.R;
import com.aladingtech.app.yueju.common.kits.CountDownKit;
import com.aladingtech.app.yueju.common.kits.UiKit;
import com.aladingtech.app.yueju.common.present.VertifyPresent;
import com.aladingtech.app.yueju.common.widget.VertifyEditView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.droidlover.xdroidmvp.log.XLog;

public class VertifyActivity extends BaseActivity<VertifyPresent> {
    @BindView(R.id.activity_vertify)
    LinearLayout activityVertify;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.vertify_resend)
    Button vertifyResend;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.descripe_success)
    TextView descripeSuccess;
    @BindView(R.id.descripe_during)
    TextView descripeDuring;
    @BindView(R.id.vertifyEdittext)
    VertifyEditView vertifyEdittext;
    private VertifyPresent.VertifyListener mListener;
    private String phone = "";

    @Override
    public void initData(Bundle savedInstanceState) {
        mListener = getP().getListener();
        login.setOnClickListener(mListener);
        vertifyResend.setOnClickListener(mListener);
        back.setOnClickListener(mListener);

        phone = getIntent().getStringExtra("phone");
        getP().setPhone(phone);
        // getP().sendVertify();
    }

    public String getVertify() {
        return vertifyEdittext.getEditContent();
    }

    public void startCountDown() {
        CountDownKit timer = new CountDownKit(60 * 1000, 500, descripeDuring);
        timer.start();
    }

    public void changeDecripe(boolean isSuccess) {
        if (isSuccess) {
            descripeSuccess.setText(UiKit.getString(R.string.descripe_sendSuccess));
        } else {
            descripeSuccess.setText(UiKit.getString(R.string.descripe_sendFaild));
        }
    }

    public void jumpToNextEdit() {
        XLog.i("jumpToNextEdit:");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_vertify;
    }

    @Override
    public VertifyPresent newP() {
        return new VertifyPresent();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}

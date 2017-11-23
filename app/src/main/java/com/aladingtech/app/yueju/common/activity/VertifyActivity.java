package com.aladingtech.app.yueju.common.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aladingtech.app.yueju.R;
import com.aladingtech.app.yueju.common.kits.CountDownKit;
import com.aladingtech.app.yueju.common.kits.UiKit;
import com.aladingtech.app.yueju.common.present.VertifyPresent;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VertifyActivity extends BaseActivity<VertifyPresent> {

    @BindView(R.id.vertify_edit1)
    EditText vertifyEdit1;
    @BindView(R.id.vertify_edit2)
    EditText vertifyEdit2;
    @BindView(R.id.vertify_edit3)
    EditText vertifyEdit3;
    @BindView(R.id.vertify_edit4)
    EditText vertifyEdit4;
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
    private VertifyPresent.VertifyListener mListener;

    private String phone = "";

    @Override
    public void initData(Bundle savedInstanceState) {
        mListener = getP().getListener();
        login.setOnClickListener(mListener);
        vertifyResend.setOnClickListener(mListener);
        back.setOnClickListener(mListener);
        vertifyEdit1.addTextChangedListener(mListener);
        vertifyEdit2.addTextChangedListener(mListener);
        vertifyEdit3.addTextChangedListener(mListener);
        vertifyEdit4.addTextChangedListener(mListener);
        phone = getIntent().getStringExtra("phone");
        getP().setPhone(phone);
//        getP().sendVertify();
    }

    public String getPhone() {
        return phone;
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

    @Override
    public int getLayoutId() {
        return R.layout.activity_vertify;
    }

    @Override
    public VertifyPresent newP() {
        return new VertifyPresent();
    }

}

package com.aladingtech.app.yueju.common.present;

import android.text.format.DateUtils;
import android.view.View;

import com.aladingtech.app.yueju.R;
import com.aladingtech.app.yueju.common.activity.MainActivity;
import com.aladingtech.app.yueju.common.activity.VertifyActivity;
import com.aladingtech.app.yueju.common.kits.UrlKit;
import com.aladingtech.app.yueju.common.models.VertifyModel;
import com.aladingtech.app.yueju.common.net.NetManager;
import com.aladingtech.app.yueju.common.net.ParamsHelperInterface;
import com.aladingtech.app.yueju.common.net.StringModelCallback;

import java.util.LinkedHashMap;

import cn.droidlover.xdroidmvp.XDroidConf;
import cn.droidlover.xdroidmvp.kit.Codec;
import cn.droidlover.xdroidmvp.kit.Kits;
import cn.droidlover.xdroidmvp.log.XLog;
import cn.droidlover.xdroidmvp.mvp.XPresent;
import cn.droidlover.xdroidmvp.router.Router;
import okhttp3.Call;
import okhttp3.Response;

import static android.R.attr.password;


/**
 * Created by hotBei on 2017/11/21,2017
 * Created on 15:29
 */

public class VertifyPresent extends XPresent<VertifyActivity> {

    private String mPhone;


    public VertifyListener getListener() {
        return new VertifyListener();
    }


    public void lauchToMainActivity() {
        Router.newIntent(getV())        //context表示当前上下文
                .to(MainActivity.class)    //to()指定目标context
                .launch();
    }


    public void setPhone(String phone) {
        mPhone = phone;
    }


    public void sendVertify() {
        XLog.i("VertifyPresent sendVertify");
        NetManager<VertifyModel> manager = new NetManager<>();
        manager.post(UrlKit.sendVerify, new ParamsHelperInterface() {
            @Override
            public LinkedHashMap<String, String> getParamas() {
                LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
                params.put("mobile", mPhone);
                return params;
            }
        }).start(new StringModelCallback<VertifyModel>() {
            @Override
            public void onSuccess(String s, VertifyModel model, Response response) {
                XLog.i("sendVertify onSuccess:" + s + ":::" + response + ":::" + model);
                getV().startCountDown();
                getV().changeDecripe(true);
            }

            @Override
            public void onError(Call call, Response response, Exception e) {
                super.onError(call, response, e);
                XLog.i("sendVertify onError:" + ":::" + response + "::::" + e);
                getV().changeDecripe(false);
            }
        }, this);

    }

    public void beginLogn() {

        XLog.i("VertifyPresent beginLogn");
        NetManager<VertifyModel> manager = new NetManager<>();
        final String type = "2";
        final String mobile = mPhone;
        final String password = Codec.MD5.getStringMD5(mPhone + getV().getVertify());
        final String pushToken = "";
        final String timestamp = Kits.Date.getYmdhms(System.currentTimeMillis());
        manager.post(UrlKit.login, new ParamsHelperInterface() {
            @Override
            public LinkedHashMap<String, String> getParamas() {
                LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
                params.put("type", type);
                params.put("mobile", mobile);
                params.put("password", password);
                params.put("pushToken", pushToken);
                params.put("timestamp", timestamp);
                return params;
            }
        }).start(new StringModelCallback<VertifyModel>() {
            @Override
            public void onSuccess(String s, VertifyModel model, Response response) {
                XLog.i("beginLogn onSuccess:" + s + ":::" + response + ":::" + model);
                lauchToMainActivity();
            }

            @Override
            public void onError(Call call, Response response, Exception e) {
                super.onError(call, response, e);
                XLog.i("beginLogn onError:" + ":::" + response + "::::" + e);
            }
        }, this);

    }

    public class VertifyListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.vertify_resend:
                    sendVertify();
                    break;
                case R.id.login:
                    beginLogn();

                    break;
            }
        }
    }


}

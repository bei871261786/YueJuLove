package com.aladingtech.app.yueju;

import android.os.Bundle;

import com.aladingtech.app.yueju.common.Configs;
import com.aladingtech.app.yueju.common.kits.LogUtils;
import com.aladingtech.app.yueju.common.kits.UrlKit;
import com.aladingtech.app.yueju.common.net.Api;
import com.aladingtech.app.yueju.search.model.TestModel;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;

import cn.droidlover.xdroidmvp.kit.Codec;
import cn.droidlover.xdroidmvp.log.XLog;
import cn.droidlover.xdroidmvp.mvp.XActivity;
import cn.droidlover.xdroidmvp.net.NetError;
import cn.droidlover.xdroidmvp.net.NetProvider;
import cn.droidlover.xdroidmvp.net.RequestHandler;
import cn.droidlover.xdroidmvp.net.XApi;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends XActivity {
    private long mTimeoutMills = 15 * 1000L;
    String sendUrl = "http://101.132.108.63:8080/ganded/user/sendVerify";

    @Override
    public void initData(Bundle savedInstanceState) {
        String mobile = "15701656560";
        String sign = Codec.MD5.getStringMD5(Configs.SIGN + mobile);
        XLog.d("params :" + sign + ":::" + mobile);
//        initNet();
//        Api.getmSearchService().sendVerify(sign, mobile).enqueue(new Callback<TestModel>() {
//            //请求成功时回调
//            @Override
//            public void onResponse(Call<TestModel> call, Response<TestModel> response) {
//                //请求处理,输出结果
////                XLog.d("result onResponse"+response);
//                LogUtils.i("result onResponse"+response);
//            }
//
//            //请求失败时候的回调
//            @Override
//            public void onFailure(Call<TestModel> call, Throwable throwable) {
//                System.out.println("连接失败");
////                XLog.d("result 连接失败");
//                LogUtils.i("result 连接失败"+call+":::"+throwable);
//            }
//        });
        postByOkGo(UrlKit.API_BASE_URL+"user/sendVerify",mobile,sign);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public Object newP() {
        return null;
    }

    /**
     * post请求
     * @param url
     */
    private void postByOkGo(String url,String mobile,String sign){
        OkGo.post(url)
                .tag(this)
                .cacheKey("cachePostKey")
                .cacheMode(CacheMode.DEFAULT)
                .params("mobile", "album.item.get")
                .params("sign", "myKey")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, okhttp3.Call call, okhttp3.Response response) {
                        LogUtils.i("OKGOresult onSuccess:"+call+":::"+response);
                    }

                    @Override
                    public void onError(okhttp3.Call call, okhttp3.Response response, Exception e) {
                        super.onError(call, response, e);
                        LogUtils.i("OKGOresult onError:"+call+":::"+response+":::"+e);
                    }
                });
    }


    private void initNet() {
        XApi.registerProvider(new NetProvider() {
            @Override
            public Interceptor[] configInterceptors() {
                return new Interceptor[0];
            }

            @Override
            public void configHttps(OkHttpClient.Builder builder) {
            }

            @Override
            public CookieJar configCookie() {
                return null;
            }

            @Override
            public RequestHandler configHandler() {
                return null;
            }

            @Override
            public long configConnectTimeoutMills() {
                return mTimeoutMills;
            }

            @Override
            public long configReadTimeoutMills() {
                return mTimeoutMills;
            }

            @Override
            public boolean configLogEnable() {
                return true;
            }

            @Override
            public boolean handleError(NetError error) {
                return false;
            }

            @Override
            public boolean dispatchProgressEnable() {
                return false;
            }
        });
    }
}

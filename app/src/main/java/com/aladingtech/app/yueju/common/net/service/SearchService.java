package com.aladingtech.app.yueju.common.net.service;

import com.aladingtech.app.yueju.search.model.TestModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SearchService {

    @POST("user/sendVerify")
    @FormUrlEncoded
    Call<TestModel> sendVerify(@Field("sign") String sign, @Field("mobile") String mobile);
}
package com.aladingtech.app.yueju.search.interfaces;

import android.os.Bundle;
import android.view.View;

import com.aladingtech.app.yueju.search.present.TestPresent;

import cn.droidlover.xdroidmvp.mvp.IView;

/**
 * Created by hotBei on 2017/11/14,2017
 * Created on 14:52
 */

public interface ICommen extends IView<TestPresent> {

    void showError();
}

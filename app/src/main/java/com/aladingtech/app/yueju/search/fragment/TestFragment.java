package com.aladingtech.app.yueju.search.fragment;

import android.os.Bundle;
import android.view.View;

import com.aladingtech.app.yueju.search.interfaces.ICommen;
import com.aladingtech.app.yueju.search.present.TestPresent;

/**
 * Created by hotBei on 2017/11/14,2017
 * Created on 15:19
 */

public class TestFragment implements ICommen {
    @Override
    public void showError() {

    }

    @Override
    public void bindUI(View rootView) {

    }

    @Override
    public void bindEvent() {

    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getOptionsMenuId() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public boolean useEventBus() {
        return false;
    }

    @Override
    public TestPresent newP() {
        return null;
    }
}

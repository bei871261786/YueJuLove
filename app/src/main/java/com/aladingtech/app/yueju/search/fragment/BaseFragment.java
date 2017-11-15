package com.aladingtech.app.yueju.search.fragment;

import android.os.Bundle;

import com.aladingtech.app.yueju.PBasePager;
import com.aladingtech.app.yueju.search.interfaces.ICommen;
import com.aladingtech.app.yueju.search.present.TestPresent;

import cn.droidlover.xdroidmvp.mvp.XFragment;

/**
 * Created by HP on 2017/10/22.
 */

public class BaseFragment extends XFragment<TestPresent> implements ICommen {


    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public TestPresent newP() {
        return new TestPresent();
    }

    @Override
    public void showError() {

    }
}

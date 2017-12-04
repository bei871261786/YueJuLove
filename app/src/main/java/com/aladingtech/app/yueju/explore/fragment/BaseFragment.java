package com.aladingtech.app.yueju.explore.fragment;

import android.os.Bundle;

import com.aladingtech.app.yueju.explore.interfaces.ICommen;
import com.aladingtech.app.yueju.explore.present.TestPresent;

import cn.droidlover.xdroidmvp.mvp.XFragment;
import cn.droidlover.xdroidmvp.mvp.XLazyFragment;

import static android.R.attr.x;

/**
 * Created by HP on 2017/10/22.
 */

public class BaseFragment extends XLazyFragment<TestPresent> implements ICommen {


    @Override
    public void showError() {

    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public TestPresent newP() {
        return null;
    }
}

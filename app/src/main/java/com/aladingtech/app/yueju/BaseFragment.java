package com.aladingtech.app.yueju;

import android.os.Bundle;

import cn.droidlover.xdroidmvp.mvp.XFragment;

/**
 * Created by HP on 2017/10/22.
 */

public class BaseFragment extends XFragment<PBasePager> {


    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return 0;
    }



    @Override
    public PBasePager newP() {
        return null;
    }
}

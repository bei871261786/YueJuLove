package com.aladingtech.app.yueju.explore.present;

import com.aladingtech.app.yueju.explore.fragment.BaseFragment;

import cn.droidlover.xdroidmvp.mvp.XPresent;

/**
 * Created by hotBei on 2017/11/14,2017
 * Created on 14:49
 */

public class TestPresent extends XPresent<BaseFragment> {

    private void loadData() {
        getV().showError();
    }
}

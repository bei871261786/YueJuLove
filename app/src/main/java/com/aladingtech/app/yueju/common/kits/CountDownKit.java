package com.aladingtech.app.yueju.common.kits;

import android.os.CountDownTimer;
import android.widget.TextView;

/**
 * Created by Hot on 2017/11/23,2017
 * Created on 14:11
 */
//倒计时的类
public class CountDownKit extends CountDownTimer {
    TextView textView;
    String finishStr="可重新发送";
    String duringStr="秒可重新发送";

    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */
    public CountDownKit(long millisInFuture, long countDownInterval, TextView textView) {
        super(millisInFuture, countDownInterval);
        this.textView = textView;
    }

    //倒计时时执行的动作
    @Override
    public void onTick(long millisUntilFinished) {
        int i;
        if (Math.floor(millisUntilFinished / 1000) == 0) {
            i = 0;
        } else {
            i = (int) (millisUntilFinished / 1000);
        }
        updateDialog(textView, "还有" + i +duringStr, 0);
    }

    //倒计时结束执行的动作
    @Override
    public void onFinish() {
        updateDialog(textView, finishStr, 1);
    }

    public void setDuringStr(String duringStr) {
        this.duringStr = duringStr;
    }

    public void setFinishStr(String finishStr) {
        this.finishStr = finishStr;
    }

    private void updateDialog(TextView textView, String s, int type) {
        if (type == 0) {
            textView.setText(s);
            textView.setEnabled(false);
        } else if (type == 1) {
            textView.setText(s);
            textView.setEnabled(true);
        }
    }
}

package com.base.xiaopa.activitys;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.xiaopa.android.R;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;


public class RegisterActivity extends Fragment implements View.OnClickListener{

    private Button register;
    private TextView getCode;
    private EditText code;
    private EditText Tel;
    String mPhone;
    View v;

    EventHandler eventHandler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.activity_register,container,false);
        Tel = (EditText) v.findViewById(R.id.et_Tel);
        getCode = (TextView) v.findViewById(R.id.tv_getCode);
        code = (EditText) v.findViewById(R.id.ed_code);
        register = (Button) v.findViewById(R.id.bt_register);

        /**
         * 点击事件
         */

        getCode.setOnClickListener(this);
        register.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_getCode:
                getCode();
                break;
            case R.id.bt_register:
                submitCode();
                break;
            default:
                break;
        }
    }
    /**
     * 获取验证码
     */
    private boolean getCode() {
        new MyCountDownTimer(60*1000,1000);
        return true;
    }
    /**
     * 提交验证码
     */
    private void submitCode() {

    }

    /**
     * 事务处理
     */
    private void MSG() {

    }

    /**
     * 倒计时
     */
    private class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        //计时过程
        @Override
        public void onTick(long l) {
            //防止计时过程中重复点击
            getCode.setClickable(false);
            getCode.setText((l / 1000) + "s");
        }

        //计时完毕的方法
        @Override
        public void onFinish() {
            //重新给Button设置文字
            getCode.setText("重新获取");
            //设置可点击
            getCode.setClickable(true);
        }
    }


    /**
     * 销毁事务处理
     */
    public void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterEventHandler(eventHandler);
    }


}
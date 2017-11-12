package com.base.xiaopa.activitys;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;


import com.base.xiaopa.db.User;
import com.xiaopa.android.R;


import java.util.ArrayList;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Ivan on 2017/11/8.
 */

public class Log_RegActivity extends FragmentActivity implements View.OnClickListener{
    private TextView mLogin;
    private TextView mRegiser;
    private TextView mGuest;
    
    ViewPager vp_pager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        //初始化SDK
        Bmob.initialize(this,"a726b4b77fd79e10dadd5eec1b849975");
        fragmentpage();

    }
    public void fragmentpage()
    {
        final ArrayList<Fragment> list =new ArrayList<Fragment>();
        list.add(new LoginActivity());
        list.add(new RegisterActivity());

        mLogin = (TextView) findViewById(R.id.tv_login);
        mRegiser = (TextView) findViewById(R.id.tv_register);
        mGuest= (TextView) findViewById(R.id.guest);
        mGuest.setOnClickListener(this);

        FragmentStatePagerAdapter adapter_f=new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public void finishUpdate(ViewGroup container) {
                super.finishUpdate(container);

                if(vp_pager.getCurrentItem()==0)
                {
                    mLogin.setTextColor(Color.parseColor("#FFFFFF"));
                    mRegiser.setTextColor(Color.parseColor("#878787"));


                }else if(vp_pager.getCurrentItem()==1) {
                    mLogin.setTextColor(Color.parseColor("#878787"));
                    mRegiser.setTextColor(Color.parseColor("#FFFFFF"));
                }


            }
        };
        vp_pager= (ViewPager) findViewById(R.id.vp_3);
        vp_pager.setAdapter(adapter_f);
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.guest:
                Intent intent =new Intent(Log_RegActivity.this,MainActivity.class);
                startActivity(intent);
                onDestroy();
                break;
            default :
                break;
        }

    }
    public void login(View v)
    {
        vp_pager.setCurrentItem(0,true);
    }
    public  void register(View v){
        vp_pager.setCurrentItem(1,true);
    }
}

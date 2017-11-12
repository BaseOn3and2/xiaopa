package com.base.xiaopa.activitys;

import android.os.Bundle;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;

import android.support.v4.view.ViewPager;


import android.view.View;
import android.view.ViewGroup;


import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.base.xiaopa.db.User;
import com.base.xiaopa.view.SlidingMenu;
import com.xiaopa.android.R;

import java.util.ArrayList;

import cn.bmob.sms.BmobSMS;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;


public class MainActivity extends FragmentActivity implements View.OnClickListener {


    /**
     * Tab 以及按钮
     */

    private ImageButton mHomePageImg;
    private ImageButton mGroupChatImg;
    private ImageButton mTrendsImg;
    private ImageButton mMallImg;
    private ImageButton mMeImg;
    private SlidingMenu mMenu;
    private ImageView mSearch;
    private ImageView mAdd;
    private TextView mTitle;

    ViewPager vp_pager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




//        mMenu =(SlidingMenu)findViewById(R.id.id_menu);
        fragmentpage();

    }
    public void fragmentpage()
    {
        final ArrayList<Fragment> list =new ArrayList<Fragment>();
        list.add(new GroupActivity());
        list.add(new TrendsActivity());
        list.add(new HomeActivity());
        list.add(new StoreActivity());
        list.add(new MeActivity());
        mSearch = (ImageView) findViewById(R.id.bt_search);
        mAdd =(ImageView)findViewById(R.id.bt_add);
        mTitle =(TextView)findViewById(R.id.tv_title);

        mHomePageImg= (ImageButton) findViewById(R.id.id_home_img);
        mTrendsImg= (ImageButton) findViewById(R.id.id_trends_img);
        mMallImg= (ImageButton) findViewById(R.id.id_mall_img);
        mMeImg= (ImageButton) findViewById(R.id.id_me_img);
        mGroupChatImg= (ImageButton) findViewById(R.id.id_chat_img);

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
                   resetImg();
                    mSearch.setVisibility(View.VISIBLE);
                    mAdd.setVisibility(View.VISIBLE);
                    mAdd.setImageResource(R.drawable.add);
                    mTitle.setText("群聊");
                    mGroupChatImg.setBackgroundResource(R.drawable.chat_blue);
                }else if(vp_pager.getCurrentItem()==1)
                {
                    resetImg();
                    mSearch.setVisibility(View.GONE);
                    mAdd.setVisibility(View.GONE);
                    mTitle.setText("动态");
                    mTrendsImg.setBackgroundResource(R.drawable.trends_blue);

                }else if(vp_pager.getCurrentItem()==2)
                {
                    resetImg();
                    mSearch.setVisibility(View.GONE);
                    mAdd.setVisibility(View.GONE);
                    mTitle.setText("主页");
                    mHomePageImg.setBackgroundResource(R.drawable.home_blue);

                }else  if(vp_pager.getCurrentItem()==3)
                {
                    resetImg();
                    mSearch.setVisibility(View.VISIBLE);
                    mAdd.setImageResource(R.drawable.mall_grey);
                    mTitle.setText("商城");
                    mMallImg.setBackgroundResource(R.drawable.mall_blue);

                }else  if(vp_pager.getCurrentItem()==4){
                    resetImg();
                    mSearch.setVisibility(View.GONE);
                    mAdd.setVisibility(View.GONE);
                    mTitle.setText("我的");
                    mMeImg.setBackgroundResource(R.drawable.me_blue);
                }


            }
        };
        vp_pager= (ViewPager) findViewById(R.id.vp_mf);
        vp_pager.setAdapter(adapter_f);
    }


    @Override
    public void onClick(View v) {

    }
    public void groupChat(View v) {
        vp_pager.setCurrentItem(0,true);
    }
    public  void trends(View v){
        vp_pager.setCurrentItem(1,true);
    }
    public void home(View v){
        vp_pager.setCurrentItem(2,true);
    }
    public void shop(View v){
        vp_pager.setCurrentItem(3,true);
    }
    public void me(View v){
        vp_pager.setCurrentItem(4,true);
    }


    public void resetImg()
    {

        mHomePageImg.setBackgroundResource(R.drawable.home_black);
        mTrendsImg.setBackgroundResource(R.drawable.trends_black);
        mMallImg.setBackgroundResource(R.drawable.mall_black);
        mMeImg.setBackgroundResource(R.drawable.me_black);
        mGroupChatImg.setBackgroundResource(R.drawable.chat_black);
    }
}

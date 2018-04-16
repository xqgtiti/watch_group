package com.example.xqg.weartest;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.xqg.weartest.adapter.FragmentAdapter;
import com.example.xqg.weartest.fragment.BindFragment;
import com.example.xqg.weartest.fragment.DataFragment;
import com.example.xqg.weartest.fragment.MomentsFragment;
import com.example.xqg.weartest.fragment.SetFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tab_title;
    private ViewPager vp_pager;

    private List<String> list_title;                                      //tab名称列表
    private List<View> listViews;
    private List<Fragment> list_fragment;

    private FragmentAdapter fAdapter;                                     //定义以fragment为切换的adapter

    private SetFragment setFragment;
    private MomentsFragment momentsFragment;
    private BindFragment bindFrament;
    private DataFragment dataFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        setContentView(R.layout.activity_main);
        initView();
        fragmentChange();
        showMood();

    }
    void initView(){
        tab_title = (TabLayout)findViewById(R.id.tab_title);
        vp_pager = (ViewPager)findViewById(R.id.vp_pager);
    }
    /**
     * 采用viewpager中切换fragment
     */
    private void fragmentChange()
    {

        list_fragment = new ArrayList<Fragment>();

        setFragment = new SetFragment();
        momentsFragment = new MomentsFragment();
        bindFrament = new BindFragment();
        dataFragment = new DataFragment();

        list_fragment.add(setFragment);
        list_fragment.add(momentsFragment);
        list_fragment.add(bindFrament);
        list_fragment.add(dataFragment);

        list_title = new ArrayList<>();
        list_title.add("设置");
        list_title.add("心情");
        list_title.add("绑定");
        list_title.add("信息");
//将tabLayout与viewpager连起来
        tab_title.setupWithViewPager(vp_pager);
        fAdapter = new FragmentAdapter(getSupportFragmentManager(),list_fragment,list_title);
        vp_pager.setAdapter(fAdapter);
    }

    void showMood(){

    }
}

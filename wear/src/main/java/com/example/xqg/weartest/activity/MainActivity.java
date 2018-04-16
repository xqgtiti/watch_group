package com.example.xqg.weartest.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Toast;

import com.example.xqg.weartest.R;
import com.example.xqg.weartest.bean.AppFunc;
import com.example.xqg.weartest.fragment.BackHandledFragment;
import com.example.xqg.weartest.fragment.BackHandledInterface;
import com.example.xqg.weartest.fragment.MainFragment;

import java.util.ArrayList;
public class MainActivity extends Activity implements BackHandledInterface{


    private BackHandledFragment mBackHandedFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }


    void initView(){

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if(getFragmentManager().findFragmentByTag("fragment_main") == null){
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.main_framelayout,MainFragment.newInstance(),"fragment_main");
            transaction.commit();
        }
        //Toast.makeText(this, "您已经坐了很久了!起来活动一下吧", Toast.LENGTH_SHORT).show();
        //ft.add(R.id.main_framelayout,MoodCurveFragment.newInstance(),"node_mood_fragment");
        //ft.add(R.id.main_framelayout,SitLongCallFragment.newInstance(),"sit_long_fragment");


        //getFragmentManager().beginTransaction().hide(getFragmentManager().findFragmentByTag("main_fragment")).commit();
       // getFragmentManager().beginTransaction().hide(getFragmentManager().findFragmentByTag("node_mood_fragment")).commit();
       // getFragmentManager().beginTransaction().hide(getFragmentManager().findFragmentByTag("sit_long_fragment")).commit();
       // ft.add(R.id.main_framelayout,CheckMoodFragment.newInstance(),"main_fragment");
       // ft.add(R.id.main_framelayout,MainFragment.newInstance(),"main_fragment");




    }

    private ArrayList<AppFunc> getData() {
        //传入Adapter的数据
        ArrayList<AppFunc> data = new ArrayList<>();
        data.add(new AppFunc("记录心情",R.mipmap.ic_favorite_black_24dp));
        data.add(new AppFunc("久坐提醒",R.mipmap.ic_accessible_black_24dp));
        data.add(new AppFunc("智能心情检测",R.mipmap.ic_share_black_24dp));
        data.add(new AppFunc("数据统计",R.mipmap.ic_description_black_24dp));

        return data;
    }

    @Override
    public void setSelectedFragment(BackHandledFragment selectedFragment) {
        this.mBackHandedFragment = selectedFragment;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(mBackHandedFragment == null || !mBackHandedFragment.onBackPressed()){
            if(getFragmentManager().getBackStackEntryCount() == 0){
                super.onBackPressed();
            }else{
                getFragmentManager().popBackStack();
            }
        }
    }
}

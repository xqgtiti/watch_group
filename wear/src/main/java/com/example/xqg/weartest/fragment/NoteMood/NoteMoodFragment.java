package com.example.xqg.weartest.fragment.NoteMood;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.xqg.weartest.R;
import com.example.xqg.weartest.adapter.MainRecyclerViewAdapter;
import com.example.xqg.weartest.bean.AppFunc;
import com.example.xqg.weartest.fragment.SitLong.SitLongCallFragment;

import java.util.ArrayList;

/**
 * Created by xqg on 2017/8/31.
 */

public class NoteMoodFragment extends Fragment {
    private RecyclerView mRecyclerView;
    public NoteMoodFragment(){

    }
    public static NoteMoodFragment newInstance() {
        NoteMoodFragment fragment = new NoteMoodFragment();
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_note_mood, container, false);
        initView(view);
        return view;
    }

    void initView(View view){
        mRecyclerView = (RecyclerView) view.findViewById(R.id.mood_recycler);
        //保持固定大小 提高性能
        mRecyclerView.setHasFixedSize(true);

        //需要横向或竖直则需要使用LayoutManager, 设置滚动方向, 默认竖直滚动
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);

        //设置Adapter
        MainRecyclerViewAdapter mAdapter = new MainRecyclerViewAdapter(getData());
        mAdapter.setOnItemClickListener(new MainRecyclerViewAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
                Toast.makeText(getActivity().getApplicationContext(), ""+postion, Toast.LENGTH_SHORT).show();

                if (postion == 0){
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.main_framelayout, ChooseMoodFragment.newInstance(),"");
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                else if (postion == 1){

                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.main_framelayout,MoodCurveFragment.newInstance(),"");
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                else if(postion == 2){
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.main_framelayout,BlindSocialFragment.newInstance(),"");
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }

    private ArrayList<AppFunc> getData() {
        //传入Adapter的数据
        ArrayList<AppFunc> data = new ArrayList<>();
        data.add(new AppFunc("选择心情",R.mipmap.ic_mood_black_24dp));
        data.add(new AppFunc("生成心情曲线",R.mipmap.ic_settings_backup_restore_black_24dp));
        data.add(new AppFunc("绑定微信",R.mipmap.ic_important_devices_black_24dp));
        return data;
    }

}

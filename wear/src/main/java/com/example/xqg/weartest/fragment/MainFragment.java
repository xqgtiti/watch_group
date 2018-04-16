package com.example.xqg.weartest.fragment;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xqg.weartest.R;
import com.example.xqg.weartest.adapter.MainRecyclerDividerItemDecoration;
import com.example.xqg.weartest.adapter.MainRecyclerViewAdapter;
import com.example.xqg.weartest.bean.AppFunc;
import com.example.xqg.weartest.fragment.CheckMood.CheckMoodFragment;
import com.example.xqg.weartest.fragment.NoteMood.NoteMoodFragment;
import com.example.xqg.weartest.fragment.SitLong.SitLongCallFragment;

import java.util.ArrayList;

/**
 * Created by xqg on 2017/9/2.
 */

public class MainFragment extends BackHandledFragment{
    private boolean hadIntercept;
    private RecyclerView mRecyclerView;
    private TextView mTextView;
    private ArrayList <String> tags = new ArrayList<>();
    public MainFragment(){

    }
    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public boolean onBackPressed() {
        if(hadIntercept){
            return false;
        }else{
            Toast.makeText(getActivity(), "Click MyFragment", Toast.LENGTH_SHORT).show();
            hadIntercept = true;
            return true;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_main, container, false);
        initView(view);
        return view;
    }

    void initView(View view){
        tags.add("fragment_main");
        tags.add("fragment_node");
        tags.add("fragment_sit");
        tags.add("fragment_check");
        tags.add("fragment_data");

        mRecyclerView = (RecyclerView) view.findViewById(R.id.main_recycler);
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
                    //getFragmentManager().beginTransaction().replace(R.id.main_framelayout,SitLongCallFragment.newInstance(),tags.get(postion+1)).commit();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.main_framelayout, NoteMoodFragment.newInstance(),tags.get(postion+1));
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                else if (postion == 1){
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.main_framelayout, SitLongCallFragment.newInstance(),tags.get(postion+1));
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                else if(postion == 2){
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.main_framelayout, CheckMoodFragment.newInstance(),tags.get(postion+1));
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                else if(postion == 3){

                }
            }
        });
        mRecyclerView.setAdapter(mAdapter);

        //设置Item动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //设置Item间隔样式
        mRecyclerView.addItemDecoration(new MainRecyclerDividerItemDecoration(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL));
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
}

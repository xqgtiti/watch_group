package com.example.xqg.weartest.fragment.NoteMood;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.wearable.view.CircledImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xqg.weartest.R;

/**
 * Created by xqg on 2017/9/3.
 */

public class ChooseMoodFragment extends Fragment {

    CircledImageView happy, unhappy, neutral, dissatisfied;
    public ChooseMoodFragment(){

    }
    public static ChooseMoodFragment newInstance() {
        ChooseMoodFragment  fragment = new ChooseMoodFragment();
        return fragment;
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_chose_mod, container, false);
        initView(view);
        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    void initView(View view){
        happy = (CircledImageView)view.findViewById(R.id.bt_happy);
        unhappy = (CircledImageView)view.findViewById(R.id.bt_un_happy);
        neutral = (CircledImageView)view.findViewById(R.id.bt_neutral);
        dissatisfied = (CircledImageView)view.findViewById(R.id.bt_dissatisfied);

        happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_framelayout, SaveMoodOkFragment.newInstance(),"");
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        unhappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_framelayout, SaveMoodOkFragment.newInstance(),"");
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        neutral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_framelayout, SaveMoodOkFragment.newInstance(),"");
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        dissatisfied.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_framelayout, SaveMoodOkFragment.newInstance(),"");
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}

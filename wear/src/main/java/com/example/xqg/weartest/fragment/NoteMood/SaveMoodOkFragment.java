package com.example.xqg.weartest.fragment.NoteMood;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xqg.weartest.R;

/**
 * Created by xqg on 2017/9/3.
 */

public class SaveMoodOkFragment extends Fragment {
    public SaveMoodOkFragment(){

    }
    public static SaveMoodOkFragment newInstance() {
        SaveMoodOkFragment fragment = new SaveMoodOkFragment();
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_mood_saveok, container, false);
        initView(view);
        return view;
    }

    void initView(View view){

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}

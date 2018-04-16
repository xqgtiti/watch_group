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

public class BlindSocialFragment extends Fragment{
    public BlindSocialFragment(){

    }
    public static BlindSocialFragment newInstance() {
        BlindSocialFragment fragment = new BlindSocialFragment();
        return fragment;
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_blind_wx, container, false);
        initView(view);
        return view;
    }

    void initView(View view){

    }
}

package com.example.xqg.weartest.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xqg.weartest.R;

/**
 * Created by xqg on 2017/10/10.
 */

public class BindFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bind, container, false);
        return view;
    }
}

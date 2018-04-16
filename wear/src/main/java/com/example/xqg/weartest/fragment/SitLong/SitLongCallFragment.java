package com.example.xqg.weartest.fragment.SitLong;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.xqg.weartest.R;
import com.example.xqg.weartest.bean.Data;
import com.example.xqg.weartest.bean.UserInfo;
import com.kyleduo.switchbutton.SwitchButton;

/**
 * Created by xqg on 2017/8/31.
 */

public class SitLongCallFragment extends Fragment {
    private SwitchButton mSwitchButton;
    private boolean hadIntercept;
    public SitLongCallFragment() {

    }

    public static SitLongCallFragment newInstance() {
        SitLongCallFragment fragment = new SitLongCallFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
               // getFragmentManager().popBackStack();
                Toast.makeText(getActivity().getApplicationContext(), "返回堆状态发生改变", Toast.LENGTH_LONG).show();
            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sit_long_call, container, false);
        initView(view);
        return view;
    }

    void initView(View view) {
        mSwitchButton = (SwitchButton)view.findViewById(R.id.sit_long_on_off);
        final Data data = (Data) getActivity().getApplication();
        UserInfo userInfo = data.getUserInfo();
        int buttonStatus = userInfo.getStatusSitLongCall();

        if (buttonStatus == 1) mSwitchButton.setChecked(true);
        else mSwitchButton.setChecked(false);

        mSwitchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Toast.makeText(getActivity().getApplicationContext(), "开启", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "关闭", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    protected boolean onBackPressed() {
        if(hadIntercept){
            return false;
        }else{
            Toast.makeText(getActivity(), "Click MyFragment", Toast.LENGTH_SHORT).show();
            hadIntercept = true;
            return true;
        }
    }
}

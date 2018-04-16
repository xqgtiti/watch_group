package com.example.xqg.weartest.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;


/**
 * Created by xqg on 2017/9/2.
 */

public abstract class BackHandledFragment extends Fragment {


    protected BackHandledInterface mBackHandledInterface;
    public abstract boolean onBackPressed();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(!(getActivity() instanceof BackHandledInterface)){
            throw new ClassCastException("Hosting Activity must implement BackHandledInterface");
        }else{
            this.mBackHandledInterface = (BackHandledInterface)getActivity();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        //告诉FragmentActivity，当前Fragment在栈顶
        mBackHandledInterface.setSelectedFragment(this);
    }
}

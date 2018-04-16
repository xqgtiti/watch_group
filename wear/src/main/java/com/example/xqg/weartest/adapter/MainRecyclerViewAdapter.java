package com.example.xqg.weartest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.xqg.weartest.R;
import com.example.xqg.weartest.bean.AppFunc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xqg on 2017/8/31.
 */

public class MainRecyclerViewAdapter extends RecyclerView.Adapter <MainRecyclerViewAdapter.ViewHolder>{

    private ArrayList <AppFunc> list;
    private MyItemClickListener mItemClickListener;

    public interface MyItemClickListener {
        public void onItemClick(View view,int postion);
    }
    public void setOnItemClickListener(MyItemClickListener listener){
        this.mItemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //实例化展示的view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_main, parent,false);
        //实例化viewholer
        ViewHolder viewHolder = new ViewHolder(view, mItemClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MainRecyclerViewAdapter.ViewHolder holder, final int position) {
        //绑定数据
        holder.mText.setText(list.get(position).getFuncName());
        holder.mIcon.setImageResource(list.get(position).getFuncIcon());
    }


    public MainRecyclerViewAdapter(ArrayList<AppFunc> list){
        //初始化,传入列表数据
        this.list = list;
    }


    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mText;
        ImageView mIcon;
        private MyItemClickListener mListener;


        public ViewHolder(View itemView,MyItemClickListener listener) {
            super(itemView);
            mText = (TextView) itemView.findViewById(R.id.item_recycler_main_item);
            mIcon = (ImageView) itemView.findViewById(R.id.item_icon);
            this.mListener = listener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if(mListener != null){
                mListener.onItemClick(view,getPosition());
            }
        }
    }


}

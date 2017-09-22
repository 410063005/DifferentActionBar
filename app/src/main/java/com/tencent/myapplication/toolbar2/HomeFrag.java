package com.tencent.myapplication.toolbar2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tencent.myapplication.R;
import com.tencent.myapplication.frag.ToolbarFrag;

/**
 * Created by 410063005 on 2017/9/20.
 */

public class HomeFrag extends ToolbarFrag {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        return view;
    }

    @Override
    public Toolbar getToolbar() {
        mToolbar.setTitle("Home");
        mToolbar.setNavigationIcon(new DrawerArrowDrawable(getContext()));
        return mToolbar;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() instanceof AppCompatActivity) {
            AppCompatActivity a = (AppCompatActivity) getActivity();
            a.setSupportActionBar(getToolbar());
        }
    }
}

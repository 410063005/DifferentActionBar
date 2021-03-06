package com.tencent.myapplication.toolbar1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tencent.myapplication.R;
import com.tencent.myapplication.frag.ToolbarFrag;
import com.tencent.myapplication.frag.ToolbarUi;

/**
 * Created by 410063005 on 2017/9/20.
 */

public class SettingsFrag extends ToolbarFrag {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() instanceof ToolbarUi) {
            ToolbarUi host = (ToolbarUi) getActivity();
            host.setToolbar(getToolbar());
        }
    }

    @Override
    public Toolbar getToolbar() {
        mToolbar.setTitle("Settings");
        return mToolbar;
    }

}

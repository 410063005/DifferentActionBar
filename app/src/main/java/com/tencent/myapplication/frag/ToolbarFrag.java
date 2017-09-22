package com.tencent.myapplication.frag;

import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;

/**
 * Created by 410063005 on 2017/9/22.
 */

public abstract class ToolbarFrag extends Fragment {

    protected Toolbar mToolbar;

    public Toolbar getToolbar() {
        return mToolbar;
    }
}

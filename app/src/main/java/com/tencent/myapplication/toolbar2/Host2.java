package com.tencent.myapplication.toolbar2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.tencent.myapplication.R;
import com.tencent.myapplication.frag.ToolbarFrag;

/**
 * Created by 410063005 on 2017/9/22.
 */

public class Host2 extends AppCompatActivity {

    private Pa mPa;

    public static void start(Context context) {
        Intent starter = new Intent(context, Host2.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.host2);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager.setAdapter(mPa = new Pa(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                ToolbarFrag fragment = (ToolbarFrag) mPa.getRegisteredItem(position);
                if (fragment != null) {
                    setToolbar(fragment.getToolbar());
                }
            }
        });
    }

    private void setToolbar(Toolbar toolbar) {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        } else {
            setSupportActionBar(null);
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    private static class Pa extends SmartFragmentPagerAdapter {

        Pa(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new HomeFrag();

                case 1:
                    return new ListFrag();

                case 2:
                    return new SettingsFrag();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Home";

                case 1:
                    return "List";

                case 2:
                    return "Settings";
            }
            return "";
        }
    }

    private static abstract class SmartFragmentPagerAdapter extends FragmentPagerAdapter {
        private SparseArray<Fragment> mRegisteredFragments = new SparseArray<>();

        private SmartFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Fragment fragment = (Fragment) super.instantiateItem(container, position);
            mRegisteredFragments.put(position, fragment);
            return fragment;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            mRegisteredFragments.remove(position);
            super.destroyItem(container, position, object);
        }

        @Nullable
        Fragment getRegisteredItem(int position) {
            return mRegisteredFragments.get(position);
        }
    }
}

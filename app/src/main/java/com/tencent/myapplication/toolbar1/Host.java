package com.tencent.myapplication.toolbar1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.tencent.myapplication.R;
import com.tencent.myapplication.frag.ToolbarUi;

/**
 * Created by 410063005 on 2017/9/20.
 */

public class Host extends AppCompatActivity implements ToolbarUi {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    public static void start(Context context) {
        Intent starter = new Intent(context, Host.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.host);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav);

        navigationView.setCheckedItem(R.id.home);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                mDrawerLayout.closeDrawers();
                FragmentTransaction t;
                switch (item.getItemId()) {
                    case R.id.home:
                        t = getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fl_container, new HomeFrag());
//                        t.addToBackStack(null);
                        t.commit();
                        break;

                    case R.id.list:
                        t = getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fl_container, new ListFrag());
//                        t.addToBackStack(null);
                        t.commit();
                        break;

                    case R.id.settings:
                        t = getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fl_container, new SettingsFrag());
//                        t.addToBackStack(null);
                        t.commit();
                        break;
                }

                return true;
            }
        });

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fl_container, new HomeFrag()).commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle != null && mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setToolbar(Toolbar toolbar) {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        } else {
            setSupportActionBar(null);
        }

        if (mDrawerToggle != null) {
            mDrawerLayout.removeDrawerListener(mDrawerToggle);
            mDrawerToggle = null;
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_launcher);

            mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, 0, 0);
            mDrawerLayout.addDrawerListener(mDrawerToggle);
            mDrawerToggle.syncState();
        }
    }
}

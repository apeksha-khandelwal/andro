package com.example.apekshakhandelwal.music;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class MActivity extends AppCompatActivity {
    ViewPager Tab;
    TabPagerAdapter TabAdapter;
    android.support.v7.app.ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m);
        actionBar=getSupportActionBar();
        TabAdapter = new TabPagerAdapter(getSupportFragmentManager());

        Tab = (ViewPager) findViewById(R.id.pager);
        Tab.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener()
        {
                    @Override
                    public void onPageSelected(int position)
                    {
                        actionBar = getSupportActionBar();
                        actionBar.setSelectedNavigationItem(position);
                    }
         });

        Tab.setAdapter(TabAdapter);

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        ActionBar.TabListener tabListener = new ActionBar.TabListener()
        {

            @Override
            public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
                Tab.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

            }
        };
        actionBar.addTab(actionBar.newTab().setText("Playlists").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("Artist").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("Album").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("Songs").setTabListener(tabListener));

    }

}

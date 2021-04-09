package com.example.apekshakhandelwal.music;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.apekshakhandelwal.music.frame.albumf;
import com.example.apekshakhandelwal.music.frame.artist;
import com.example.apekshakhandelwal.music.frame.playlist;
import com.example.apekshakhandelwal.music.frame.song;


/**
 * Created by Apeksha Khandelwal on 25-05-2017.
 */

public class TabPagerAdapter extends FragmentStatePagerAdapter
{
    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i)
    {
        switch (i) {
            case 0:
                return new playlist();
            case 1:
                return new artist();
            case 2:
                return new albumf();
            case 3:
                return new song();
        }
        return null;

    }

    @Override
    public int getCount() {
        return 4;
    }
}

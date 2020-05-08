package com.fosung.wj.adapter;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.fosung.wj.FirstFragment;
import com.fosung.wj.SecondFragment;
import com.fosung.wj.ThirdFragment;

/**
 * Company：fosung
 * Author： shanghome on 2020-05-06 18:16.
 * RealName：商学壮
 * Email：shanghome@163.com
 * Description：
 */
public class MainFragmentsAdapter extends FragmentPagerAdapter {
    public MainFragmentsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0: fragment =  new FirstFragment();break;
            case 1: fragment = new  SecondFragment(); break;
            case 2: fragment = new ThirdFragment();break;
            default:return null;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }


}

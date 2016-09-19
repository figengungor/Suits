package com.figengungor.suits.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> fragmentListesi = new ArrayList<>();
        private final List<String> fragmentBaslikListesi = new ArrayList<>();
 
        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }
 
        @Override
        public Fragment getItem(int position) {
            return fragmentListesi.get(position);
        }
 
        @Override
        public int getCount() {
            return fragmentListesi.size();
        }
 
        public void addFragment(Fragment fragment, String title) {
            fragmentListesi.add(fragment);
            fragmentBaslikListesi.add(title);
        }
 
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentBaslikListesi.get(position);
        }
    }
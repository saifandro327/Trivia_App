package com.app.triviaapp.view;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.app.triviaapp.utils.FragmentCreator;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
private final List<FragmentCreator> fragmentList=new ArrayList<>();

public ViewPagerAdapter(FragmentManager fragmentManager){
    super(fragmentManager);
}


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position).createFragment();
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
    public void addFragment(FragmentCreator fragmentCreator,String title) {
        addFragment(fragmentCreator);
    }
    public void addFragment(FragmentCreator fragmentCreator){
    fragmentList.add(fragmentCreator);
    }


}

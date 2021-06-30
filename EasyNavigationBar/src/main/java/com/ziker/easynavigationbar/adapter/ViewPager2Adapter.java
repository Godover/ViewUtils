package com.ziker.easynavigationbar.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

/**
 * ***********************************************
 * **            佛祖保佑  镇类之宝              **
 * ***********************************************
 *
 * @author ziker
 * @date 2021/6/1 10:22
 **/
public class ViewPager2Adapter extends FragmentStateAdapter {

    private final List<Fragment> fragments;


    public ViewPager2Adapter(@NonNull FragmentActivity fragmentActivity, List<Fragment> fragments) {
        super(fragmentActivity);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments == null ? 0 : fragments.size();
    }
}

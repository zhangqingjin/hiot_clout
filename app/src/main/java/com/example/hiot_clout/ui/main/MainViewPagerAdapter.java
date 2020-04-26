package com.example.hiot_clout.ui.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.example.hiot_clout.utils.Constant;

class MainViewPagerAdapter extends FragmentPagerAdapter {
    public MainViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        switch (position){
            case Constant.MAIN_VIEWPAGER_INDEX_MESSAGE:
                fragment=MassageFragment.newInstance();
                break;
            case Constant.MAIN_VIEWPAGER_INDEX_EQUIPMENT:
                fragment=EquipmentFragment.newInstance();
                break;
            case Constant.MAIN_VIEWPAGER_INDEX_SCENE:
                fragment=SceneFragment.newInstance();
                break;
            case Constant.MAIN_VIEWPAGER_INDEX_MINE:
                fragment=MineFragment.newInstance();
                break;
            default:;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return Constant.MAIN_FRAGMENT_COUNT;
    }
}

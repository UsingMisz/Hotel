package main.zzy.com.hotel.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import main.zzy.com.hotel.DingDanThreeAgoFragment;
import main.zzy.com.hotel.DingDanThreeFragment;
import main.zzy.com.hotel.R;

/**
 * @author zzy
 * @fileName DingDanPagerAdapter
 * @date 2017/12/2616:47
 * @email 747608835@qq.com
 */

public class DingDanPagerAdapter extends FragmentPagerAdapter {
    private final String[] TITLES;
    private Fragment[] fragments;
    public DingDanPagerAdapter(FragmentManager fm,Context context) {
        super(fm);
        TITLES = context.getResources().getStringArray(R.array.sections);
        fragments = new Fragment[TITLES.length];
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position) {
        if (fragments[position] == null) {
            switch (position) {
                case 0:
                    fragments[position] = DingDanThreeAgoFragment.newIntance();
                    break;
                case 1:
                    fragments[position] = DingDanThreeFragment.newIntance();
                    break;
                default:
                    break;
            }
        }
        return fragments[position];
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }
}

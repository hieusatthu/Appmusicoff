package t3h.com.appmusic.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by songsong on 5/13/2018.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;

    public FragmentAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return "Songs";
            case 1:
                return "Singer";

            case 2:
                return "Album";
            default:
                return null;
        }
    }
}

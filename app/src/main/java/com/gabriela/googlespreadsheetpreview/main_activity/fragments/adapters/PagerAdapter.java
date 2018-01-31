package com.gabriela.googlespreadsheetpreview.main_activity.fragments.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.widget.SwipeRefreshLayout;

import com.gabriela.googlespreadsheetpreview.R;
import com.gabriela.googlespreadsheetpreview.main_activity.fragments.view.SheetFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class PagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment, String title) {
        fragments.add(fragment);
        titleList.add(title);
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return SheetFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}

package comp.cumulus.projectzhou1.adapet;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.ActionBar;

import java.util.ArrayList;

import comp.cumulus.projectzhou1.activity.FigureActivity;

/**
 * Created by Lenovo on 2019/3/31.
 */

public class FigureAdapet extends FragmentPagerAdapter {

    private final ArrayList<Fragment> mfragments;
    private final ArrayList<String> mlist;

    public FigureAdapet(FragmentManager supportFragmentManager, ArrayList<Fragment> fragments, ArrayList<String> list) {
        super(supportFragmentManager);
        this.mfragments = fragments;
        this.mlist = list;
    }

    @Override
    public Fragment getItem(int position) {
        return mfragments.get(position);
    }

    @Override
    public int getCount() {
        return mfragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mlist.get(position);
    }
}

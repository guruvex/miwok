package com.example.android.miwok;

/**
 * Created by james on 7/10/2018.
 */
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Provides the appropriate {@link Fragment} for a view pager.
 */
public class SimplePageAdaptor extends FragmentPagerAdapter {

    /** Context of the app */
    private Context mContext;

    public SimplePageAdaptor (FragmentManager fm, Context context) {
        super(fm);
        mContext = context;

    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) { return new NumbersFragment();
        } else if (position == 1){ return new FamilyFragment();
        } else if (position == 2){ return new ColorsFragment();
        } else { return new PhrasesFragment();}
    }

    @Override
    public int getCount() {
        return 4;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_numbers);
        } else if (position == 1) {
            return mContext.getString(R.string.category_family);
        } else if (position == 2) {
            return mContext.getString(R.string.category_colors);
        } else {
            return mContext.getString(R.string.category_phrases);
        }
    }
}


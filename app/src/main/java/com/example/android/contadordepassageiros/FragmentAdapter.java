package com.example.android.contadordepassageiros;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter {
    private Context context;

    public FragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    //    Displays each fragment into the tabs according to the position requested
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ContadorFragment();
        } else if (position == 1) {
            return new DetalhesFragment();
        } else
            return new CpppFragment();
    }

    //Handle the number of tabs shown
    @Override
    public int getCount() {
        return 3;
    }

    //Shows the titles of each tab
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return context.getString(R.string.contador);
        } else if (position == 1) {
            return context.getString(R.string.detalhes);
        } else
            return context.getString(R.string.cppp);

    }
}

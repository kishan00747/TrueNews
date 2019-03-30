package com.kishan00747.truenews;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kishan00747.truenews.model.NewsCategory;
import com.kishan00747.truenews.model.NewsCategoryList;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeedFragment extends Fragment {

    ViewPager mViewPager;
    PagerAdapter pagerAdapter;
    TabLayout tabLayout;

    ArrayList<NewsCategory> newsCategoryList;

    public FeedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        newsCategoryList = new NewsCategoryList().getCategoryArrayList();


        View view = inflater.inflate(R.layout.fragment_feed, container, false);

        mViewPager = (ViewPager) view.findViewById(R.id.pager);
        pagerAdapter = new ScreenSlideAdapter(getActivity().getSupportFragmentManager());
        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        mViewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);


        return view;
    }



    private class ScreenSlideAdapter extends FragmentPagerAdapter
    {
        // overriding getPageTitle()
        @Override
        public CharSequence getPageTitle(int position) {
            return newsCategoryList.get(position).getName();
        }

        public ScreenSlideAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch(position)
            {
                default:
                {
                    Bundle category = new Bundle();

                    category.putParcelable("NEWS_CATEGORY", newsCategoryList.get(position));
                    Fragment fragment = new NewsListFragment();
                    fragment.setArguments(category);

                    return fragment;

                }
            }
        }

        @Override
        public int getCount() {
            return newsCategoryList.size();
        }
    }

}

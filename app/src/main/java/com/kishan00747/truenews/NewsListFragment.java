package com.kishan00747.truenews;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kishan00747.truenews.model.NewsCategory;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsListFragment extends Fragment {


    public NewsListFragment() {


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        NewsCategory newsCategory = getArguments().getParcelable("NEWS_CATEGORY");

        View view = inflater.inflate(R.layout.fragment_news_list, container, false);

        return  view;
    }

}

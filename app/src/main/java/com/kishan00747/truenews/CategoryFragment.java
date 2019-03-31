package com.kishan00747.truenews;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.GridLayout;
import android.widget.ImageView;

import com.kishan00747.truenews.components.CheckableButton;
import com.kishan00747.truenews.model.NewsCategory;
import com.kishan00747.truenews.model.NewsCategoryList;

import java.util.ArrayList;

public class CategoryFragment extends Fragment {

    GridLayout gridLayoutContainer;
    ArrayList<NewsCategory> arrayList;

    ArrayList<String> categoryList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_category, container, false);

        gridLayoutContainer = (GridLayout) view.findViewById(R.id.gl_container);
        gridLayoutContainer.setColumnCount(2);

        categoryList = new ArrayList<>();

        NewsCategoryList list = new NewsCategoryList();
        arrayList = list.getCategoryArrayList();

        for (int i = 0; i < arrayList.size(); i++) {

            createNewButton(i);
        }

        InitialActivity initialActivity = (InitialActivity) getActivity();
        initialActivity.setCategoryList(categoryList);

        return view;
    }

    private void createNewButton(final int i) {

        //ContextThemeWrapper is to add style to button
        final CheckableButton button = new CheckableButton(new ContextThemeWrapper(getContext(), R.style.CheckButton), null, 0);

        gridLayoutContainer.addView(button);
        String name = arrayList.get(i).getName();
        button.setText(name);
        button.setId(i);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckableButton button1 = (CheckableButton)view ;
                String cate = button1.getText().toString();
                if(button1.isChecked()){
                    categoryList.add(cate);
                }
            }
        });

        // Code to stretch the button to fill the grid layout
    GridLayout.LayoutParams param = new GridLayout.LayoutParams(GridLayout.spec(GridLayout.UNDEFINED, 0f), GridLayout.spec(GridLayout.UNDEFINED, 1f));
        param.setMargins(10, 10, 10, 10);
        button.setLayoutParams(param);
    }

}

package com.kishan00747.truenews.model;

import java.util.ArrayList;

public class NewsCategoryList {

    public static ArrayList<NewsCategory> categoryArrayList;

    public NewsCategoryList() {
        categoryArrayList = new ArrayList<NewsCategory>();

        categoryArrayList.add(new NewsCategory("Top", new String[]{"link1", "link2"}));
        categoryArrayList.add(new NewsCategory("Tech", new String[]{"link1", "link2"}));
        categoryArrayList.add(new NewsCategory("Stock", new String[]{"link1", "link2"}));
        categoryArrayList.add(new NewsCategory("Business", new String[]{"link1", "link2"}));
        categoryArrayList.add(new NewsCategory("Newsss", new String[]{"link1", "link2"}));
        categoryArrayList.add(new NewsCategory("More News", new String[]{"link1", "link2"}));
        categoryArrayList.add(new NewsCategory("Much more News", new String[]{"link1", "link2"}));

    }

    public ArrayList<NewsCategory> getCategoryArrayList() {
        return categoryArrayList;
    }
}

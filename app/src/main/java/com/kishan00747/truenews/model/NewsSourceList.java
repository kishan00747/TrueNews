package com.kishan00747.truenews.model;

import java.util.ArrayList;

public class NewsSourceList {

    public static ArrayList<NewsSource> sourceArrayList;

    public NewsSourceList() {

        sourceArrayList = new ArrayList<NewsSource>();

        sourceArrayList.add(new NewsSource("Times of India", new String[]{"link1", "link2"}));
        sourceArrayList.add(new NewsSource("Hindustan Times", new String[]{"link1", "link2"}));
        sourceArrayList.add(new NewsSource("Lokmat", new String[]{"link1", "link2"}));
        sourceArrayList.add(new NewsSource("Politics", new String[]{"link1", "link2"}));
        sourceArrayList.add(new NewsSource("Trending", new String[]{"link1", "link2"}));
        sourceArrayList.add(new NewsSource("Hollywood", new String[]{"link1", "link2"}));
        sourceArrayList.add(new NewsSource("Bollywood", new String[]{"link1", "link2"}));
        sourceArrayList.add(new NewsSource("World", new String[]{"link1", "link2"}));
        sourceArrayList.add(new NewsSource("Top", new String[]{"link1", "link2"}));
        sourceArrayList.add(new NewsSource("Top", new String[]{"link1", "link2"}));

    }

    public ArrayList<NewsSource> getSourceArrayList() {
        return sourceArrayList;
    }
}

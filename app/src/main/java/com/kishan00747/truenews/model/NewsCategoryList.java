package com.kishan00747.truenews.model;

import java.util.ArrayList;

public class NewsCategoryList {

    public ArrayList<NewsCategory> categoryArrayList;

    public NewsCategoryList() {
        categoryArrayList = new ArrayList<NewsCategory>();

//        categoryArrayList.add(new NewsCategory("For You", "top-headlines?country=in&pageSize=30&apiKey=93eddd5558394bb2bab21565ee041d5a"));

        categoryArrayList.add(new NewsCategory("Top", "top-headlines?country=in&pageSize=30&apiKey=93eddd5558394bb2bab21565ee041d5a"));
        categoryArrayList.add(new NewsCategory("Tech", "everything?q=technology&language=en&sources=techradar,wired,ign,techcrunch,ars-technica,mashable,the-verge,the-next-web&domains=cnet.com&sortBy=publishedAt&apiKey=93eddd5558394bb2bab21565ee041d5a"));
        categoryArrayList.add(new NewsCategory("Business", "everything?q=business&language=en&sources=cnbc,financial-times,the-wall-street-journal&sortBy=publishedAt&apiKey=93eddd5558394bb2bab21565ee041d5a"));
        categoryArrayList.add(new NewsCategory("Sports", "everything?q=sports&language=en&sources=espn,espn-cric-info,bbc-sport,fox-sports,the-sport-bible&sortBy=publishedAt&apiKey=93eddd5558394bb2bab21565ee041d5a"));
        categoryArrayList.add(new NewsCategory("Entertainment", "everything?q=\"series\"OR\"movies\"OR\"comics\"OR\"netflix\"OR\"bollywood\"OR\"hollywood\"&domains=imdb.com,rottentomatoes.com,cbr.com,missmalini.com,cinemablend.com&language=en&sortBy=publishedAt&apiKey=93eddd5558394bb2bab21565ee041d5a"));
        categoryArrayList.add(new NewsCategory("Politics", "everything?q=\"law\"OR\"government\"OR\"election\"OR\"trump\"OR\"court\"&sources=the-times-of-india,the-hindu,abc-news,bbc-news&domains=hindustantimes.com,dnaindia.com&language=en&sortBy=publishedAt&apiKey=93eddd5558394bb2bab21565ee041d5a"));
        categoryArrayList.add(new NewsCategory("Science", "everything?q=science&sources=new-scientist,ars-technica,national-geographic&domains=discovery.com,chemistryworld.com,futurism.com&language=en&sortBy=publishedAt&apiKey=93eddd5558394bb2bab21565ee041d5a"));
        categoryArrayList.add(new NewsCategory("Cricket", "everything?q=cricket&language=en&pageSize=25&sortBy=publishedAt&apiKey=93eddd5558394bb2bab21565ee041d5a"));

    }

    public ArrayList<NewsCategory> getCategoryArrayList() {
        return categoryArrayList;
    }

    public void setForYou(String url)
    {
        NewsCategory newsCategory = new NewsCategory("For You", url);
        categoryArrayList.
        categoryArrayList.add(0,newsCategory);
    }
}

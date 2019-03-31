package com.kishan00747.truenews.rest;

import com.kishan00747.truenews.model.NewsApiResponse;
import com.kishan00747.truenews.model.NewsItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface NewsService {

//    @GET("top-headlines?country=in&pageSize=30&apiKey=93eddd5558394bb2bab21565ee041d5a")
//    Call<NewsApiResponse> getNews();

    @GET
    Call<NewsApiResponse> getNews(@Url String categoryLink);
}

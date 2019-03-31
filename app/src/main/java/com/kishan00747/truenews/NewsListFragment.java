package com.kishan00747.truenews;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kishan00747.truenews.model.NewsApiResponse;
import com.kishan00747.truenews.model.NewsCategory;
import com.kishan00747.truenews.model.NewsItem;
import com.kishan00747.truenews.rest.NewsService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.support.constraint.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsListFragment extends Fragment {

    Retrofit retrofit;
    RecyclerView recyclerView;
    NewsAdapter newsAdapter;
    ArrayList<NewsItem> newsItemArrayList;
    SwipeRefreshLayout swipeRefreshLayout;
    private boolean loading = true;
    private int previousTotal = 0;
    private int visibleThreshold = 5;

    private int currentPage = 1;



    public NewsListFragment() {


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final NewsCategory newsCategory = getArguments().getParcelable("NEWS_CATEGORY");
        newsItemArrayList = new ArrayList<NewsItem>();

        View view = inflater.inflate(R.layout.fragment_news_list, container, false);

        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                newsFetch(newsCategory);
            }
        });

        recyclerView = (RecyclerView) view.findViewById(R.id.rv_news_list);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        final LinearLayoutManager mLinearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();


        recyclerView.setLayoutManager(mLinearLayoutManager);

        newsAdapter = new NewsAdapter(newsItemArrayList, getContext());

        recyclerView.setAdapter(newsAdapter);

        newsFetch(newsCategory);


        return view;
    }

    public void newsFetch(NewsCategory newsCategory)
    {

        swipeRefreshLayout.setRefreshing(true);

        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }


        NewsService newsService = retrofit.create(NewsService.class);

        Call<NewsApiResponse> newsApiResponseCall = newsService.getNews(newsCategory.getLink());
        Log.d("Retrofit response", newsApiResponseCall.request().toString());

        newsApiResponseCall.enqueue(new Callback<NewsApiResponse>() {
            @Override
            public void onResponse(Call<NewsApiResponse> call, Response<NewsApiResponse> response) {


                if(response.body().getStatus().equals("ok")) {
                    newsItemArrayList.addAll(response.body().getArticles());
                    Log.d(TAG, "Number of news Items received " + newsItemArrayList.size());
//                recyclerView.setAdapter(new NewsAdapter(newsItemArrayList, getContext()));
                    Log.d(TAG, "Number of items adapter " + newsAdapter.getItemCount());
                    newsAdapter.notifyDataSetChanged();
                }
                else
                {
                    Toast.makeText(getContext(), "Error Occured", Toast.LENGTH_LONG).show();

                }

                swipeRefreshLayout.setRefreshing(false);


            }

            @Override
            public void onFailure(Call<NewsApiResponse> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }

}

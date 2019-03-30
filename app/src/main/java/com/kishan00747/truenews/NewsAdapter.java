package com.kishan00747.truenews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kishan00747.truenews.model.NewsItem;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    private ArrayList<NewsItem> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvDescription, tvSource, tvPublishedAt;
        ImageView imvThumbnail;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            this.tvDescription = (TextView) itemView.findViewById(R.id.tv_description);
            this.tvSource = (TextView) itemView.findViewById(R.id.tv_source);
            this.tvPublishedAt = (TextView) itemView.findViewById(R.id.tv_published_at);

            this.imvThumbnail = (ImageView) itemView.findViewById(R.id.imv_thumbnail);
        }
    }

    public NewsAdapter(ArrayList<NewsItem> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_card, parent, false);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView tvTitle = holder.tvTitle;
        TextView tvDescription = holder.tvDescription;
        TextView tvSource = holder.tvSource;
        TextView tvPublishedAt = holder.tvPublishedAt;
        ImageView imvThumbnail = holder.imvThumbnail;

        tvTitle.setText(dataSet.get(listPosition).getTitle());
        tvDescription.setText(dataSet.get(listPosition).getContent());



    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}

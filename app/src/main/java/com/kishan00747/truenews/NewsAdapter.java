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

        TextView tvHeadline, tvDescription, tvSource, tvTimestamp;
        ImageView imvThumbnail;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.tvHeadline = (TextView) itemView.findViewById(R.id.tv_headline);
            this.tvDescription = (TextView) itemView.findViewById(R.id.tv_description);
            this.tvSource = (TextView) itemView.findViewById(R.id.tv_source);
            this.tvTimestamp = (TextView) itemView.findViewById(R.id.tv_timestamp);

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

        TextView tvHeadline = holder.tvHeadline;
        TextView tvDescription = holder.tvDescription;
        TextView tvSource = holder.tvSource;
        TextView tvTimestamp = holder.tvTimestamp;
        ImageView imvThumbnail = holder.imvThumbnail;

        tvHeadline.setText(dataSet.get(listPosition).getHeadline());
        tvDescription.setText(dataSet.get(listPosition).getContent());

        Glide.with(this).
                load(dataSet.get(listPosition).getUrl()).
                centerCrop().
                placeholder(R.drawable.loading_spinner)
                .into(imvThumbnail);


    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}

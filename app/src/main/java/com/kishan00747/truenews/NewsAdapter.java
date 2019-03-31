package com.kishan00747.truenews;

import android.content.Context;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kishan00747.truenews.model.NewsItem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    private ArrayList<NewsItem> dataSet;
    private Context context;


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvDescription, tvSource, tvPublishedAt;
        ImageView imvThumbnail;
        CardView cardView;


        public MyViewHolder(View itemView) {
            super(itemView);
            this.cardView = (CardView) itemView.findViewById(R.id.cardView);
            this.tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            this.tvDescription = (TextView) itemView.findViewById(R.id.tv_description);
            this.tvSource = (TextView) itemView.findViewById(R.id.tv_source);
            this.tvPublishedAt = (TextView) itemView.findViewById(R.id.tv_published_at);

            this.imvThumbnail = (ImageView) itemView.findViewById(R.id.imv_thumbnail);
        }
    }

    public NewsAdapter(ArrayList<NewsItem> data, Context context) {
        this.context = context;
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

        CardView cardView = holder.cardView;
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, WebActivity.class);
                intent.putExtra("URL", dataSet.get(listPosition).getUrl());
                context.startActivity(intent);
            }
        });
        cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                //Sending Image
                Intent intent;

                    intent = new Intent(Intent.ACTION_SEND);

                    intent.setType("text/*");

                    String message = "Shared By TrueNews App. Your Ultimate News Solution. Link: " + dataSet.get(listPosition).getUrl();

                    intent.putExtra(Intent.EXTRA_TEXT, message);

                    context.startActivity((Intent.createChooser(intent, "Send Article")));
                    return false;



            }
        });

        TextView tvTitle = holder.tvTitle;
        TextView tvDescription = holder.tvDescription;
        TextView tvSource = holder.tvSource;
        TextView tvPublishedAt = holder.tvPublishedAt;
        ImageView imvThumbnail = holder.imvThumbnail;

        tvTitle.setText(dataSet.get(listPosition).getTitle());
        tvDescription.setText(dataSet.get(listPosition).getContent());
        tvSource.setText((dataSet.get(listPosition).getSource().getName()));

        //DateTime

        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = inputFormat.parse(dataSet.get(listPosition).getPublishedAt());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formattedDate = outputFormat.format(date);
        System.out.println(formattedDate);

        tvPublishedAt.setText(DateUtils.getRelativeTimeSpanString(date.getTime()));


        Glide.with(context)
                .asBitmap()
                .placeholder(R.drawable.ic_launcher_foreground)
                .load(dataSet.get(listPosition).getUrlToImage())
                .centerCrop()
                .into(imvThumbnail);

    }

    @Override
    public int getItemCount() {

        return dataSet.size();
    }
}

package com.example.apekshakhandelwal.news;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Apeksha Khandelwal on 25-05-2017.
 */

public class adapt extends RecyclerView.Adapter<adapt.NewsViewHolder>
{
    private List<news> mNewsList;
    private OnItemClickListener mListener;
    private Context mContext;
    public adapt(List<news> newsList, OnItemClickListener listener){
        mNewsList = newsList;
        mListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(news news);
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View newsView = LayoutInflater.from(context).inflate(R.layout.list, parent, false);
        NewsViewHolder newsViewHolder = new NewsViewHolder(newsView);
        return newsViewHolder;
    }

    @Override
    public void onBindViewHolder(adapt.NewsViewHolder holder, int position) {
        news news = mNewsList.get(position);
        holder.mTitle.setText(news.getTitle());
        holder.mType.setText(news.getType());
        holder.mDate.setText(news.getDate());
        holder.mSection.setText(news.getSection());
        holder.bind(mNewsList.get(position), mListener);
    }

    @Override
    public int getItemCount()
    {
        return mNewsList.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.news_title) TextView mTitle;
        @BindView(R.id.news_type) TextView mType;
        @BindView(R.id.news_date) TextView mDate;
        @BindView(R.id.news_section) TextView mSection;

        public NewsViewHolder(View v)
        {
            super(v);
            ButterKnife.bind(this, v);
        }

        public void bind(final news news, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(news);
                }
            });
        }
    }

    public void clear(){
        mNewsList.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<news> newsList){
        mNewsList.addAll(newsList);
        notifyDataSetChanged();
    }
}

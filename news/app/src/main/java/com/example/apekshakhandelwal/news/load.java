package com.example.apekshakhandelwal.news;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by Apeksha Khandelwal on 25-05-2017.
 */

public class load extends AsyncTaskLoader<List<news>>
{
    private String mUrl;
    public load(Context context, String url)
        {
            super(context);
            mUrl=url;
        }

    @Override
    protected void onStartLoading()
    {
        forceLoad();
    }

    @Override
    public List<news> loadInBackground()
    {
         if(mUrl.length()< 1||mUrl==null)
         {
            return null;
         }
         List<news> news=query.fetchNewsData(mUrl);
         return news;
    }
}

package com.example.apekshakhandelwal.special;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by Apeksha Khandelwal on 21-07-2017.
 */

public class ImageAdapter extends BaseAdapter {
    private Context context;
    int imageBackground;

    public ImageAdapter(Context context) {

        this.context = context;
    }

    @Override
    public int getCount() {

        return 6;
    }

    @Override
    public Object getItem(int arg0) {

        return arg0;
    }

    @Override
    public long getItemId(int arg0) {

        return arg0;
    }

    @Override
    public View getView(int arg0, View arg1, ViewGroup arg2) {

        ImageView imageView = new ImageView(context);
//        imageView.setImageResource(images[arg0]);
        return imageView;
    }

}

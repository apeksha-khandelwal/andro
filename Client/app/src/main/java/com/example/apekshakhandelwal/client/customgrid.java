package com.example.apekshakhandelwal.client;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Apeksha Khandelwal on 19-06-2017.
 */

public class customgrid extends BaseAdapter {


    Context context;
    int[] imagesid;
    String[] namesid;

    public customgrid(Context c,String[] names, int[] images) {
        context = c;
        for(int i=0;i<names.length;i++) {
            imagesid[i] = images[i];
            namesid[i] = names[i];
        }
    }

    @Override
    public int getCount() {
        return namesid.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
        {
            grid = new View(context);
            grid = inflater.inflate(R.layout.activity_grid, null);
            TextView textView = (TextView) grid.findViewById(R.id.text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.image);
            textView.setText(namesid[position]);
            imageView.setImageResource(imagesid[position]);
        }

        else
            grid = convertView;

        return grid;
    }

}

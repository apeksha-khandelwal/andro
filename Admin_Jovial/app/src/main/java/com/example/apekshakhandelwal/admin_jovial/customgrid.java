package com.example.apekshakhandelwal.admin_jovial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Apeksha Khandelwal on 19-05-2017.
 */

public class customgrid extends BaseAdapter
{
    private final int[] image;

    private final String[] content;

    Context context;

    public customgrid(Context c,String[] str,int[] img) {
        context = c;
        this.content = str;
        this.image = img;
    }

    @Override
    public int getCount() {
        return content.length;
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
            ImageView imageView = (ImageView)grid.findViewById(R.id.EventView);
            textView.setText(content[position]);
            imageView.setImageResource(image[position]);
        }

        else
            grid = (View) convertView;

        return grid;
    }


}

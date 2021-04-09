package com.example.apekshakhandelwal.e_event;

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
    private Context context;
    private String[] content;
    private int[] image;

    public customgrid(Context c,String[] content,int[] image)
    {
        context=c;
        this.content=content;
        this.image=image;

    }

    @Override
    public int getCount()
    {
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
        View grid;
        LayoutInflater inf=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView==null)
        {
            grid=new View(context);
            grid=inf.inflate(R.layout.grid,null);
            TextView t=(TextView)grid.findViewById(R.id.text);
            ImageView i=(ImageView)grid.findViewById(R.id.image);

            t.setText(content[position]);
            i.setImageResource(image[position]);
        }
        else
            grid=(View)convertView;

        return grid;
    }
}

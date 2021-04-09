package com.example.apekshakhandelwal.admin_jovial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.apekshakhandelwal.admin_jovial.R;

/**
 * Created by Apeksha Khandelwal on 28-09-2017.
 */

public class main_custom extends BaseAdapter{
    private final String[] content;

    Context context;

    public main_custom(Context c, String[] str) {
        context = c;
        this.content = str;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            grid = new View(context);
            grid = inflater.inflate(R.layout.main_grid, null);
            TextView textView = (TextView) grid.findViewById(R.id.text);
            textView.setText(content[position]);
        }
        else
            grid = (View) convertView;

        return grid;
    }
}

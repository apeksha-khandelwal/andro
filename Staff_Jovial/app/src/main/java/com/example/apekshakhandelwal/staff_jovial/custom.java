package com.example.apekshakhandelwal.staff_jovial;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Apeksha Khandelwal on 19-06-2017.
 */

public class custom extends ArrayAdapter<checkbox> {
    private ArrayList<checkbox> toDoList;

    public custom(Context context, int textViewResourceId, ArrayList<checkbox> toDoList)
    {
        super(context, textViewResourceId, toDoList);
        this.toDoList = new ArrayList<checkbox>();
        this.toDoList.addAll(toDoList);
    }

    private class ViewHolder {
        TextView code;
        CheckBox name;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        Log.v("ConvertView", String.valueOf(position));

        if (convertView == null) {

            holder = new ViewHolder();
            holder.code = (TextView) convertView.findViewById(R.id.txt);
            holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
            convertView.setTag(holder);

            holder.name.setOnClickListener( new View.OnClickListener() {
                public void onClick(View v) {
                    CheckBox cb = (CheckBox) v ;
                    checkbox country = (checkbox) cb.getTag();
                    country.setSelected(cb.isChecked());
                }
            });
        }
        else
            holder = (ViewHolder) convertView.getTag();

        checkbox country = toDoList.get(position);
        holder.code.setText(" (" +  country.getCode() + ")");
        holder.name.setText(country.getName());
        holder.name.setChecked(country.isSelected());
        holder.name.setTag(country);

        return convertView;

    }
}
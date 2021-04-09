package com.example.apekshakhandelwal.jovial_admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Apeksha Khandelwal on 19-05-2017.
 */

public class customgrid extends BaseAdapter
{
    private Context context;
    private static LayoutInflater inflater=null;

    // Initializing a new String Array
    int[] image = {
            R.drawable.birthday,
            R.drawable.wedding,
            R.drawable.corporate,
            R.drawable.festivals,
            R.drawable.kitty,
            R.drawable.garden_party,
            R.drawable.graduation,
            R.drawable.gettogether
    };

    final String[] content = {
            "Birthday",
            "Wedding",
            "Corporate",
            "Festivals",
            "Kitty",
            "Homing Pary",
            "Graduation",
            "Get_together"
    };

    public customgrid(Context c)
    {
        inflater = ( LayoutInflater )c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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

    public class Holder
    {
        TextView tv;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.grid, null);
        holder.tv=(TextView) rowView.findViewById(R.id.text);
        holder.img=(ImageView) rowView.findViewById(R.id.image);

        holder.tv.setText(content[position]);
        holder.img.setImageResource(image[position]);

        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked "+content[position], Toast.LENGTH_LONG).show();
            }
        });

        return rowView;
    }
}

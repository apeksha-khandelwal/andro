package com.example.apekshakhandelwal.guidetour;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Apeksha Khandelwal on 27-05-2017.
 */

public class adapter extends ArrayAdapter<Speciality> {

    public adapter(Context context, ArrayList<Speciality> attractions) {
        super(context, 0, attractions);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list, parent, false);
        }

        Speciality currentAttraction = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name);
        nameTextView.setText(currentAttraction.getAttractionName());

        TextView phoneTextView = (TextView) listItemView.findViewById(R.id.phone);
        if("".equals(currentAttraction.getAttractionPhone()))
            phoneTextView.setVisibility(View.GONE);
        else {
            phoneTextView.setVisibility(View.VISIBLE);
            phoneTextView.setText(currentAttraction.getAttractionPhone());
        }

        TextView addressTextView = (TextView) listItemView.findViewById(R.id.address);
        addressTextView.setText(currentAttraction.getAttractionAddress());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);

        Picasso.with(getContext())
                .load(currentAttraction.getImageResourceUrl())
                .resizeDimen(110,110)
                .centerInside()
                .into(imageView);

        return listItemView;
    }
}

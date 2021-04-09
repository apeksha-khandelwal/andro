package com.example.apekshakhandelwal.jovial_admin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by Apeksha Khandelwal on 04-06-2017.
 */

public class Avail_events extends Activity
{

    @Override
protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);

        GridView grid;

        grid = (GridView) findViewById(R.id.grid);
        grid.setAdapter(new customgrid(Avail_events.this));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                intent = new Intent(Avail_events.this, add_event.class);
                startActivity(intent);
            }
        });
    }
    Intent intent;
    public void add_now()
    {
        intent = new Intent(this, add_event.class);
        startActivity(intent);
    }

}

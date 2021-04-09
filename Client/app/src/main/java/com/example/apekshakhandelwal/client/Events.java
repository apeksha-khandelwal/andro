package com.example.apekshakhandelwal.client;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Events extends MainActivity {

    //retrive data from the firebase


    GridView grid;
    customgrid adapter;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        adapter = new customgrid(Events.this,content,image);
        grid = (GridView) findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(Events.this, packages.class);
                String EventName = content[position];
                intent.putExtra("EventName", EventName);
                startActivity(intent);
            }
        });
    }
}
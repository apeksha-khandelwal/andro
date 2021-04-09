package com.example.apekshakhandelwal.e_event;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * Created by Apeksha Khandelwal on 02-06-2017.
 */

public class event extends Activity {

    GridView grid;
    // Initializing a new String Array
    int[] image = {
            R.drawable.birthday,
            R.drawable.wedding,
            R.drawable.corporate,
            R.drawable.festivals,
            R.drawable.kitty,
            R.drawable.gardenparty,
            R.drawable.graduation,
            R.drawable.gettogether
    };

    String[] content = {
            "Birthday",
            "Wedding",
            "Corporate",
            "Festivals",
            "Homing Pary",
            "Kitty",
            "Graduation",
            "Get_together"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customgrid adapter = new customgrid(this, content, image);
        grid=(GridView)findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {

            }
        });

    }
}


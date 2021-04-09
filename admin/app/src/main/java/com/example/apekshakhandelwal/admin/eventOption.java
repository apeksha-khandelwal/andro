package com.example.apekshakhandelwal.admin;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

/**
 * Created by Apeksha Khandelwal on 03-06-2017.
 */

public class eventOption extends Activity {
    GridView grid;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event);

        customgrid adapter = new customgrid( content, image);
      //  grid = (GridView) findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
            }
        });

    }

}
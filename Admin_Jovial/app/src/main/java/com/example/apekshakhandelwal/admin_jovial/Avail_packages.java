package com.example.apekshakhandelwal.admin_jovial;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Apeksha Khandelwal on 05-06-2017.
 */

public class Avail_packages extends FragmentActivity
{

    //retrive data from the firebase


    String[] countries = new String[] {
            "Birthday_Platinum",
            "Veg_Platinum",
            "Veg_Golden",
            "Veg_Silver",
            "Non-Veg_Platinum",
            "Nonveg_Golden",
            "Nonveg_Silver",
            "kitty_package",
            "Kitty_silver"
    };

    // Array of integers points to images stored in /res/drawable-ldpi/
    int[] flags = new int[]{
            R.drawable.birthday_platinum,
            R.drawable.veg_p,
            R.drawable.veg_golden,
            R.drawable.kitty_silver,
            R.drawable.veg_platinum,
            R.drawable.nonveg_golden,
            R.drawable.nonveg_silver,
            R.drawable.kitty_package,
            R.drawable.kitty_silver
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avail_packages);

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 9; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("txt",  countries[i]);
            hm.put("flag", Integer.toString(flags[i]));
            aList.add(hm);
        }

        String[] from = {"flag", "txt"};

        int[] to = {R.id.flag, R.id.txt,};

        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.layout, from, to);

        ListView listView = (ListView) findViewById(R.id.listview);

        listView.setAdapter(adapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View container, int position, long id) {
                String PackageName = countries[position];
                intent = new Intent(Avail_packages.this,Package.class);
                intent.putExtra("PackageName",PackageName);
                startActivity(intent);
            }
        };

        // Setting the item click listener for the listview
        listView.setOnItemClickListener(itemClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
    Intent intent;

    public void add_now(View v)
    {
        intent = new Intent(this, add_package.class);
        startActivity(intent);
    }

    public void info()
    {
        intent = new Intent(this, add_package.class);
        startActivity(intent);
    }
}


package com.example.apekshakhandelwal.staff_jovial;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayListView();
    }

    custom dataAdapter;

    private void displayListView() {

        //Array list of countries
        ArrayList<checkbox> countryList = new ArrayList<checkbox>();
        checkbox Work = new checkbox("D","Decorations",false);
        countryList.add(Work);
        Work = new checkbox("C","Catering",true);
        countryList.add(Work);
        Work = new checkbox("S","Services",false);
        countryList.add(Work);

        dataAdapter = new custom(this, R.layout.activity_service_info, countryList);

        ListView listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(dataAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                intent = new Intent(MainActivity.this,serviceInfo.class);
                startActivity(intent);

            }
        });

    }
//
    Intent intent;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }
}
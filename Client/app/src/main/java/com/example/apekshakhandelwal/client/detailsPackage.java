package com.example.apekshakhandelwal.client;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RelativeLayout;

public class detailsPackage extends AppCompatActivity {

    RelativeLayout Relative;
    int services;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_package);

        //get data from firebase and put in the UI
        // data like services involved ,image, name of the package and total charges!

        //define services with the  number of attributes the package contains

        for(int i=0;i<services;i++);
        {
            CheckBox cb = new CheckBox(getApplicationContext());
            cb.setText("I'm dynamic!");
            Relative.addView(cb);
        }
    }
}

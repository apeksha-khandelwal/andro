package com.example.apekshakhandelwal.admin_jovial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

/**
 * Created by Apeksha Khandelwal on 05-06-2017.
 */

public class Avail_services extends MainActivity
{

    //retrive data from the firebase


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avail_services);
        ListView list;
    }

    Intent intent;

    public void add_now(View v)
    {
        intent = new Intent(this, add_service.class);
        startActivity(intent);
    }
}

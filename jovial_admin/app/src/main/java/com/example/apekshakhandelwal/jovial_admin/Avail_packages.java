package com.example.apekshakhandelwal.jovial_admin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Apeksha Khandelwal on 05-06-2017.
 */

public class Avail_packages extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.packages);
    }

    Intent intent;

    public void add_now()
    {
        intent = new Intent(this, add_packages.class);
        startActivity(intent);
    }

    public void info()
    {
        intent = new Intent(this, add_packages.class);
        startActivity(intent);
    }
}


package com.example.apekshakhandelwal.client;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;

import java.io.File;

public class packages extends AppCompatActivity {

    Intent intent;
    GridView grid;
    customgrid adapter;

    String name,id[]={"golden","silver","platinum"};
    int img[]={R.drawable.admin,R.drawable.birthday,R.drawable.client};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_packages);
        name = getIntent().getStringExtra("EventName");

        // add images and details for package using firebase from the EventName-Avail-Package list

        adapter = new customgrid(packages.this,id,img);
        grid = (GridView) findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(packages.this, detailsPackage.class);
                intent.putExtra("packageName",adapter.namesid[position]);
                startActivity(intent);
            }
        });
    }
    void packagedesign(View v)
    {
        intent = new Intent(this,designPackage.class);
        startActivity(intent);
    }
}

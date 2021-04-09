package com.example.apekshakhandelwal.guidetour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m);

        TextView udr = (TextView) findViewById(R.id.udaipur);
        udr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent taipeiIntent = new Intent(MActivity.this, Udaipur.class);
                startActivity(taipeiIntent);
            }
        });

        TextView jpr = (TextView) findViewById(R.id.jaipur);
        jpr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent taichungIntent = new Intent(MActivity.this, Jaipur.class);
                startActivity(taichungIntent);
            }
        });

        TextView jdhpr = (TextView) findViewById(R.id.jodhpur);
        jdhpr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tainanIntent = new Intent(MActivity.this, Jodhpur.class);
                startActivity(tainanIntent);
            }
        });

        TextView jslmr = (TextView) findViewById(R.id.jaisalmer);
        jslmr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kaohsiungIntent = new Intent(MActivity.this, Jaisalmer.class);
                startActivity(kaohsiungIntent);
            }
        });
    }
}

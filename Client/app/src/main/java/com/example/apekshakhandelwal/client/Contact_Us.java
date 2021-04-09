package com.example.apekshakhandelwal.client;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.Manifest;

public class Contact_Us extends AppCompatActivity implements View.OnClickListener{

//    let this be static in the app
    Button address,phone,mail,link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact__us);

        address=(Button)findViewById(R.id.add);
        mail=(Button)findViewById(R.id.id);
        phone=(Button)findViewById(R.id.phone);
        link=(Button)findViewById(R.id.web);

        address.setOnClickListener(this);
        link.setOnClickListener(this);
        mail.setOnClickListener(this);
        phone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==address)
            address(v);
        else if(v==mail)
            mail(v);
        else if(v==phone)
            phone(v);
        else if(v==link)
            link(v);
    }

    void address(View v)
    {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("google.navigation:q=an+techno india njr+udaipur"));
    }
    void mail(View v)
    {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "apeksha.khandelwal23@gmail.com" });
        intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
        intent.putExtra(Intent.EXTRA_TEXT, "mail body");
        startActivity(Intent.createChooser(intent, ""));
    }
    void phone(View v)
    {
        int checkPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        if (checkPermission != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this,"Permisiion denied!", Toast.LENGTH_SHORT).show();
        }
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:123456789"));
        startActivity(callIntent);
    }
    void link(View v)
    {
        Uri uri = Uri.parse("http://technonjr.org/"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}

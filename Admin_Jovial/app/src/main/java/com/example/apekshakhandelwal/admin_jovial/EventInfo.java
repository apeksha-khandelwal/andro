package com.example.apekshakhandelwal.admin_jovial;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class EventInfo extends AppCompatActivity
{
    //retrive data from the firebase

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_info);

        ImageView image = (ImageView) findViewById(R.id.EventImage);

        Bundle extras = getIntent().getExtras();
        int imageRes = extras.getInt("IMAGE_RES");

        image.setImageResource(imageRes);

        TextView EText=(TextView)findViewById(R.id.EventName);
        EText.setText(getIntent().getExtras().getString("name"));
    }
    void edit(View v)
    {
        EditText edittext=(EditText) findViewById(R.id.editText);
        edittext.setEnabled(true);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(edittext, InputMethodManager.SHOW_IMPLICIT);
        String PackageDetails = edittext.getText().toString();
    }
}

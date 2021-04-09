package com.example.apekshakhandelwal.admin_jovial;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class Package extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package);

        // gets the previously created intent
        Intent myIntent = getIntent();
        // will return "PackageName"

        TextView PText=(TextView)findViewById(R.id.PText);
        String PName = myIntent.getStringExtra("PackageName");
        PText.setText(PName);
    }

    //get data with package name== PackageName

    void edit(View v)
    {
        EditText edittext=(EditText) findViewById(R.id.editText);
        edittext.setEnabled(true);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(edittext, InputMethodManager.SHOW_IMPLICIT);
        String PackageDetails = edittext.getText().toString();
    }
}

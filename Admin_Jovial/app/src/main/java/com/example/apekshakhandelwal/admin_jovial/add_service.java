package com.example.apekshakhandelwal.admin_jovial;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Apeksha Khandelwal on 05-06-2017.
 */

public class add_service extends Activity {
    String service_name,details;
    long charges;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_services);
    }

    public void submit()
    {
        editText = (EditText) findViewById(R.id.s_name);
        service_name=editText.getText().toString();
        editText = (EditText) findViewById(R.id.details);
        details=editText.getText().toString();
        editText = (EditText) findViewById(R.id.s_name);
        charges=Integer.parseInt(editText.getText().toString());

        // table defining to store this info

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue(service_name);
        myRef.setValue(charges);
        myRef.setValue(details);
    }
}

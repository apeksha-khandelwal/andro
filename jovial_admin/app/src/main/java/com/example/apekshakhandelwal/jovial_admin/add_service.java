package com.example.apekshakhandelwal.jovial_admin;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

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
        setContentView(R.layout.adds_form);
    }

    public void submit()
    {
        editText = (EditText) findViewById(R.id.s_name);
        service_name=editText.getText().toString();
        editText = (EditText) findViewById(R.id.details);
        details=editText.getText().toString();
        editText = (EditText) findViewById(R.id.s_name);
        charges=Integer.parseInt(editText.getText().toString());
    }
}

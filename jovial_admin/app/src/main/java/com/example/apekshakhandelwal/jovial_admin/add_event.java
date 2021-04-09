package com.example.apekshakhandelwal.jovial_admin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.InputStream;

/**
 * Created by Apeksha Khandelwal on 04-06-2017.
 */

public class add_event extends Activity {

    private int PICK_IMAGE_REQUEST = 1;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adde_form);
    }

    public void gallery(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select Picture"),PICK_IMAGE_REQUEST);
    }
    EditText editText;
    String event_type,event_name;

    public void submit()
    {
        editText = (EditText) findViewById(R.id.e_name);
        event_name=editText.getText().toString();
        editText = (EditText) findViewById(R.id.e_name);
        event_type=editText.getText().toString();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            if (data == null) {
                //Display an error
                return;
            }
            try {
                InputStream inputStream = context.getContentResolver().openInputStream(data.getData());
                //Now you can do whatever you want with your inpustream, save it as file, upload to a server, decode a bitmap...
            }
            catch(Exception e){}
        }
    }
}

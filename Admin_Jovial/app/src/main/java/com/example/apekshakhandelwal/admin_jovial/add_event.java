package com.example.apekshakhandelwal.admin_jovial;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.InputStream;

/**
 * Created by Apeksha Khandelwal on 04-06-2017.
 */

public class add_event extends Activity implements View.OnClickListener{

    private int PICK_IMAGE_REQUEST = 1;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        picture=(ImageView)findViewById(R.id.EventView);
        picture.setOnClickListener(this);
    }

    public void gallery(View v){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select Picture"),PICK_IMAGE_REQUEST);
    }
    EditText editText;
    String event_type,event_name;
    ImageView picture;
    Intent intent;

    public void submit(View v)
    {
        editText = (EditText) findViewById(R.id.e_name);
        event_name = editText.getText().toString();
        editText = (EditText) findViewById(R.id.e_type);

        event_type = editText.getText().toString();

//        store the Recently added Event
        //define the table to store the values

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue(event_name);
        myRef.setValue(event_type);
//        myRef.setValue(picture);

        Toast.makeText(this, "Saved Successfully!", Toast.LENGTH_LONG).show();
        intent=new Intent(this,Avail_events.class);
        startActivity(intent);
        finish();
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

    @Override
    public void onClick(View v) {
        if(v==picture)
            gallery(v);
    }
}

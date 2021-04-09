package com.example.apekshakhandelwal.admin_jovial;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.ByteArrayOutputStream;

public class Avail_events extends MainActivity
{
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");

    GridView grid;
    customgrid adapter;
    int[] image = {
            R.drawable.birthday,
            R.drawable.wedding,
            R.drawable.corporate,
            R.drawable.festivals,
            R.drawable.kitty,
            R.drawable.garden_party,
            R.drawable.graduation,
            R.drawable.gettogether
    };

    final String[] content = {
            "Birthday",
            "Wedding",
            "Corporate",
            "Festivals",
            "Kitty",
            "Homing Pary",
            "Graduation",
            "Get_together"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avail_events);
//
        adapter = new customgrid(Avail_events.this,content,image);
        grid=(GridView)findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                int imageRes = image[position];

                Intent intent = new Intent(Avail_events.this,EventInfo.class);
                intent.putExtra("IMAGE_RES", imageRes);
                String EventName = content[position];
                intent.putExtra("EventName",EventName);
                startActivity(intent);
            }
        });
        myRef.addValueEventListener(new ValueEventListener() {
            public static final String TAG = "";

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    Intent intent;
    public void add_now(View v)
    {
        intent = new Intent(this, add_event.class);
        startActivity(intent);
    }


}

package com.example.apekshakhandelwal.client;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class reviews extends AppCompatActivity {

    // Write a message to the database
    // retrive data from firebase

    FirebaseDatabase database;
    DatabaseReference myRef;

    String emails[] = {
            "dimpuudr@gmail.com",
            "rohansen138@gmail.com",
            "girishmasen1512@gmail.com",
            "arushikavdia15@gmail.com",
            "aditimaheshwari1996@gmail.com",
            "akshatbordia@yahoo.co.in"
    };
    Intent intent;
    int Dp= R.drawable.admin;
    String date="19 June'17";

    String review="Found it Real Experience to Enjoy\nImpressive Service\nTasty food!!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < 6; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("email", emails[i]);
            hm.put("Dp", Integer.toString(Dp));
            hm.put("date",date);
            hm.put("review",review);
            aList.add(hm);
        }
        String[] from = {"Dp", "email","date","review"};
        int[] to = {R.id.Dp, R.id.emailAdd,R.id.date,R.id.review};

        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.layout, from, to);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View container, int position, long id) {
                String PackageName = emails[position];
                intent = new Intent(reviews.this,Package.class);
                intent.putExtra("PackageName",PackageName);
                startActivity(intent);
            }
        };
        // Setting the item click listener for the listview
        listView.setOnItemClickListener(itemClickListener);
    }
}

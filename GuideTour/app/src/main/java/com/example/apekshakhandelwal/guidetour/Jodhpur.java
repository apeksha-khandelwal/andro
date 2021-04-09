package com.example.apekshakhandelwal.guidetour;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Apeksha Khandelwal on 27-05-2017.
 */

public class Jodhpur extends AppCompatActivity {
    private ArrayList<Speciality> attractions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attraction);

        // Create a list of attractions
        attractions = new ArrayList<Speciality>();
        Location LakePichola = new Location(getResources().getString(R.string.jdr_place1));
        LakePichola.setLatitude(25.0262737);
        LakePichola.setLongitude(121.5694812);
        attractions.add(new Speciality(getResources().getString(R.string.jdr_place1), getResources().getString(R.string.jdr_phone1), getResources().getString(R.string.jdr_add1), getResources().getString(R.string.image19), LakePichola));

        Location fateh = new Location(getResources().getString(R.string.jdr_place2));
        fateh.setLatitude(25.03699);
        fateh.setLongitude(121.49993);
        attractions.add(new Speciality(getResources().getString(R.string.jdr_place2), getResources().getString(R.string.jdr_phone2), getResources().getString(R.string.jdr_add2), getResources().getString(R.string.image20), fateh));

        Location Saheliyon = new Location(getResources().getString(R.string.jdr_place3));
        Saheliyon.setLatitude(25.03699);
        Saheliyon.setLongitude(121.49993);
        attractions.add(new Speciality(getResources().getString(R.string.jdr_place3), getResources().getString(R.string.jdr_phone3), getResources().getString(R.string.jdr_add3), getResources().getString(R.string.image21), Saheliyon));

        Location jagmandir = new Location(getResources().getString(R.string.jdr_place4));
        jagmandir.setLatitude(25.03699);
        jagmandir.setLongitude(121.49993);
        attractions.add(new Speciality(getResources().getString(R.string.jdr_place4), getResources().getString(R.string.jdr_phone4), getResources().getString(R.string.jdr_add4), getResources().getString(R.string.image22), jagmandir));

        Location citypalace = new Location(getResources().getString(R.string.jdr_place5));
        citypalace.setLatitude(25.03699);
        citypalace.setLongitude(121.49993);
        attractions.add(new Speciality(getResources().getString(R.string.jdr_place5), getResources().getString(R.string.jdr_phone5), getResources().getString(R.string.jdr_add5), getResources().getString(R.string.image23), citypalace));

        Location shilpgram = new Location(getResources().getString(R.string.jdr_place6));
        shilpgram.setLatitude(25.03699);
        shilpgram.setLongitude(121.49993);
        attractions.add(new Speciality(getResources().getString(R.string.jdr_place6), getResources().getString(R.string.jdr_phone6), getResources().getString(R.string.jdr_add6), getResources().getString(R.string.image24), shilpgram));

        adapter adap = new adapter(this, attractions);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adap);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                double lat = attractions.get(position).getLocation().getLatitude();
                double lon = attractions.get(position).getLocation().getLongitude();
                String keyword = attractions.get(position).getAttractionName();
                Uri uri = Uri.parse("geo:" + lat + "," + lon + "?q=" + Uri.encode(keyword));

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
    }
}

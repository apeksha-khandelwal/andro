package com.example.apekshakhandelwal.guidetour;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Apeksha Khandelwal on 27-05-2017.
 */

public class Jaisalmer extends AppCompatActivity {
    private ArrayList<Speciality> attractions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attraction);

        // Create a list of attractions
        attractions = new ArrayList<Speciality>();
        Location fort = new Location(getResources().getString(R.string.jslm_place1));
        fort.setLatitude(25.0262737);
        fort.setLongitude(121.5694812);
        attractions.add(new Speciality(getResources().getString(R.string.jslm_place1), getResources().getString(R.string.jslm_abt1), getResources().getString(R.string.jslm_add1), getResources().getString(R.string.image7), fort));

        Location folklore = new Location(getResources().getString(R.string.jslm_place2));
        folklore.setLatitude(25.03699);
        folklore.setLongitude(121.49993);
        attractions.add(new Speciality(getResources().getString(R.string.jslm_place2), getResources().getString(R.string.jslm_abt2), getResources().getString(R.string.jslm_add2), getResources().getString(R.string.image8), folklore));

        Location desert = new Location(getResources().getString(R.string.jslm_place3));
        desert.setLatitude(25.03699);
        desert.setLongitude(121.49993);
        attractions.add(new Speciality(getResources().getString(R.string.jslm_place3), getResources().getString(R.string.jslm_abt3), getResources().getString(R.string.jslm_add3), getResources().getString(R.string.image9), desert));

        Location patwon = new Location(getResources().getString(R.string.jslm_place4));
        patwon.setLatitude(25.03699);
        patwon.setLongitude(121.49993);
        attractions.add(new Speciality(getResources().getString(R.string.jslm_place4), getResources().getString(R.string.jslm_phone4), getResources().getString(R.string.jslm_add4), getResources().getString(R.string.image10), patwon));

        Location mandir = new Location(getResources().getString(R.string.jslm_place5));
        mandir.setLatitude(25.03699);
        mandir.setLongitude(121.49993);
        attractions.add(new Speciality(getResources().getString(R.string.jslm_place5), getResources().getString(R.string.jslm_phone5), getResources().getString(R.string.jslm_add5), getResources().getString(R.string.image11), mandir));

        Location ssdds = new Location(getResources().getString(R.string.jslm_place6));
        ssdds.setLatitude(25.03699);
        ssdds.setLongitude(121.49993);
        attractions.add(new Speciality(getResources().getString(R.string.jslm_place6), getResources().getString(R.string.jslm_phone6), getResources().getString(R.string.jslm_add6), getResources().getString(R.string.image12), ssdds));

        adapter adap = new adapter(this, attractions);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adap);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                double lat = attractions.get(position).getLocation().getLatitude();
                Log.d("lat", ""+lat);
                double lon = attractions.get(position).getLocation().getLongitude();
                Log.d("lon", ""+lon);
                String keyword = attractions.get(position).getAttractionName();
                Uri uri = Uri.parse("geo:" + lat + "," + lon + "?q=" + Uri.encode(keyword));

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
    }
}

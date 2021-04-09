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

public class Jaipur extends AppCompatActivity {
    private ArrayList<Speciality> attractions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attraction);

        attractions = new ArrayList<Speciality>();
        Location jalmahal = new Location(getResources().getString(R.string.jpr_place1));
        jalmahal.setLatitude(25.0262737);
        jalmahal.setLongitude(121.5694812);
        attractions.add(new Speciality(getResources().getString(R.string.jpr_place1), getResources().getString(R.string.jpr_phone1), getResources().getString(R.string.jpr_add1), getResources().getString(R.string.image13), jalmahal));

        Location birla = new Location(getResources().getString(R.string.jpr_place2));
        birla.setLatitude(25.03699);
        birla.setLongitude(121.49993);
        attractions.add(new Speciality(getResources().getString(R.string.jpr_place2), getResources().getString(R.string.jpr_phone2), getResources().getString(R.string.jpr_add2), getResources().getString(R.string.image14), birla));

        Location amerfort = new Location(getResources().getString(R.string.jpr_place3));
        amerfort.setLatitude(25.03699);
        amerfort.setLongitude(121.49993);
        attractions.add(new Speciality(getResources().getString(R.string.jpr_place3), getResources().getString(R.string.jpr_phone3), getResources().getString(R.string.jpr_add3), getResources().getString(R.string.image15), amerfort));

        Location hawamahal = new Location(getResources().getString(R.string.jpr_place4));
        hawamahal.setLatitude(25.03699);
        hawamahal.setLongitude(121.49993);
        attractions.add(new Speciality(getResources().getString(R.string.jpr_place4), getResources().getString(R.string.jpr_phone4), getResources().getString(R.string.jpr_add4), getResources().getString(R.string.image16), hawamahal));

        Location jantar = new Location(getResources().getString(R.string.jpr_place5));
        jantar.setLatitude(25.03699);
        jantar.setLongitude(121.49993);
        attractions.add(new Speciality(getResources().getString(R.string.jpr_place5), getResources().getString(R.string.jpr_phone5), getResources().getString(R.string.jpr_add5), getResources().getString(R.string.image17), jantar));

        Location nahargarh = new Location(getResources().getString(R.string.udr_place6));
        nahargarh.setLatitude(25.03699);
        nahargarh.setLongitude(121.49993);
        attractions.add(new Speciality(getResources().getString(R.string.jpr_place6), getResources().getString(R.string.jpr_phone6), getResources().getString(R.string.jpr_add6), getResources().getString(R.string.image18), nahargarh));

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

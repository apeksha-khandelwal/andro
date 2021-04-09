package com.example.apekshakhandelwal.music;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Apeksha Khandelwal on 25-05-2017.
 */

public class Viewer extends AppCompatActivity {
    ArrayAdapter<String> mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewer);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        TextView textView = (TextView) findViewById(R.id.textview_viewer);
        String fragment = getIntent().getStringExtra("fragment");

        if(fragment.equals("Playlist")) {
            String playlist = getIntent().getStringExtra("playlist");
            getSupportActionBar().setTitle(playlist);
            final String [] songNames = getIntent().getStringArrayExtra("songs");
            ListView listView = (ListView) findViewById(R.id.listView);
            mAdapter = new ArrayAdapter<String>(Viewer.this, android.R.layout.simple_list_item_1, songNames);
            listView.setAdapter(mAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                @Override
                                                public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                                                    Intent intent = new Intent(Viewer.this, nowPlaying.class);
                                                    intent.putExtra("song", songNames[position]);
                                                    startActivity(intent);
                  }
                                            }
            );
        }

        if(fragment.equals("Album")) {
            String album = getIntent().getStringExtra("album");
            getSupportActionBar().setTitle(album);
            final String [] songNames = getIntent().getStringArrayExtra("songs");
            ListView listView = (ListView) findViewById(R.id.listView);
            mAdapter = new ArrayAdapter<String>(Viewer.this, android.R.layout.simple_list_item_1, songNames);
            listView.setAdapter(mAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                @Override
                                                public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                                                    Intent intent = new Intent(Viewer.this, nowPlaying.class);
                                                    intent.putExtra("song", songNames[position]);
                                                    startActivity(intent);
                                                }
                                            }
            );
        }

        if(fragment.equals("Artist")) {
            String artist = getIntent().getStringExtra("artist");
            getSupportActionBar().setTitle(artist);
            final String [] albumNames = getIntent().getStringArrayExtra("albums");
            final String [] songNames = getIntent().getStringArrayExtra("songs");
            ListView listView = (ListView) findViewById(R.id.listView);
            mAdapter = new ArrayAdapter<String>(Viewer.this, android.R.layout.simple_list_item_1, albumNames);
            listView.setAdapter(mAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                @Override
                                                public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                                                    Intent intent = new Intent(Viewer.this, albums.class);
                                                    intent.putExtra("album", albumNames[position]);
                                                    startActivity(intent);
                                                }
                                            }
            );
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}


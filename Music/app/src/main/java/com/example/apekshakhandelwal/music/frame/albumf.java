package com.example.apekshakhandelwal.music.frame;

/**
 * Created by Apeksha Khandelwal on 25-05-2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.apekshakhandelwal.music.R;
import com.example.apekshakhandelwal.music.Viewer;
import com.example.apekshakhandelwal.music.util.Album;
import com.example.apekshakhandelwal.music.util.Song;

import java.util.ArrayList;

public class albumf extends Fragment {
    ArrayAdapter<Album> mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View album = inflater.inflate(R.layout.f_album, container, false);

        final ArrayList<Album> items = new ArrayList<Album>();
        Song song1 = new Song(getString(R.string.song_1), getString(R.string.artist_1), getString(R.string.album_1));
        Song song2 = new Song(getString(R.string.song_2), getString(R.string.artist_2), getString(R.string.album_2));
        Song song3 = new Song(getString(R.string.song_3), getString(R.string.artist_1), getString(R.string.album_1));
        Song song4 = new Song(getString(R.string.song_4), getString(R.string.artist_2), getString(R.string.album_2));
        Album album1 = new Album(getString(R.string.album_1), new Song[]{song1, song3});
        Album album2 = new Album(getString(R.string.album_2), new Song[]{song2, song4});
        items.add(album1);
        items.add(album2);

        ListView listView = (ListView) album.findViewById(R.id.listView);

        mAdapter = new ArrayAdapter<Album>(getActivity(),R.layout.f_album, items);
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                                                Intent intent = new Intent(getActivity(), Viewer.class);
                                                intent.putExtra("album", items.get(position).getAlbumName());
                                                intent.putExtra("songs", items.get(position).getSongNames());
                                                intent.putExtra("fragment", "Album");
                                                startActivity(intent);
                                            }
                                        }
        );
        return album;
    }
}



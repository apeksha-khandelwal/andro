package com.example.apekshakhandelwal.music.frame;



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
import com.example.apekshakhandelwal.music.util.Artist;
import com.example.apekshakhandelwal.music.util.Song;

import java.util.ArrayList;


/**
 * Created by Apeksha Khandelwal on 25-05-2017.
 */

public class artist extends Fragment
{
    ArrayAdapter<Artist> mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View artist = inflater.inflate(R.layout.f_artist, container, false);

        final ArrayList<Artist> items = new ArrayList<Artist>();
        Song song1 = new Song(getString(R.string.song_1), getString(R.string.artist_1), getString(R.string.album_1));
        Song song2 = new Song(getString(R.string.song_2), getString(R.string.artist_2), getString(R.string.album_2));
        Song song3 = new Song(getString(R.string.song_3), getString(R.string.artist_1), getString(R.string.album_1));
        Song song4 = new Song(getString(R.string.song_4), getString(R.string.artist_2), getString(R.string.album_2));
        Album album1 = new Album(getString(R.string.album_1), new Song[]{song1, song3});
        Album album2 = new Album(getString(R.string.album_2), new Song[]{song2, song4});
        Artist artist1 = new Artist(getString(R.string.artist_1), new Song[]{song1, song3}, new Album[]{album1});
        Artist artist2 = new Artist(getString(R.string.artist_2), new Song[]{song2, song4}, new Album[]{album2});
        items.add(artist1);
        items.add(artist2);


        ListView listView = (ListView) artist.findViewById(R.id.listView);

        mAdapter = new ArrayAdapter<Artist>(getActivity(), R.layout.f_artist, items);
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                                                Intent intent = new Intent(getActivity(), Viewer.class);
                                                intent.putExtra("artist", items.get(position).getArtistName());
                                                intent.putExtra("albums", items.get(position).getAlbumNames());
                                                intent.putExtra("songs", items.get(position).getSongNames());
                                                intent.putExtra("fragment", "Artist");
                                                startActivity(intent);
                                            }
                                        }
        );
        return artist;
    }
}
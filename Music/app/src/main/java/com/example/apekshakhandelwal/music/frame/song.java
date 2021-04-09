package com.example.apekshakhandelwal.music.frame;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.apekshakhandelwal.music.R;
import com.example.apekshakhandelwal.music.nowPlaying;
import com.example.apekshakhandelwal.music.util.Album;
import com.example.apekshakhandelwal.music.util.Playlist;
import com.example.apekshakhandelwal.music.util.Song;

import java.util.ArrayList;

/**
 * Created by Apeksha Khandelwal on 25-05-2017.
 */

public class song extends Fragment
        {
                ArrayAdapter<Song> mAdapter;

                @Override
                public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                         Bundle savedInstanceState)
                {
                View song = inflater.inflate(R.layout.f_song, container, false);

                final ArrayList<Song> items = new ArrayList<Song>();
                Song song1 = new Song(getString(R.string.song_1), getString(R.string.artist_1), getString(R.string.album_1));
                        Song song2 = new Song(getString(R.string.song_2), getString(R.string.artist_2), getString(R.string.album_2));
                        Song song3 = new Song(getString(R.string.song_3), getString(R.string.artist_1), getString(R.string.album_1));
                        Song song4 = new Song(getString(R.string.song_4), getString(R.string.artist_2), getString(R.string.album_2));
                Album album1 = new Album(getString(R.string.album_1), new Song[]{song1, song3});
                Album album2 = new Album(getString(R.string.album_2), new Song[]{song2, song4});
                Playlist p1 = new Playlist(getString(R.string.playlist_1), new Song[]{song3, song4});
                Playlist p2 = new Playlist(getString(R.string.playlist_2), new Song[]{song2, song4});
                song2.setPlaylist(new Playlist[]{p2});
                song3.setPlaylist(new Playlist[]{p1});
                song4.setPlaylist(new Playlist[]{p1, p2});
                items.add(song1);
                items.add(song2);
                items.add(song3);
                items.add(song4);

                ListView listView = (ListView) song.findViewById(R.id.listView);

                mAdapter = new ArrayAdapter<Song>(getActivity(), R.layout.f_song, items);
                listView.setAdapter(mAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
                                                {
                        @Override
                        public void onItemClick(AdapterView<?> adapter, View view, int position, long arg)
                        {
                                Intent intent = new Intent(getActivity(), nowPlaying.class);
                                intent.putExtra("song", items.get(position).getName());
                                startActivity(intent);
                        }
                });
                return song;
                }


        }
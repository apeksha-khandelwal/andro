package com.example.apekshakhandelwal.special;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Home extends Rohan {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    void gallery(View v)
    {
        intent=new Intent(this,gallery.class);
        startActivity(intent);
    }
    void video(View v)
    {
        intent=new Intent(this,video.class);
        startActivity(intent);
    }
    void word(View v)
    {
        intent=new Intent(this,word.class);
        startActivity(intent);
    }
    void audio(View v)
    {
        intent=new Intent(this,video.class);
        startActivity(intent);
    }
}

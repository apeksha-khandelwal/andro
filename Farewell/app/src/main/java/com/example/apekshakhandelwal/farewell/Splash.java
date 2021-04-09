package com.example.apekshakhandelwal.farewell;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Splash extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//        Animation animFadeIn,animZoomIn;
//        txt1=(TextView)findViewById(R.id.textView1);
//        animZoomIn = AnimationUtils.loadAnimation(getApplicationContext(),
//                R.anim.zoom_in);
//        txt1.setVisibility(View.VISIBLE);
//        txt1.startAnimation(animZoomIn);

        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(Splash.this, AmeyScreen.class));
                finish();
            }
        }, secondsDelayed * 1000);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void remove(View v)
    {
        intent = new Intent(this,AmeyScreen.class);
        startActivity(intent);
    }
}

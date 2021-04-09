package com.example.apekshakhandelwal.special;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    Intent intent;
    Animation animFadeIn,animZoomIn;
    TextView txt1,txt2,txt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        txt1=(TextView)findViewById(R.id.textView1);
        txt2=(TextView)findViewById(R.id.textView2);
        txt3=(TextView)findViewById(R.id.textView3);

        animZoomIn = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.zoom_in);

        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(Splash.this, Rohan.class));
                finish();
            }
        }, secondsDelayed * 1000);

        txt1.setVisibility(View.VISIBLE);
        txt1.startAnimation(animZoomIn);

        txt2.setVisibility(View.VISIBLE);
        txt2.startAnimation(animZoomIn);

        txt3.setVisibility(View.VISIBLE);
        txt3.startAnimation(animZoomIn);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    void onclick(View v)
    {
        intent = new Intent(this,Rohan.class);
        startActivity(intent);
    }
}

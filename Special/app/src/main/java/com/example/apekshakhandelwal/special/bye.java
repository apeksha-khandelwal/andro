package com.example.apekshakhandelwal.special;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class bye extends AppCompatActivity {

    Intent intent;
    TextView txt;
    Animation animMove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bye);
        animMove = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.zoom_in);
        txt=(TextView)findViewById(R.id.tata);

        getActionBar().hide();

        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(bye.this, Rohan.class));
                finish();
            }
        }, secondsDelayed * 500);

        txt.setVisibility(View.VISIBLE);
        txt.startAnimation(animMove);
    }

    @Override
    public void onBackPressed() {
    }

    void onclick(View v)
    {
        intent = new Intent(this,Rohan.class);
        startActivity(intent);
    }
}

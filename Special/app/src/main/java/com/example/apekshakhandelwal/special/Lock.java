package com.example.apekshakhandelwal.special;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import static java.security.AccessController.getContext;

public class Lock extends AppCompatActivity implements View.OnClickListener {

    String password="0";
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock);
        show=(TextView)findViewById(R.id.editText);

        ImageButton one = (ImageButton) findViewById(R.id.floatingActionButton1);
        one.setOnClickListener(this);
        ImageButton two = (ImageButton) findViewById(R.id.floatingActionButton2);
        two.setOnClickListener(this);
        ImageButton three = (ImageButton) findViewById(R.id.floatingActionButton3);
        three.setOnClickListener(this);
        ImageButton four = (ImageButton) findViewById(R.id.floatingActionButton4);
        four.setOnClickListener(this);
        ImageButton five = (ImageButton) findViewById(R.id.floatingActionButton5);
        five.setOnClickListener(this);
        ImageButton six = (ImageButton) findViewById(R.id.floatingActionButton6);
        six.setOnClickListener(this);
        ImageButton seven = (ImageButton) findViewById(R.id.floatingActionButton7);
        seven.setOnClickListener(this);
        ImageButton eight = (ImageButton) findViewById(R.id.floatingActionButton8);
        eight.setOnClickListener(this);
        ImageButton nine = (ImageButton) findViewById(R.id.floatingActionButton9);
        nine.setOnClickListener(this);
        ImageButton zero = (ImageButton) findViewById(R.id.floatingActionButton0);
        zero.setOnClickListener(this);

    }

    String pass="0240796";
    public void unlock(View v)
    {
        if(password.equals(pass)) {
            intent = new Intent(Lock.this, Home.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(Lock.this, "Love Comes From Uh HON!", Toast.LENGTH_SHORT).show();
            password="0";
        }
    }

    void delete(View v)
    {
        if (password != null && password.length() > 0 && password.charAt(password.length() - 1) == 'x') {
            password = password.substring(0, password.length() - 1);
        }
    }

    TextView show;
    void display()
    {
        show.setText(password);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.floatingActionButton0:
                password+="0";
                display();
                break;

            case R.id.floatingActionButton1:
                password+="1";
                break;

            case R.id.floatingActionButton2:
                password+="2";
                break;
            case R.id.floatingActionButton3:
                password+="3";
                break;

            case R.id.floatingActionButton4:
                password+="4";
                break;

            case R.id.floatingActionButton5:
                password+="5";
                break;
            case R.id.floatingActionButton6:
                password+="6";
                break;

            case R.id.floatingActionButton7:
                password+="7";
                break;

            case R.id.floatingActionButton8:
                password+="8";
                break;

            case R.id.floatingActionButton9:
                password+="9";
                break;
            default:
                break;
        }

    }
}

package com.example.apekshakhandelwal.farewell;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String password="0";
    Intent intent;
    EditText show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         show = (EditText) findViewById(R.id.textArea);

        Button one = (Button) findViewById(R.id.floatingActionButton1);
        one.setOnClickListener(this);
        Button two = (Button) findViewById(R.id.floatingActionButton2);
        two.setOnClickListener(this);
        Button three = (Button) findViewById(R.id.floatingActionButton3);
        three.setOnClickListener(this);
        Button four = (Button) findViewById(R.id.floatingActionButton4);
        four.setOnClickListener(this);
        Button five = (Button) findViewById(R.id.floatingActionButton5);
        five.setOnClickListener(this);
        Button six = (Button) findViewById(R.id.floatingActionButton6);
        six.setOnClickListener(this);
        Button seven = (Button) findViewById(R.id.floatingActionButton7);
        seven.setOnClickListener(this);
        Button eight = (Button) findViewById(R.id.floatingActionButton8);
        eight.setOnClickListener(this);
        Button nine = (Button) findViewById(R.id.floatingActionButton9);
        nine.setOnClickListener(this);
        Button zero = (Button) findViewById(R.id.floatingActionButton0);
        zero.setOnClickListener(this);
        Button less = (Button) findViewById(R.id.floatingActionButtonLess);
        less.setOnClickListener(this);
        Button more = (Button) findViewById(R.id.floatingActionButtonMore);
        more.setOnClickListener(this);
        Button not = (Button) findViewById(R.id.floatingActionButtonNot);
        not.setOnClickListener(this);
        Button i = (Button) findViewById(R.id.floatingActionButtonI);
        i.setOnClickListener(this);
        Button you = (Button) findViewById(R.id.floatingActionButtonU);
        you.setOnClickListener(this);

    }

    String pass="i<3u3000";
    public void unlock(View v)
    {
        if(password.equals(pass)) {
            intent = new Intent(MainActivity.this, Splash.class);
            startActivity(intent);
        }
        else {
            throw new RuntimeException("Love Comes From You HON!");
        }
    }

    public void delete(View v)
    {
        if (password != null && password.length() > 0 && password.charAt(password.length() - 1) == 'x') {
            password = password.substring(0, password.length() - 1);
        }
    }

    void display()
    {
        show.setText(password);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.floatingActionButton0:
                password+="0";
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

            case R.id.floatingActionButtonU:
                password+="u";
                break;

            case R.id.floatingActionButtonI:
                password+="i";
                break;

            case R.id.floatingActionButtonMore:
                password+=">";
                break;

            case R.id.floatingActionButtonLess:
                password+="<";
                break;

            case R.id.floatingActionButtonNot:
                password+="!";
        }
        display();
    }
}

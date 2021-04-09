package com.example.apekshakhandelwal.e_event;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import static com.example.apekshakhandelwal.e_event.R.layout.admin;

/**
 * Created by Apeksha Khandelwal on 19-05-2017.
 */

public class login extends AppCompatActivity
{
    private EditText editText;
    private Intent intent;
    String user,pass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        editText = (EditText)findViewById(R.id.username);
        user=editText.getText().toString();
        pass=editText.getText().toString();
    }

    public void select_user(View v)
    {
        select_user(user,pass);
    }
    public void select_user(String str,String str1)
    {
        if(str=="Rahul" && str1=="database") {
            intent = new Intent(this, staff.class);
            startActivity(intent);
        }
        else if(str=="Apeksha" && str1=="developer") {
            Toast.makeText(this, "You are in admin!", Toast.LENGTH_SHORT).show();
        }
        else if(str=="Girishma" && str1=="designer") {
            intent = new Intent(this, client.class);
            startActivity(intent);
        }
        else
            Toast.makeText(this, "Incorrect entry!", Toast.LENGTH_SHORT).show();
    }

}

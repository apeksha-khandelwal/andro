package com.example.apekshakhandelwal.admin;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by Apeksha Khandelwal on 03-06-2017.
 */

public class currentEvent extends Activity
{
    ArrayList<String> listItems=new ArrayList<String>();

    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW

    ArrayAdapter<String> adapter;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
      //  setListAdapter(adapter);
    }
}

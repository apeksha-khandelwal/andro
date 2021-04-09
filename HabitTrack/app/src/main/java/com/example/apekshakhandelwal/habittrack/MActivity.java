package com.example.apekshakhandelwal.habittrack;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MActivity extends AppCompatActivity
{
    private HabitDB mdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MActivity.this,activity.class);
                startActivity(intent);
            }
        });

        mdb = new HabitDB(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        displayDatabase();
    }

    private Cursor read() {
        SQLiteDatabase db = mdb.getReadableDatabase();

        String[] projection = {
                HabitDB.HabitEntry.ID,
                HabitDB.HabitEntry.C_NAME,
                HabitDB.HabitEntry.START_DATE,
                HabitDB.HabitEntry.NUMBER_OF_TIMES
        };

        Cursor cursor = db.query(HabitDB.HabitEntry.TABLE_NAME, projection, null, null, null, null, null);
        return cursor;
    }

    private void displayDatabase() {
        Cursor cursor = read();

        TextView displayView = (TextView) findViewById(R.id.text_view_habit);

        try {
            displayView.setText("The habit table contains " + cursor.getCount() + " pets.\n\n");
            displayView.append(HabitDB.HabitEntry._ID + " - " +
                    HabitDB.HabitEntry.C_NAME + " - " +
                    HabitDB.HabitEntry.START_DATE + " - " +
                    HabitDB.HabitEntry.NUMBER_OF_TIMES + " - " + "\n");

            int idColumnIndex = cursor.getColumnIndex(HabitDB.HabitEntry._ID);
            int nameColumnIndex = cursor.getColumnIndex(HabitDB.HabitEntry.C_NAME);
            int dateColumnIndex = cursor.getColumnIndex(HabitDB.HabitEntry.START_DATE);
            int numberOfTimesColumnIndex = cursor.getColumnIndex(HabitDB.HabitEntry.NUMBER_OF_TIMES);

            while (cursor.moveToNext()) {
                int currentID = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(nameColumnIndex);
                String currentDate = cursor.getString(dateColumnIndex);
                int currentNumberOfTimes = cursor.getInt(numberOfTimesColumnIndex);

                displayView.append(("\n" + currentID + " - " +
                        currentName + " - " +
                        currentDate + " - " +
                        currentNumberOfTimes));
            }
        } finally {
            cursor.close();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    private void insert() {
        SQLiteDatabase db = mdb.getWritableDatabase();
        ContentValues values1 = new ContentValues();
        ContentValues values2 = new ContentValues();
        values1.put(HabitDB.HabitEntry.C_NAME, "Drink water");
        values1.put(HabitDB.HabitEntry.NUMBER_OF_TIMES, 2);
        values2.put(HabitDB.HabitEntry.C_NAME, "Walk my dog");
        values2.put(HabitDB.HabitEntry.NUMBER_OF_TIMES, 1);
        db.insert(HabitDB.HabitEntry.TABLE_NAME, null, values1);
        db.insert(HabitDB.HabitEntry.TABLE_NAME, null, values2);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_insert_dummy_data:
                insert();
                displayDatabase();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

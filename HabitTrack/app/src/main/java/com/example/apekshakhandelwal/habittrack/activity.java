package com.example.apekshakhandelwal.habittrack;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.icu.util.Calendar.getInstance;

/**
 * Created by Apeksha Khandelwal on 24-05-2017.
 */

public class activity extends AppCompatActivity
{

    @BindView(R.id.edit_text_name)
    EditText mNameEditText;
    @BindView(R.id.edit_text_number_of_times)
    EditText mNumberOfTimesEditText;
    @BindView(R.id.text_view_date)
    TextView mDateTextView;
    private String mCurrentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        ButterKnife.bind(this);

        Calendar c = getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat();
        mCurrentDate =  sdf.format(c.getTime());
        Log.d("Edit", mCurrentDate);
        mDateTextView.setText(mCurrentDate);
    }

    private void insertHabit(){

        String nameString = mNameEditText.getText().toString().trim();
        String numberOfTimesString = mNumberOfTimesEditText.getText().toString().trim();
        int numberOfTimes = 0;
        if(!"".equals(numberOfTimesString))
            numberOfTimes = Integer.parseInt(numberOfTimesString);

        HabitDB mdb = new HabitDB(this);

        SQLiteDatabase db = mdb.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(HabitDB.HabitEntry.C_NAME, nameString);
        values.put(HabitDB.HabitEntry.START_DATE, mCurrentDate);
        values.put(HabitDB.HabitEntry.NUMBER_OF_TIMES, numberOfTimes);

        long newRowId = db.insert(HabitDB.HabitEntry.TABLE_NAME, null, values);

        if (newRowId == -1) {
            // If the row ID is -1, then there was an error with insertion.
            Toast.makeText(this, "Error with saving habit", Toast.LENGTH_SHORT).show();
        } else {
            // Otherwise, the insertion was successful and we can display a toast with the row ID.
            Toast.makeText(this, "Habit saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
        }
    }

    public void onSave(View view) {
        if("".equals(mNameEditText.getText().toString())) {
            Toast.makeText(this, "Habit Name must be not empty", Toast.LENGTH_SHORT).show();
            return;
        }
        insertHabit();
        finish();
    }

    public void onCancel(View view) {
        finish();
    }
}


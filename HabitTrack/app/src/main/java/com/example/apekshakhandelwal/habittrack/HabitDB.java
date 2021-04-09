package com.example.apekshakhandelwal.habittrack;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Apeksha Khandelwal on 25-05-2017.
 */

public class HabitDB extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "habittracker.db";
    private static final int DATABASE_VERSION = 1;

    public HabitDB(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_HABITS_TABLE =  "CREATE TABLE " + HabitEntry.TABLE_NAME + " ("
                + HabitEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitEntry.C_NAME + " TEXT NOT NULL, "
                + HabitEntry.START_DATE + " DATETIME NOT NULL DEFAULT CURRENT_DATE, "
                + HabitEntry.NUMBER_OF_TIMES + " INTEGER NOT NULL DEFAULT 0);";

        db.execSQL(SQL_CREATE_HABITS_TABLE);
    }


    public static final class HabitEntry implements BaseColumns
    {
        public final static String TABLE_NAME = "habits";
        public final static String ID = BaseColumns._ID;
        public final static String C_NAME ="name";
        public final static String START_DATE = "start_date";
        public final static String NUMBER_OF_TIMES = "number_of_times";
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}


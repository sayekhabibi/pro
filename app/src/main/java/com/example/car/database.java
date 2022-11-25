package com.example.car;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class database extends SQLiteOpenHelper {
    private static final String dbname="car.db";
    public database(@Nullable Context context )  {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String q= "Create table users (_id integer primary key autoincrement , name text, car_model text, date text, number text)";
        sqLiteDatabase.execSQL(q);

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
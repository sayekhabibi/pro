package com.example.car;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

   sqLiteDatabase.execSQL("drop table if exists user");
        onCreate(sqLiteDatabase);
    }

    public boolean insert_data(String name, String car_model, String date, String number) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues c = new ContentValues();
        c.put("name", name);
        c.put("car_model", car_model);
        c.put("date", date);
        c.put("number", number);

        long r = db.insert("users", null, c);
        if (r == -1) return false;
        else
            return true;

    }

    public Cursor getinfo() {

    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.rawQuery("select * from users", null);
       return cursor;

}
    public boolean delete_data(String number) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where number=?", new String[]{number});
        if (cursor.getCount() > 0) {
            long r = db.delete("users", "number=?", new String[]{number});
            if (r == -1) return
                    false;
            else
                return true;
        } else
            return false;
    }
}

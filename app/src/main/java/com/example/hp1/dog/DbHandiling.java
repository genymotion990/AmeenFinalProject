package com.example.hp1.dog;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Hp1 on 20/02/2018.
 */

public class DbHandiling extends SQLiteOpenHelper {

    private static DbHandiling sInstance;
    public static final int DATABASE_VERSION = 8;

    public static final String DATABASE_NAME = "Dogs.db";
    public static final String TABLE_NAME = "dogstable";

    public static final String COl_1 = "id";
    public static final String COL_2 = "photo";


    public DbHandiling(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized DbHandiling getInstance(Context context) {

        if (sInstance == null) {
            sInstance = new DbHandiling(context.getApplicationContext());
        }
        return sInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //in case table already exists need to drop then re build
        //save query to create table in database according to requirements in a string variable

        String query = " CREATE TABLE " + TABLE_NAME
                + "(" + COl_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_2 + " BLOB"
                + ");";
        Log.d("QUERY", query);

        try {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            db.execSQL(query);
        } catch (Exception e) {
            Log.d("Couldn't add table", e.getMessage());
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertData(byte[] bytes) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, bytes);

        long id = db.insert(TABLE_NAME, null, contentValues);
        Log.d("ADDED to DB",id+"  "+bytes.length);
    }

    public ArrayList<Bitmap> getAllData() {
        Bitmap bitmap;
        String r;

        ArrayList<Bitmap> pics = new ArrayList<Bitmap>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("Select * from " + TABLE_NAME, null);
        c.moveToFirst();

        int col = c.getColumnIndex(COL_2);
        int id = c.getColumnIndex(COl_1);

        while (!c.isAfterLast()) {
            {
                byte[] bytes = c.getBlob(col);
                if(bytes != null) {
                    pics.add(BitmapFactory.decodeByteArray(bytes, 0, bytes.length));
                }
                c.moveToNext();
            }
        }

        return pics;
    }
}

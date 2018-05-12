package com.example.hp1.dog;


import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

public class ShowPics extends AppCompatActivity {

    Bitmap bitmap;
    DbHandiling dbHandiling;

    //need to fix exception
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_pics);

        dbHandiling=DbHandiling.getInstance(this);

        ListView listView = (ListView) findViewById(R.id.lvDogs);
        ArrayList<Bitmap> pics=dbHandiling.getAllData();
        CustomAdapter adapter = new CustomAdapter(this, R.layout.custom_row, pics);
        listView.setAdapter(adapter);


    }
}

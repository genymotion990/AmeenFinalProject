package com.example.hp1.dog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class DogBreeds extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView lvBreeds;
    ArrayAdapter<String> adapter;
    String[] breeds={"pitbull","doberman","poodle","german shepherd","jack russell","dogs benefits"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_breeds);
        lvBreeds=(ListView)findViewById(R.id.lvBreeds);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,breeds);
        lvBreeds.setAdapter(adapter);
        lvBreeds.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Intent i=new Intent(this,About.class);
        i.putExtra("info",position);
        startActivity(i);
    }
}
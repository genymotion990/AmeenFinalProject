package com.example.hp1.dog;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class MainPage extends AppCompatActivity implements View.OnClickListener {

    Button btAbout, btDog, btProfile,btShowPics;
    public int NOTIFICATION_CODE=0;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        btAbout=(Button)findViewById(R.id.btAbout);
        btAbout.setOnClickListener(this);
        btDog=(Button)findViewById(R.id.button7);
        btDog.setOnClickListener(this);
        btProfile=(Button)findViewById(R.id.button5);
        btProfile.setOnClickListener(this);
        btShowPics=(Button)findViewById(R.id.btShowPics);
        btShowPics.setOnClickListener(this);
        setNotification();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                startActivity(new Intent(this,About.class));
                break;
            case R.id.log_out:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Exit");
        builder.setMessage("are you sure you want to exit the app");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();

    }

    @Override
    public void onClick(View view) {
        if(view == btAbout){
            Intent i=new Intent(this,About.class);
            i.putExtra("info",6);
            startActivity(i);
        }
        if(view==btDog){
            startActivity(new Intent(this,DogBreeds.class));
        }

       if(view==btProfile){
            startActivity(new Intent(this,Profile.class));

        }
        if(view==btShowPics){
            startActivity(new Intent(this,ShowPics.class));

        }
    }

    public void setNotification(){

        AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);//initialize
        Calendar calendar=Calendar.getInstance();//get the current time
        calendar.set(Calendar.HOUR_OF_DAY,2);//set the notification to go of at 9 o'clock
        calendar.set(Calendar.MINUTE,16);//12 minutes
        calendar.set(Calendar.SECOND,0);//and 0 seconds
        Intent intent1=new Intent("singh.ajit.action.DISPLAY_NOTIFICATION");//create the intent
        PendingIntent pendingIntent=PendingIntent.getBroadcast(MainPage.this,NOTIFICATION_CODE,intent1,PendingIntent.FLAG_UPDATE_CURRENT);//create the pending intent that will luached at the wanted time
        alarmManager.setExact(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis()+AlarmManager.INTERVAL_HALF_DAY,pendingIntent);//set the alarm maneger to go off on the wanted time and start the pending intent

    }
}
package com.example.hp1.dog;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;

public class Profile extends AppCompatActivity implements View.OnClickListener{

    private Bitmap bitmap;
    ImageView imageView;
    Button btGallery,btCamera,btSave;
    DbHandiling myDB;
    static final int SELECT_IMAGE=1;
    static final int TAKE_IMAGE=0;

    byte[] bytes;
    private NotificationCompat.Builder builder;
    SharedPreferences preferences;

    //need to fix saving image
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        imageView=(ImageView)findViewById(R.id.imageView2);
        btCamera=(Button)findViewById(R.id.btCamera);
        btGallery=(Button)findViewById(R.id.btGallery);
        btSave=(Button)findViewById(R.id.btsave);
        btCamera.setOnClickListener(this);
        btGallery.setOnClickListener(this);
        btSave.setOnClickListener(this);
        preferences=getSharedPreferences("path",MODE_PRIVATE);

        String path = preferences.getString("path",null);
        if(path!=null)
        {
            bitmap=BitmapFactory.decodeFile(path);
            imageView.setImageBitmap(bitmap);
        }

        myDB=DbHandiling.getInstance(this);
    }

    @Override
    public void onClick(View v) {
        if(v==btCamera)
        {
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i,TAKE_IMAGE);
        }
        else
        if(v==btGallery)
        {
            Intent i = new Intent(Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i, SELECT_IMAGE);
        }else
        if(v==btSave){
            if(bitmap!=null)
                bytes=convertBitmapToByteArray(bitmap);
            myDB.insertData(bytes);
            notification();
        }
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
                break;
            case R.id.log_out:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == TAKE_IMAGE && resultCode == RESULT_OK){
            Bundle extra = data.getExtras();
            bitmap  = (Bitmap) extra.get("data");
            imageView.setImageBitmap(bitmap);
        }
        else if(requestCode == SELECT_IMAGE && resultCode == RESULT_OK)
        {
            Uri targetUri = data.getData();
            Toast.makeText(getApplicationContext(), targetUri.toString(), Toast.LENGTH_SHORT).show();
            //textTargetUri.setText(targetUri.toString());

            try {

                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public byte[] convertBitmapToByteArray(Bitmap bmp){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();

        return byteArray;
    }
    public void notification(){
        //create builder object
        builder = new NotificationCompat.Builder(this);

        //customize the builder
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle("Dog Breeds Notification");
        builder.setContentText("A new Picture was added click notification to see all pictures");

        //
        Intent bIntent = new Intent(this, ShowPics.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, bIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);
        NotificationManager manager = (NotificationManager) getSystemService(getApplicationContext().NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }
}

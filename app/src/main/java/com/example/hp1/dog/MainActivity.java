package com.example.hp1.dog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    Button bt;
    EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=(Button)findViewById(R.id.button);
        et1=(EditText)findViewById(R.id.editText);
        et2=(EditText)findViewById(R.id.editText2);
        bt.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(!et1.getText().toString().equals("")&&!et2.getText().toString().equals(""))
        {
            startActivity(new Intent(this,MainPage.class));
        }
    }
}

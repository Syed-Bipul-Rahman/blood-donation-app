package com.rokterkhoje.userapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    //global variables
LinearLayout postrequest,statusfeed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //initializing variables
        postrequest=findViewById(R.id.postrequest);
        statusfeed=findViewById(R.id.statusfeed);

        //send to post reques page
        postrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,PostBloodRequestActivity.class));
            }
        });

        //send to status feed
        statusfeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,StatusfeedActivity.class));
            }
        });

    }
}
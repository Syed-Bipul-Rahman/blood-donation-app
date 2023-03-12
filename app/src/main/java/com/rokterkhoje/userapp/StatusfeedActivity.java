package com.rokterkhoje.userapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class StatusfeedActivity extends AppCompatActivity {
RecyclerView statusfeedrecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statusfeed);

        //initialize

        initializing();


    }

    private void initializing() {
        statusfeedrecycler=findViewById(R.id.statusfeedrecycler);
    }
}
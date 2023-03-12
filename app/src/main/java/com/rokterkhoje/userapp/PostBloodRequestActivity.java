package com.rokterkhoje.userapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.lang.reflect.Array;

public class PostBloodRequestActivity extends AppCompatActivity {
Spinner spinnerlocation,spinnerbloodgroup;
    private ArrayAdapter<CharSequence> bloodspineradapter,locationspinneradapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_blood_request);

        //initialization of variables
        spinnerbloodgroup=findViewById(R.id.spinnerbloodgroup);
        spinnerlocation=findViewById(R.id.spinnerlocation);
//for blood group spinner
bloodspineradapter= ArrayAdapter.createFromResource(this,R.array.blood_roup,R.layout.spinner_layout);
bloodspineradapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

spinnerbloodgroup.setAdapter(bloodspineradapter);


//for area spinner
        locationspinneradapter= ArrayAdapter.createFromResource(this,R.array.array_division,R.layout.spinner_layoutn);
        locationspinneradapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerlocation.setAdapter(locationspinneradapter);

    }
}
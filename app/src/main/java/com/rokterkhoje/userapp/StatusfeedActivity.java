package com.rokterkhoje.userapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rokterkhoje.userapp.Adapter.DataAdapter;
import com.rokterkhoje.userapp.Models.DataModel;

import java.util.ArrayList;
import java.util.List;

public class StatusfeedActivity extends AppCompatActivity {
    RecyclerView statusfeedrecycler;
    DataAdapter dataAdapter;
List<DataModel> dataModelList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statusfeed);



        //dummy data for recycler view
        dataModelList.add(new DataModel(1,"AB+","hazipara road","need blood for siger","sylhet","20-12-22","01793915828"));
        dataModelList.add(new DataModel(1,"AB+","hazipara road","need blood for siger","sylhet","20-12-22","01793915828"));
        dataModelList.add(new DataModel(1,"AB+","hazipara road","need blood for siger","sylhet","20-12-22","01793915828"));
        initializing();
        setAdapeter(dataModelList);

    }

    private void initializing() {
        statusfeedrecycler = findViewById(R.id.statusfeedrecycler);
    }

    private void setAdapeter(List<DataModel> dataModels) {
        dataAdapter = new DataAdapter(this, dataModels);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        statusfeedrecycler.setLayoutManager(linearLayoutManager);
        statusfeedrecycler.setAdapter(dataAdapter);

    }
}
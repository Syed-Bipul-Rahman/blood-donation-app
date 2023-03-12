package com.rokterkhoje.userapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rokterkhoje.userapp.Adapter.DataAdapter;
import com.rokterkhoje.userapp.Api.ApiClient;
import com.rokterkhoje.userapp.Api.ApiInterface;
import com.rokterkhoje.userapp.Models.DataModel;
import com.rokterkhoje.userapp.Response.GetDataResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class StatusfeedActivity extends AppCompatActivity {
    RecyclerView statusfeedrecycler;
    DataAdapter dataAdapter;


    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statusfeed);

        initializing();
        getdata();

    }

    private void initializing() {
        statusfeedrecycler = findViewById(R.id.statusfeedrecycler);
        Retrofit retrofit = ApiClient.getclient();
        apiInterface = retrofit.create(ApiInterface.class);

    }

    private void setAdapeter(List<DataModel> dataModels) {
        dataAdapter = new DataAdapter(this, dataModels);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        statusfeedrecycler.setLayoutManager(linearLayoutManager);
        statusfeedrecycler.setAdapter(dataAdapter);

    }

    private void getdata() {
        apiInterface.getData().enqueue(new Callback<GetDataResponse>() {
            @Override
            public void onResponse(Call<GetDataResponse> call, Response<GetDataResponse> response) {
                try {
                    if (response != null) {
                        if (response.body().getStatus().equals("1")) {
                            setAdapeter(response.body().getData());
                        } else {
                            Toast.makeText(StatusfeedActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (Exception e) {
                    Log.e("exp", e.getLocalizedMessage());
                }
            }

            @Override
            public void onFailure(Call<GetDataResponse> call, Throwable t) {
                Log.e("failer", t.getLocalizedMessage());
            }
        });
    }

}
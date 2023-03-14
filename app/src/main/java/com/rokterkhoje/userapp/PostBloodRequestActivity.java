package com.rokterkhoje.userapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rokterkhoje.userapp.Api.ApiClient;
import com.rokterkhoje.userapp.Api.ApiInterface;
import com.rokterkhoje.userapp.Response.AddRequestResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PostBloodRequestActivity extends AppCompatActivity {
    //global variables
    Spinner spinnerlocation, spinnerbloodgroup;

    String hospitalareatxt, phonenotxt, adddetailstxt, bloodgroup, location;
    EditText hospitalarea, phoneno, adddetails;
    //buttons
    Button postrequest;

    //arrayadapter
    private ArrayAdapter<CharSequence> bloodspineradapter, locationspinneradapter;

    //api interface object
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_blood_request);

        //initialization of variables

        //spinner
        spinnerbloodgroup = findViewById(R.id.spinnerbloodgroup);
        spinnerlocation = findViewById(R.id.spinnerlocation);

        //edittext
        hospitalarea = findViewById(R.id.hospitalarea);
        phoneno = findViewById(R.id.phoneno);
        adddetails = findViewById(R.id.adddetails);
        //buttons
        postrequest = findViewById(R.id.postbloodrequest_btn);
//api interface initialization
        Retrofit retrofit = ApiClient.getclient();
        apiInterface = retrofit.create(ApiInterface.class);


//for blood group spinner
        bloodspineradapter = ArrayAdapter.createFromResource(this, R.array.blood_roup, R.layout.spinner_layout);
        bloodspineradapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//set adapter
        spinnerbloodgroup.setAdapter(bloodspineradapter);


//for area spinner
        locationspinneradapter = ArrayAdapter.createFromResource(this, R.array.array_division, R.layout.spinner_layoutn);
        locationspinneradapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//set adapter
        spinnerlocation.setAdapter(locationspinneradapter);


        postrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//get data from spinners and convert to string
                bloodgroup = spinnerbloodgroup.getSelectedItem().toString();
                location = spinnerlocation.getSelectedItem().toString();

                //another strings get from edittext
                hospitalareatxt = hospitalarea.getText().toString();
                phonenotxt = phoneno.getText().toString();
                adddetailstxt = adddetails.getText().toString();

//logical conditions to check if data is empty than make a toast to show
                if (bloodgroup.equals("Select Blood Group")) {
                    Toast.makeText(PostBloodRequestActivity.this, "Select Blood group", Toast.LENGTH_SHORT).show();
                } else if (location.equals("Select Your District")) {
                    Toast.makeText(PostBloodRequestActivity.this, "Select District", Toast.LENGTH_SHORT).show();

                } else if (hospitalareatxt.equals("")) {
                    //show error if edittext is empty
                    hospitalarea.setError("Fill out this filed");


                } else if (phonenotxt.equals("")) {
                    //show error if edittext is empty
                    phoneno.setError("Fill out this filed");


                } else if (adddetailstxt.equals("")) {
                    //show error if edittext is empty
                    adddetails.setError("Fill out this filed");


                } else {
                    //after all validation call api
                    callapi(bloodgroup, hospitalareatxt, location, phonenotxt, adddetailstxt);

                }


            }
        });


    }


    private void callapi(String blood_group, String hospital_area, String location, String phone, String details) {
        apiInterface.addRequest(blood_group, hospital_area, location, phone, details).enqueue(new Callback<AddRequestResponse>() {
            @Override
            public void onResponse(Call<AddRequestResponse> call, Response<AddRequestResponse> response) {
                try {

                    if (response.body().getStatus().equals("1")) {
                        Toast.makeText(PostBloodRequestActivity.this, "Request Added Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(PostBloodRequestActivity.this, response.body().getMassage().toString(), Toast.LENGTH_SHORT).show();

                    }


                } catch (Exception e) {

                    Log.e("exp", e.getLocalizedMessage());
                    Toast.makeText(PostBloodRequestActivity.this, "Response Failure,Exception! ", Toast.LENGTH_LONG).show();


                }


            }

            @Override
            public void onFailure(Call<AddRequestResponse> call, Throwable t) {

                Log.e("failer", t.getLocalizedMessage());

                Toast.makeText(PostBloodRequestActivity.this, "Failed to post Request!", Toast.LENGTH_LONG).show();


            }
        });
    }

}
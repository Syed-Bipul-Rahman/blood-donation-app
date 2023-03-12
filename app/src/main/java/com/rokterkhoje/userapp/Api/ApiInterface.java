package com.rokterkhoje.userapp.Api;

import com.rokterkhoje.userapp.Response.GetDataResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("allrequest.php")
    Call<GetDataResponse> getData();
}

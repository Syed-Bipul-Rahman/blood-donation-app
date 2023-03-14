package com.rokterkhoje.userapp.Api;

import com.rokterkhoje.userapp.Response.AddRequestResponse;
import com.rokterkhoje.userapp.Response.GetDataResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("allrequest.php")
    Call<GetDataResponse> getData();

    @FormUrlEncoded
    @POST("blood-request.php")
    Call<AddRequestResponse> addRequest(@Field("blood_group") String blood_groupData,
                                        @Field("hospital_area") String hospital_areaData,
                                        @Field("location") String locationData,
                                        @Field("phone") String phoneData,
                                        @Field("details") String detailsData);




}

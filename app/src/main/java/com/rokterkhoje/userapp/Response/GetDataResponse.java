package com.rokterkhoje.userapp.Response;

import com.rokterkhoje.userapp.Models.DataModel;

import java.util.List;

public class GetDataResponse {

    String status;
    String message;
    List<DataModel> data;
    //genarate constractor,getter and setters


    public GetDataResponse(String status, String message, List<DataModel> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataModel> getData() {
        return data;
    }

    public void setData(List<DataModel> data) {
        this.data = data;
    }
}
